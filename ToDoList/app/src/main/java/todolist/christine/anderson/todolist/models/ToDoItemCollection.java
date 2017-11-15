package todolist.christine.anderson.todolist.models;

import org.joda.time.DateTimeComparator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Christine on 11/7/2017.
 */

public class ToDoItemCollection {

    private static ToDoItemCollection collection;

    public static ToDoItemCollection GetInstance()
    {
        if (collection ==null)
        {
            collection = new ToDoItemCollection();
        }

        return collection;
    }


    private List<ToDoItemModel> toDoItems;

    private ToDoItemCollection()
    {
        this.toDoItems = new ArrayList<>();
        //TODO: This is temporary to make sure it works
        for(int i=0; i<100; ++i)
        {
            ToDoItemModel item = new ToDoItemModel();
            item.setTitle("Item "+(i+1));
            this.toDoItems.add(item);

        }
        Comparator comparator = new ToDoItemModel.DateComparator();
        Collections.sort(toDoItems, comparator);
    }

    public List<ToDoItemModel> getToDoItems()
    {
        return this.toDoItems;
    }

    public void addToDoItem(ToDoItemModel item)
    {
        this.toDoItems.add(item);
        Comparator comparator = new ToDoItemModel.DateComparator();
        Collections.sort(toDoItems, comparator);
    }

    public ToDoItemModel getToDoItem(String theId)
    {
        for(ToDoItemModel item: this.toDoItems)
        {
            if (item.getId().equals(theId))
            {
                return item;
            }
        }

        return null;

    }

}
