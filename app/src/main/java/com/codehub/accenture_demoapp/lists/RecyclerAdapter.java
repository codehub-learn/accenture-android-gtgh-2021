package com.codehub.accenture_demoapp.lists;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codehub.accenture_demoapp.R;
import com.codehub.accenture_demoapp.common.ViewHolderEmpty;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> arrayData;
    private RecyclerCallback callback;


    public RecyclerAdapter(List<String> arrayData, RecyclerCallback callback) {
        this.arrayData = arrayData;
        this.callback = callback;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return R.layout.holder_list_item_2;
        } else {
            return R.layout.holder_list_item;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        if (viewType == R.layout.holder_list_item) {
            return new RecyclerItemViewHolder(view, callback);
        } else if (viewType == R.layout.holder_list_item_2) {
            return new RecyclerItemViewHolder2(view, callback);
        } else {
            View emptyView = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_empty, parent, false);
            return new ViewHolderEmpty(emptyView);
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
}
