package todolist.christine.anderson.todolist.database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;

import java.util.List;

import todolist.christine.anderson.todolist.models.ToDoItemModel;

/**
 * Created by Christine on 11/26/2017.
 */

public class ToDoListViewModel extends AndroidViewModel {

    private final List<ToDoItemModel> toDoItemList;

    private AppDatabase appDatabase;

    public ToDoListViewModel(Application application) {
        super(application);

        appDatabase = AppDatabase.getAppDatabase(this.getApplication());

        toDoItemList = appDatabase.getItemDao().getAllItems();
    }


    public void addItem(ToDoItemModel itemModel)
    {
        toDoItemList.add(itemModel);
        appDatabase.getItemDao().addItem(itemModel);
    }

    public void updateItem(ToDoItemModel itemModel)
    {
        appDatabase.getItemDao().updateItem(itemModel);
    }

    public List<ToDoItemModel> getToDoItemList() {
        return toDoItemList;
    }

    public void deleteItem(ToDoItemModel itemModel) {
        toDoItemList.remove(itemModel);
        new DeleteAsyncTask(appDatabase).execute(itemModel);
    }

    private static class DeleteAsyncTask extends AsyncTask<ToDoItemModel, Void, Void> {

        private AppDatabase db;

        DeleteAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final ToDoItemModel... params) {
            db.getItemDao().deleteItem(params[0]);
            return null;
        }

    }
}
