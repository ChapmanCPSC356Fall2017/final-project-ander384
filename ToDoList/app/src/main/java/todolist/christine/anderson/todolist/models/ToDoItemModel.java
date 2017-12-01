package todolist.christine.anderson.todolist.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;

import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;

import java.util.Comparator;
import java.util.UUID;

/**
 * Created by Christine on 11/7/2017.
 */

@Entity
public class ToDoItemModel {

    @PrimaryKey(autoGenerate = true)
    private int dbId;

    private String id;

    private String title;

    private String description;

    @TypeConverters(DateConverter.class)
    private DateTime date;

    public ToDoItemModel() {
        this.id = UUID.randomUUID().toString();
        this.date = DateTime.now();
        this.title = "";
        this.description = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getDbId() {
        return dbId;
    }

    public void setDbId(int dbId) {
        this.dbId = dbId;
    }

    public static class ToDoItemComparator implements Comparator<ToDoItemModel> {
        @Override
        public int compare(ToDoItemModel item1, ToDoItemModel item2) {
            DateTimeComparator comparator = DateTimeComparator.getDateOnlyInstance();
            if (comparator.compare(item1.getDate(), item2.getDate()) == -1) {
                return -1;
            } else if (comparator.compare(item1.getDate(), item2.getDate()) == 1) {
                return 1;
            } else {
                return 0;
            }

        }
    }
}





