package todolist.christine.anderson.todolist.models;

import android.app.Application;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;

import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import todolist.christine.anderson.todolist.database.ToDoListViewModel;

/**
 * Created by Christine on 11/7/2017.
 */

public class ToDoItemCollection {


    private static ToDoItemCollection collection;
    private Application app;

    public static ToDoItemCollection GetInstance(Application application)
    {
        if (collection ==null)
        {
            collection = new ToDoItemCollection(application);
        }
        collection.app = application;

        return collection;
    }


    private ToDoListViewModel listViewModel;

    private ToDoItemCollection(Application application)
    {
        this.listViewModel = new ToDoListViewModel(application);
    }

    public Collection<ToDoItemModel> getToDoItems()
    {
        return this.listViewModel.getToDoItemList();
    }

    public int getSize()
    {
        return this.listViewModel.getToDoItemList().size();
    }

    public ToDoItemModel get(int position)
    {
        return this.listViewModel.getToDoItemList().get(position);
    }

    public void addToDoItem(ToDoItemModel item)
    {
        this.listViewModel.addItem(item);
        //DateTimeComparator comparator = DateTimeComparator.getDateOnlyInstance();
        ToDoItemModel.ToDoItemComparator comparator = new ToDoItemModel.ToDoItemComparator();
        Collections.sort(listViewModel.getToDoItemList(), comparator);
    }

    public void reloadList()
    {
        collection = null;
        ToDoItemCollection.GetInstance(app);
    }

    public void updateToDoItem(ToDoItemModel item)
    {
        this.listViewModel.updateItem(item);
    }

    public void removeToDoItem(ToDoItemModel item)
    {
        this.listViewModel.deleteItem(item);
    }

    public ToDoItemModel getToDoItem(String theId)
    {
        for(ToDoItemModel item: listViewModel.getToDoItemList())
        {
            if (item.getId().equals(theId))
            {
                return item;
            }
        }

        return null;

    }

}
