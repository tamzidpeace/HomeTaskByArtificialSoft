package com.example.arafat.recyclerviewpluscardview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    private ArrayList<ExampleItem> mExampleList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView id, user, name, who;

        public ExampleViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.imageView);
            id = itemView.findViewById(R.id.id);
            user = itemView.findViewById(R.id.user);
            name = itemView.findViewById(R.id.name);
            who = itemView.findViewById(R.id.who);

            // on clickable
            // this is important part and little bit confusing

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null) {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.example_item, viewGroup, false);
        ExampleViewHolder evh = new ExampleViewHolder(v, mListener);
        return evh;
    }

    public ExampleAdapter(ArrayList<ExampleItem>examplelist) {
        mExampleList = examplelist;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder exampleViewHolder, int i) {
        ExampleItem currentItem = mExampleList.get(i);
        exampleViewHolder.mImageView.setImageResource(currentItem.getmImageResource());
        exampleViewHolder.id.setText(currentItem.getmText1());
        exampleViewHolder.user.setText(currentItem.getmText2());
        exampleViewHolder.name.setText(currentItem.getName());
        exampleViewHolder.who.setText(currentItem.getWho());
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}
