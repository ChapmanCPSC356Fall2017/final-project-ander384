package todolist.christine.anderson.todolist.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import todolist.christine.anderson.todolist.R;
import todolist.christine.anderson.todolist.adapters.ToDoListAdapter;

/**
 * Created by Christine on 11/13/2017.
 */

public class ToDoListFragment extends Fragment {

    private ToDoListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_to_do_list, container, false);

        RecyclerView toDoListView = viewGroup.findViewById(R.id.rv_to_do_list);

        adapter = new ToDoListAdapter();

        toDoListView.setAdapter(adapter);

        toDoListView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return viewGroup;


    }
}
