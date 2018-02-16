package com.myagenda.myagenda;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView TimeClass, StartTime, EndTime;

        public ViewHolder(View itemView) {
            super(itemView);
            TimeClass = (TextView) itemView.findViewById(R.id.tvClass);
            StartTime = (TextView) itemView.findViewById(R.id.tvStartTime);
            EndTime = (TextView) itemView.findViewById(R.id.tvEndTime);
        }
    }

    public List<ItemCard> itemCardList;

    public RecyclerViewAdapter(List<ItemCard> itemCardList) {
        this.itemCardList = itemCardList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.TimeClass.setText(itemCardList.get(position).getTimeClass());
        holder.StartTime.setText(itemCardList.get(position).getStartTime());
        holder.EndTime.setText(itemCardList.get(position).getEndTime());
    }

    @Override
    public int getItemCount() {
        return itemCardList.size();
    }
}

