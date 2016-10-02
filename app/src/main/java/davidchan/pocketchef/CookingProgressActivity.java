package davidchan.pocketchef;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan on 10/1/2016.
 */
//
public class CookingProgressActivity extends Activity{
    int i=0;
    Button skipStep;
    Button pauseButton;
    String recipeName;
    TextView steps;
    CountDownTimer timePerStep;
    List<Instruction> instructionList;
    TextView timer;
    long s= 1000;
    long totalTime;
    boolean pause=true;
    protected void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.activity_cooking_progress);
        Intent received = getIntent();
        timer = (TextView) findViewById(R.id.timer);
        skipStep = (Button) findViewById(R.id.skipStep);
        pauseButton = (Button) findViewById(R.id.pauseStep);

        Bundle recipe=new Bundle();

        recipe = received.getExtras();
        recipeName = recipe.getString("recipeName");
        instructionList =(List<Instruction>) recipe.getSerializable("instructions");

        steps = (TextView) findViewById(R.id.Step);

        totalTime= (long)instructionList.get(i).getDuration() *s;
        steps.setText(recipeName+ "\n" + instructionList.get(i).getInstruction());
        timePerStep=timePerStep(totalTime);
        setTimer(totalTime);
        skipStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePerStep.cancel();
                timer.setText("0:00");
                if(i<instructionList.size()){
                    steps.setText(recipeName+ "\n" + instructionList.get(i).getInstruction());
                    totalTime=(long)instructionList.get(i).getDuration() *s;
                    pause=true;
                    pauseButton.setText("Start");
                    timePerStep=timePerStep(totalTime);
                    setTimer(totalTime);
                    i++;
                }
                if(i >= instructionList.size()){
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
        CountDownTimer newTime = new CountDownTimer(Time, s){
            @Override
            public void onTick(long millisUntilFinished) {
                setTimer(millisUntilFinished);
            }
            @Override
            public void onFinish() {
                timer.setText("0:00");
                if(i<instructionList.size()){
                    steps.setText(recipeName+ "\n"+instructionList.get(i).getInstruction());
                    totalTime= (long)instructionList.get(i).getDuration() *s;
                    pause=true;
                    pauseButton.setText("Start");
                    timePerStep=timePerStep(totalTime);
                    setTimer(totalTime);
                    i++;
                }
                if(i >= instructionList.size()){
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
