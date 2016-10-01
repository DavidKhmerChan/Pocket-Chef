package davidchan.pocketchef;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by Kenneth on 10/1/2016.
 */

public class SettingFragments extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
