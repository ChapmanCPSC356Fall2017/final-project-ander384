package todolist.christine.anderson.todolist.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.content.ClipData;

import java.util.List;

import todolist.christine.anderson.todolist.models.ToDoItemModel;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by Christine on 11/24/2017.
 */

@Dao
public interface ItemDao
{
    @Query("SELECT * FROM todoitemmodel")
    List<ToDoItemModel> getAllItems();

    @Query("UPDATE todoitemmodel SET title= :theTitle WHERE id = :theId")
    public int setTitleById(String theId, String theTitle);

    @Query("UPDATE todoitemmodel SET description= :theDescription WHERE id = :theId")
    public int setDescriptionById(String theId, String theDescription);

    @Query("select * from todoitemmodel where id = :id")
    ToDoItemModel getItembyId(String id);

    @Insert(onConflict = REPLACE)
    void addItem(ToDoItemModel item);

    @Delete
    void deleteItem(ToDoItemModel item);

    @Update
    void updateItem(ToDoItemModel item);
}
