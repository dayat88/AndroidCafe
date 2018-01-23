package com.mylibary.acer.androidcafe;

import android.content.Context;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.transition.Transition;

import java.util.List;

/**
 * Created by ACER on 1/23/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    List<Menu> menu;
    private LayoutInflater inflater;
    private Context context;

    public RecyclerAdapter(Context context, List<Menu> itemmenu) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.menu = itemmenu;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Menu current = menu.get(position);
        holder.setData(current, position);
        holder.setListeners();

    }

    @Override
    public int getItemCount() {
        return menu.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, kategori, price;
        ImageView thumbnail;
        int position;
        Menu current;

        View itemView;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;

            name = (TextView) itemView.findViewById(R.id.tvName);
            kategori = (TextView) itemView.findViewById(R.id.tvDescription);
            thumbnail = (ImageView) itemView.findViewById(R.id.img_row);
            price = (TextView) itemView.findViewById(R.id.tvPrice);

        }

        public void setData(Menu current, int position) {
            String imageUrl = "http://560057.youcanlearnit.net/services/images/" + current.getImage();
            Glide.with(context).load(imageUrl).into(thumbnail);

            this.name.setText(current.getItemName());
            this.kategori.setText(current.getCategory());
            this.price.setText("$" + current.getPrice());

            this.position = position;
            this.current = current;


        }

        public void setListeners() {

            itemView.setOnClickListener((new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FragmentCommunicator fragmentCommunicator = (FragmentCommunicator)
                            context;
                    fragmentCommunicator.displayDetail(current);
                }
            }
            ));

        }
    }
}


