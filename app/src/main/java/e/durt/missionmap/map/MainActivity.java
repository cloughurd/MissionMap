package e.durt.missionmap.map;

import android.support.v4.app.Fragment;


public class MainActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new MyMapFragment();
    }
}
