package com.example.greenday;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Challenge_Adapter extends RecyclerView.Adapter<Challenge_Adapter.MyViewHolder> {

    public ArrayList<Item> list;
    public OnMyTouchListener listener = null;

    public Challenge_Adapter(ArrayList<Item> list){this.list = list;}

    public interface OnMyTouchListener{
        void onTouch(View v, int pos);
    }

    public void setOnMyTouchListener(OnMyTouchListener listener){this.listener = listener;}

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.challenge_list,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Challenge_Adapter.MyViewHolder holder, int position) {
        Item item = list.get(position);
        holder.type.setText(item.type);
        holder.name.setText(item.name);
        holder.intro.setText(item.intro);
        ImageView imageView = (ImageView)holder.image;

        ViewGroup.LayoutParams params = imageView.getLayoutParams();
        params.width = 150;
        params.height = 150;
        imageView.setLayoutParams(params);

        if(holder.type.getText().equals("용기"))
            imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.salad, null));

        if(holder.type.getText().equals("대중교통"))
            imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.bus, null));

        if(holder.type.getText().equals("텀블러")) {
            imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.re_tumbler, null));
        }

        if(holder.type.getText().equals("쓰레기"))
            imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.trash2, null));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView type;
        TextView name;
        TextView intro;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            type = itemView.findViewById(R.id.chall_type);
            name = itemView.findViewById(R.id.chall_title);
            intro = itemView.findViewById(R.id.chall_intro);
            image = itemView.findViewById(R.id.chall_img_1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAbsoluteAdapterPosition();
                    if(listener != null)
                        listener.onTouch(v, pos);
                }
            });

        }
    }
}
