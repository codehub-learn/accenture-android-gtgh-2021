package com.codehub.accenture_demoapp.lists;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codehub.accenture_demoapp.R;

public class RecyclerItemViewHolder2 extends RecyclerView.ViewHolder {

    private RecyclerCallback callback;

    public RecyclerItemViewHolder2(@NonNull View itemView, RecyclerCallback listener) {
        super(itemView);
        callback = listener;
    }

    public void bind(String data) {
        TextView textView = itemView.findViewById(R.id.list_item_txt);
        textView.setText(data);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onItemClicked(v, data);
//                Snackbar.make(v, "Clicked " + data, Snackbar.LENGTH_LONG).show();
            }
        });
    }
}
