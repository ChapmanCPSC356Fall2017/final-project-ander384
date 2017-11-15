package todolist.christine.anderson.todolist.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import todolist.christine.anderson.todolist.fragments.ToDoItemFragment;

/**
 * Created by Christine on 11/6/2017.
 */

public class ToDoItemActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment()
    {
        Bundle extras = getIntent().getExtras();
        ToDoItemFragment fragment = new ToDoItemFragment();
        fragment.setArguments(extras);
        return fragment;
    }


}
