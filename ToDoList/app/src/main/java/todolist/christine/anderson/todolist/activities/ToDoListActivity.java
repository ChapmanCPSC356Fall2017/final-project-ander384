package todolist.christine.anderson.todolist.activities;

import android.support.v4.app.Fragment;

import todolist.christine.anderson.todolist.fragments.ToDoListFragment;

/**
 * Created by Christine on 11/13/2017.
 */

public class ToDoListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new ToDoListFragment();
    }
}
