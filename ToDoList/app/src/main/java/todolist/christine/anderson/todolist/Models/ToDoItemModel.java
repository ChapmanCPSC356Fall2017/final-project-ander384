package todolist.christine.anderson.todolist.Models;

import org.joda.time.DateTime;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Christine on 11/7/2017.
 */

public class ToDoItemModel {

    private String id;
    private String title;
    private String description;
    private DateTime date;

    public ToDoItemModel()
    {
        this.id = UUID.randomUUID().toString();
        this.date = DateTime.now();
    }

    public String getId()
    {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

}
