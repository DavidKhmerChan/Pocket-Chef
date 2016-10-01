package davidchan.pocketchef;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        TextView imperial = (TextView) findViewById(R.id.metric_text);
        imperial.setText("Convert to Metric measurements");

    }
}
