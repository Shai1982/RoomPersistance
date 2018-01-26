package com.roompersistance.shais.roompersistance.RecyclerViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.roompersistance.shais.roompersistance.R;
import com.roompersistance.shais.roompersistance.RoomPersistance.User;

import java.util.List;

/**
 * Created by shais on 01/26/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<User> list;
    private Context context;

    public RecyclerAdapter(List<User> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.user_data,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        User user = list.get(position);

        holder.id.setText(String.valueOf(user.getUid()));
        holder.name.setText(user.getName());
        holder.last.setText(user.getLast());
        holder.phone.setText(user.getPhone_number());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView id,name,last, phone;

        public MyViewHolder(View view) {
            super(view);
            id = view.findViewById(R.id.uid);
            name = view.findViewById(R.id.name);
            last = view.findViewById(R.id.last);
            phone = view.findViewById(R.id.phone);
        }
    }
}
