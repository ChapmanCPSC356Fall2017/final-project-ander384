package todolist.christine.anderson.todolist.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import todolist.christine.anderson.todolist.R;
import todolist.christine.anderson.todolist.models.ToDoItemCollection;
import todolist.christine.anderson.todolist.models.ToDoItemModel;

/**
 * Created by Christine on 11/14/2017.
 */

public class DatePickerFragment extends android.support.v4.app.Fragment{

    DatePicker changeDatePicker;
    ToDoItemModel theModel;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String theId = getArguments().getString("item_id");
        theModel = ToDoItemCollection.GetInstance(getActivity().getApplication()).getToDoItem(theId);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_date_picker, container, false);

        changeDatePicker = v.findViewById(R.id.dp_change_date);
        changeDatePicker.updateDate(theModel.getDate().getYear(), theModel.getDate().getMonthOfYear()-1, theModel.getDate().getDayOfMonth());

        return v;
    }
}
