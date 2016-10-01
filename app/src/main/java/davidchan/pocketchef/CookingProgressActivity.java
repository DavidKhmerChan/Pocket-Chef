package davidchan.pocketchef;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ryan on 10/1/2016.
 */
//
public class CookingProgressActivity extends Activity{
    int i=0;
    Button timeButton;
    Button Advance;
    String recipeName;
    TextView steps;
    CountDownTimer timePerStep;
    ArrayList<String> ingredientList;
    TextView timer;
    long m= 60000;
    long s= 1000;
    long M=0, S=10;
    long totalTime;

    protected void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.activity_cooking_progress);
        Intent received = getIntent();
        timer = (TextView) findViewById(R.id.timer);
        timeButton = (Button) findViewById(R.id.addTime);
        Advance = (Button) findViewById(R.id.nextStep);

        totalTime= m*M + S*s;

        Bundle recipe=new Bundle();

        recipe = received.getExtras();
        recipeName = recipe.getString("recipeName");
        ingredientList =recipe.getStringArrayList("ingredients");
        steps = (TextView) findViewById(R.id.Step);
        steps.setText(recipeName);

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePerStep.cancel();
                Spinner getIt = (Spinner) findViewById(R.id.intervals);
                long addTime;
                int convert=getIt.getSelectedItemPosition();
                switch (convert){
                    case 0: addTime = 10 * s;
                        break;
                    case 1: addTime = 30 * s;
                        break;
                    case 2: addTime = m;
                        break;
                    case 3: addTime = 3 * m;
                        break;
                    case 4:addTime = 5 * m;
                        break;
                    case 5: addTime = 10 * m;
                        break;
                    case 6: addTime = 30 * m;
                        break;
                    case 7: addTime = 60 * m;
                        break;
                    default: addTime = 3* m;
                        break;
                }
                if((totalTime + addTime) >= 60*m){
                    totalTime = 59*m + 59*s;
                }
                else
                    totalTime += addTime;
                if(steps.getText()=="DONE!"){
                    timePerStep = timePerStep(0);
                }
                else {
                    timePerStep = timePerStep(totalTime);
                }
                timePerStep.start();
            }
        });

        timePerStep=timePerStep(totalTime);
        Advance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                steps.setText(recipeName+"HA!");
                if(i == 0){
                    steps.setText(recipeName + "\n" + ingredientList.get(i));
                    timePerStep.start();
                    i++;
                    Advance.setText("Next");
                } else if(i <ingredientList.size()){
                    timePerStep.cancel();
                    timePerStep.onTick(M);
                    timePerStep.start();
                    steps.setText(recipeName+ "\n" + ingredientList.get(i));
                    i++;
                } else if(i == ingredientList.size()){
                    timePerStep.cancel();
                    timePerStep.onFinish();
                    steps.setText("DONE!");
                    Advance.setText("DONE!");
                }
            }
        });
    }
    private CountDownTimer timePerStep(long Time){
        CountDownTimer newTime = new CountDownTimer(Time, S){
            @Override
            public void onTick(long millisUntilFinished) {
                long min = (millisUntilFinished / 1000) / 60;
                long sec = (millisUntilFinished / 1000) % 60;
                timer.setText(min + ":" + ((sec <10) ? "0"+ sec : sec));
            }
            @Override
            public void onFinish() {
                timer.setText("00:00");
                if(i <ingredientList.size()){
                    steps.setText(recipeName+ "\n" + ingredientList.get(i));
                    i++;
                    timePerStep.cancel();
                    timePerStep.onTick(M);
                    timePerStep.start();

                } else if(i >= ingredientList.size()){
                    timePerStep.cancel();
                    timer.setText("00:00");
                    steps.setText("DONE!");
                    Advance.setText("DONE!");
                }
            }
        };
        return newTime;
    }
}
