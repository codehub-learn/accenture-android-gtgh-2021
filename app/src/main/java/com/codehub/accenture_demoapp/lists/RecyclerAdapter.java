package com.codehub.accenture_demoapp.lists;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codehub.accenture_demoapp.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> arrayData;
    private RecyclerCallback callback;

    private int layout1 = 1;
    private int layout2 = 2;

    public RecyclerAdapter(List<String> arrayData, RecyclerCallback callback) {
        this.arrayData = arrayData;
        this.callback = callback;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == layout1) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_list_item, parent, false);
            return new RecyclerItemViewHolder(view, callback);
        } else if (viewType == layout2) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_list_item_2, parent, false);
            return new RecyclerItemViewHolder2(view, callback);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_list_item, parent, false);
            return new RecyclerItemViewHolder(view, callback);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        String data = arrayData.get(position);
        if (holder instanceof RecyclerItemViewHolder) {
            ((RecyclerItemViewHolder) holder).bind(data);
        } else if (holder instanceof RecyclerItemViewHolder2) {
            ((RecyclerItemViewHolder2) holder).bind(data);
        }
    }

    @Override
    public int getItemCount() {
        return arrayData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return layout2;
        } else {
            return layout1;
        }
    }
}
