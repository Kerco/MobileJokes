package aut.bme.jokes.ui.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import aut.bme.jokes.R;
import aut.bme.jokes.model.JokeModel;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder> {
    public List<JokeModel> dataset;

    public static class ActivityViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView jokeSetupTv;
        public TextView jokePunchLineTv;
        public ActivityViewHolder(View row) {
            super(row);
            this.jokeSetupTv = row.findViewById(R.id.jokeListRowSetupTv);
            this.jokePunchLineTv = row.findViewById(R.id.jokeListRowPunchLineTv);
        }
    }

    public ActivityAdapter(List<JokeModel> activities) {
        dataset = activities;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ActivityAdapter.ActivityViewHolder onCreateViewHolder(ViewGroup parent,
                                                                 int viewType) {
        View row = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_list_row, parent, false);
        ActivityViewHolder vh = new ActivityViewHolder(row);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ActivityViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        JokeModel item = dataset.get(position);
        holder.jokeSetupTv.setText(item.getSetup());
        holder.jokePunchLineTv.setText(item.getPunchline());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
