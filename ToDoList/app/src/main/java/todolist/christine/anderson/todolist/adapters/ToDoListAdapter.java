package todolist.christine.anderson.todolist.adapters;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.joda.time.format.DateTimeFormat;

import todolist.christine.anderson.todolist.R;
import todolist.christine.anderson.todolist.activities.ToDoItemActivity;
import todolist.christine.anderson.todolist.models.ToDoItemCollection;
import todolist.christine.anderson.todolist.models.ToDoItemModel;

/**
 * Created by Christine on 11/13/2017.
 */

public class ToDoListAdapter extends RecyclerView.Adapter<ToDoListAdapter.ToDoItemHolder> {

    private Application application;

    public ToDoListAdapter(Application application)
    {
       this.application = application;
    }

    @Override
    public ToDoItemHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cell_to_do_item, parent, false);

        return new ToDoItemHolder(view);
    }

    @Override
    public void onBindViewHolder(ToDoItemHolder holder, int position)
    {
        ToDoItemModel item = ToDoItemCollection.GetInstance(application).get(position);

        holder.setup(item);
    }

    @Override
    public int getItemCount() {
        return ToDoItemCollection.GetInstance(application).getSize();
    }

    public class ToDoItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private ToDoItemModel toDoItem;
        private TextView toDoItemTitleTextView;
        private TextView dateTextView;

        ToDoItemHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            this.toDoItemTitleTextView = itemView.findViewById(R.id.tv_to_do_item_title);
            this.dateTextView = itemView.findViewById(R.id.tv_display_date);
        }

        void setup(ToDoItemModel itemModel)
        {
            this.toDoItem = itemModel;
            String title= itemModel.getTitle();
            if(title.equals(""))
            {
                title = "Untitled";
            }
            this.toDoItemTitleTextView.setText(title);
            this.dateTextView.setText(toDoItem.getDate().toString(DateTimeFormat.longDate()));
        }

        public void onClick(View itemView)
        {
            Intent intent = new Intent(itemView.getContext(), ToDoItemActivity.class);
            intent.putExtra("item_id", toDoItem.getId());
            itemView.getContext().startActivity(intent);
        }
    }
}
