package todolist.christine.anderson.todolist.database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.persistence.room.Update;
import android.os.AsyncTask;

import java.util.Collections;
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

        ToDoItemModel.ToDoItemComparator comparator = new ToDoItemModel.ToDoItemComparator();
        Collections.sort(toDoItemList, comparator);
    }


    public void addItem(ToDoItemModel itemModel)
    {
        toDoItemList.add(itemModel);
        new AddAsyncTask(appDatabase).execute(itemModel);
    }

    public void updateItem(ToDoItemModel itemModel)
    {
        new UpdateAsyncTask(appDatabase).execute(itemModel);
        ToDoItemModel.ToDoItemComparator comparator = new ToDoItemModel.ToDoItemComparator();
        Collections.sort(toDoItemList, comparator);
    }

    public List<ToDoItemModel> getToDoItemList() {
        return toDoItemList;
    }

    public void deleteItem(ToDoItemModel itemModel) {
        toDoItemList.remove(itemModel);
        new DeleteAsyncTask(appDatabase).execute(itemModel);
    }

    private static class UpdateAsyncTask extends AsyncTask<ToDoItemModel, Void, Void> {

        private AppDatabase db;

        UpdateAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final ToDoItemModel... params) {
            db.getItemDao().updateItem(params[0]);
            return null;
        }

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

    private static class AddAsyncTask extends AsyncTask<ToDoItemModel, Void, Void>
    {
        private AppDatabase db;

        AddAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final ToDoItemModel... params) {
            db.getItemDao().addItem(params[0]);
            return null;
        }

    }
}
