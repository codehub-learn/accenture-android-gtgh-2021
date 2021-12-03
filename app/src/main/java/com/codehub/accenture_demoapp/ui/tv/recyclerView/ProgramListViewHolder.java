package com.codehub.accenture_demoapp.ui.tv.recyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codehub.accenture_demoapp.R;
import com.codehub.accenture_demoapp.ui.tv.model.ProgramItemListUiModel;

public class ProgramListViewHolder extends RecyclerView.ViewHolder {

    public ProgramListViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void bind(ProgramItemListUiModel data) {
        ImageView img = itemView.findViewById(R.id.list_item_img);
        img.setImageResource(R.mipmap.ic_launcher);
//        img.setImageResource(data.getImage());
        TextView title = itemView.findViewById(R.id.list_item_txt);
        title.setText(data.getTitle());
    }
}
