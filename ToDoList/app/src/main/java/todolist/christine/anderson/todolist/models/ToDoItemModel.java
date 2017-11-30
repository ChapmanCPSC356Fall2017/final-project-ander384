package todolist.christine.anderson.todolist.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import org.joda.time.DateTime;

import java.util.Comparator;
import java.util.UUID;

/**
 * Created by Christine on 11/7/2017.
 */

@Entity
public class ToDoItemModel {

    @PrimaryKey (autoGenerate = true)
    private int dbId;

    private String id;

    private String title;

    private String description;

    @Ignore
    private DateTime date;

    public ToDoItemModel() {
        this.id = UUID.randomUUID().toString();
        this.date = DateTime.now();
        this.title = "";
        this.description = "";
    }

    public String dateToString() {
        String dayOfWeek = this.dayName();
        int dayOfMonth = date.getDayOfMonth();
        String month = this.monthName();
        int year = date.getYear();
        return dayOfWeek + " " + dayOfMonth + " " + month + ", " + year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id)
    {
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

    private String dayName() {
        switch (date.getDayOfWeek()) {
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
            default:
                return "No Day";

        }
    }


    private String monthName() {
        switch (date.getMonthOfYear()) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return "No Month";
        }

    }


    public static class DateComparator implements Comparator<ToDoItemModel> {
        @Override
        public int compare(ToDoItemModel item1, ToDoItemModel item2)
        {
            if (item1.getDate().getYear()<item2.getDate().getYear())
            {
                return -1;
            }
            else if(item1.getDate().getYear()>item2.getDate().getYear())
            {
                return 1;
            }
            else
            {
                if(item1.getDate().getMonthOfYear()<item2.getDate().getMonthOfYear())
                {
                    return -1;
                }
                else if(item1.getDate().getMonthOfYear()>item2.getDate().getMonthOfYear())
                {
                    return 1;
                }
                else
                {
                    if(item1.getDate().getDayOfMonth()<item2.getDate().getDayOfMonth())
                    {
                        return -1;
                    }
                    else if (item1.getDate().getDayOfMonth()>item2.getDate().getDayOfMonth())
                    {
                        return 1;
                    }
                    else
                    {
                        return 0;
                    }
                }
            }
        }


    }
}





