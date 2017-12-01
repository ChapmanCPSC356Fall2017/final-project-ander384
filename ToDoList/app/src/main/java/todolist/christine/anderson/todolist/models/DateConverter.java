package todolist.christine.anderson.todolist.models;

import android.arch.persistence.room.TypeConverter;

import org.joda.time.DateTime;

/**
 * Created by Christine on 12/1/2017.
 */

public class DateConverter {

    @TypeConverter
    public static DateTime toDate(Long timestamp) {
        return timestamp == null ? null : new DateTime(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(DateTime date) {
        return date == null ? null : date.getMillis();
    }

}
