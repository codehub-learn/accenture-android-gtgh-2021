package com.codehub.accenture_demoapp.ui.tv.recyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codehub.accenture_demoapp.R;
import com.codehub.accenture_demoapp.ui.tv.model.ProgramItemListUiModel;

import java.util.List;

public class ProgramListAdapter extends RecyclerView.Adapter<ProgramListViewHolder> {

    private List<ProgramItemListUiModel> arrayData;

    public ProgramListAdapter(List<ProgramItemListUiModel> arrayData) {
        this.arrayData = arrayData;
    }

    @NonNull
    @Override
    public ProgramListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new ProgramListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgramListViewHolder holder, int position) {
        ProgramItemListUiModel uiModel = arrayData.get(position);
        holder.bind(uiModel);
    }

    @Override
    public int getItemCount() {
        return arrayData.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.holder_program_list_item;
    }
}
