package todolist.christine.anderson.todolist.database;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import todolist.christine.anderson.todolist.models.ToDoItemModel;

/**
 * Created by Christine on 11/24/2017.
 */


@Database(entities = {ToDoItemModel.class}, version = 4,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract ItemDao getItemDao();

    static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "myDatabase").allowMainThreadQueries().fallbackToDestructiveMigration().build();

        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}




