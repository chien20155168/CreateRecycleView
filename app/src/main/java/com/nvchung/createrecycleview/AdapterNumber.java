package com.nvchung.createrecycleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterNumber extends RecyclerView.Adapter<AdapterNumber.MHolder> {
    private Context context;
    private List<Integer> listNumber;
    private ItemClick itemClick;

    public AdapterNumber(Context context,ItemClick itemClick) {
        this.context = context;
        this.itemClick = itemClick;
        //Data
        listNumber = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            listNumber.add(i);
        }
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_number, viewGroup,false);
        return new MHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MHolder mHolder, int i) {
        //getData
        int number = listNumber.get(i);
        //setData
        mHolder.numberView.setText(number+"");
    }

    @Override
    public int getItemCount() {
        return listNumber.size();
    }

    public class MHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView numberView;
        public MHolder(@NonNull View itemView) {
            super(itemView);
            numberView = itemView.findViewById(R.id.row_number);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClick.onItemClick(getAdapterPosition());
        }
    }

    interface ItemClick {
        void onItemClick(int pos);
    }

}
