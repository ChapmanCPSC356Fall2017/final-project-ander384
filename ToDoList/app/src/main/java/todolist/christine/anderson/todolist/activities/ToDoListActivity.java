package todolist.christine.anderson.todolist.activities;

import android.support.v4.app.Fragment;

import todolist.christine.anderson.todolist.fragments.ToDoItemFragment;

/**
 * Created by Christine on 11/6/2017.
 */

public class ToDoListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment()
    {
        return new ToDoItemFragment();
    }
}
