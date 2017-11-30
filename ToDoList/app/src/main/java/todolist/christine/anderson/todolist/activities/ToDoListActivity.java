package todolist.christine.anderson.todolist.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import java.util.Collections;

import todolist.christine.anderson.todolist.fragments.ToDoItemFragment;
import todolist.christine.anderson.todolist.fragments.ToDoListFragment;
import todolist.christine.anderson.todolist.models.ToDoItemCollection;
import todolist.christine.anderson.todolist.models.ToDoItemModel;

/**
 * Created by Christine on 11/13/2017.
 */

public class ToDoListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new ToDoListFragment();
    }

    public void onClickFloatingButton(View view) {
        ToDoItemModel newItem = new ToDoItemModel();
        //ToDoItemCollection.GetInstance(getApplication()).addToDoItem(newItem);
        Bundle bundle = new Bundle();
        bundle.putString("item_id", newItem.getId());
        Intent intent = new Intent(this, ToDoItemActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
