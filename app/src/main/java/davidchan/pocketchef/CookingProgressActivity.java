package davidchan.pocketchef;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ryan on 10/1/2016.
 */

public class CookingProgressActivity extends AppCompatActivity {
    int i=0;
    Button skipStep;
    Button pauseButton;
    String recipeName;
    TextView steps;
    CountDownTimer timePerStep;
    ArrayList<String> ingredientList;
    TextView timer;
    long m= 60000;
    long s= 1000;
    long M=0, S=10;
    long totalTime;
    boolean pause=true;
    protected void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.activity_cooking_progress);
        Intent received = getIntent();
        timer = (TextView) findViewById(R.id.timer);
        skipStep = (Button) findViewById(R.id.skipStep);
        pauseButton = (Button) findViewById(R.id.pauseStep);

        totalTime= m*M + S*s;

        Bundle recipe=new Bundle();

        recipe = received.getExtras();
        recipeName = recipe.getString("recipeName");
        ingredientList =recipe.getStringArrayList("ingredients");
        steps = (TextView) findViewById(R.id.Step);

        totalTime= m*M + S*s;
        steps.setText(recipeName+ "\n" + ingredientList.get(i));
        timePerStep=timePerStep(totalTime);
        setTimer(totalTime);
        skipStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePerStep.cancel();
                timer.setText("0:00");
                if(i<ingredientList.size()){
                    steps.setText(recipeName+ "\n"+ingredientList.get(i));
                    totalTime= m*M + s*S;
                    pause=true;
                    pauseButton.setText("Start");
                    timePerStep=timePerStep(totalTime);
                    setTimer(totalTime);
                    i++;
                }
                if(i >= ingredientList.size()){
                    pauseButton.setText("Done!");
                    steps.setText("Done!");
                    totalTime=0;
                }
            }
        });
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!pause){
                    timePerStep.cancel();
                    pause=!pause;
                    pauseButton.setText("Start");
                }
                else {
                    timePerStep=timePerStep(totalTime);
                    timePerStep.start();
                    pauseButton.setText("Stop");
                    pause = !pause;
                }
            }
        });
    }
    private CountDownTimer timePerStep(long Time){
        CountDownTimer newTime = new CountDownTimer(Time, S){
            @Override
            public void onTick(long millisUntilFinished) {
                setTimer(millisUntilFinished);
            }
            @Override
            public void onFinish() {
                timer.setText("0:00");
                if(i<ingredientList.size()){
                    steps.setText(recipeName+ "\n"+ingredientList.get(i));
                    totalTime= m*M + s*S;
                    pause=true;
                    pauseButton.setText("Start");
                    timePerStep=timePerStep(totalTime);
                    setTimer(totalTime);
                    i++;
                }
                if(i >= ingredientList.size()){
                    pauseButton.setText("Done!");
                    steps.setText("Done!");
                    totalTime = 0;
                }
            }
        };
        return newTime;
    }
    private void setTimer(long msTime){
        long min = (msTime / 1000) / 60;
        long sec = (msTime / 1000) % 60;
        totalTime=msTime;
        timer.setText(min + ":" + ((sec <10) ? "0"+ sec : sec));
    }
}
