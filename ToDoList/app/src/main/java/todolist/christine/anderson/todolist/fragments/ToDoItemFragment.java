package todolist.christine.anderson.todolist.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import todolist.christine.anderson.todolist.Models.ToDoItemModel;
import todolist.christine.anderson.todolist.R;

/**
 * Created by Christine on 11/6/2017.
 */

public class ToDoItemFragment extends Fragment {

    EditText titleEditText;
    EditText descriptionEditText;
    Button completeButton;

    private ToDoItemModel item;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.item = new ToDoItemModel();//TODO: temporary
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_to_do_item, container, false);

        titleEditText = v.findViewById(R.id.et_title);
        descriptionEditText = v.findViewById(R.id.et_description);
        completeButton = v.findViewById(R.id.btn_complete);

        this.titleEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                item.setTitle(editable.toString());
            }
        });

        this.descriptionEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                item.setDescription(editable.toString());
            }
        });

        return v;
    }
}
