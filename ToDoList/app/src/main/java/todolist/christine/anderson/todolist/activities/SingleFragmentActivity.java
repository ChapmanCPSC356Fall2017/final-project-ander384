package todolist.christine.anderson.todolist.activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import todolist.christine.anderson.todolist.R;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    //any class which extends this class must implement this method
    protected abstract Fragment getFragment();
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //inflates the layout, which is simply a frame layout fragment container
        setContentView(R.layout.activity_single_fragment);

        showFragment(getFragment());
    }

    private void showFragment(Fragment fragment)
    {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_fragment_container, fragment)
                .commit();
    }
}
