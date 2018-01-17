package nyc.c4q.midtermretake.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.midtermretake.R;
import nyc.c4q.midtermretake.model.Numbers;
import nyc.c4q.midtermretake.views.NumbersViewHolder;

/**
 * Created by AmyRivera on 1/16/18.
 */
public class NumbersAdapter extends RecyclerView.Adapter<NumbersViewHolder> {
    private List<Numbers> numbersList;

    public NumbersAdapter(List<Numbers> numbersList) {
        this.numbersList = numbersList;
    }

    @Override
    public NumbersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.number_item_view,parent,false);
        return new NumbersViewHolder(v);
    }

    @Override
    public void onBindViewHolder(NumbersViewHolder holder, int position) {
        Numbers numbers = numbersList.get(position);
        holder.onBind(numbers);
    }

    @Override
    public int getItemCount() {
        return numbersList.size();
    }
}
