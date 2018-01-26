package com.roompersistance.shais.roompersistance;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.roompersistance.shais.roompersistance.RecyclerViews.RecyclerAdapter;
import com.roompersistance.shais.roompersistance.RoomPersistance.AppDatabase;

public class QueryActivity extends AppCompatActivity {
    private RecyclerAdapter adapter;
    private RecyclerView recyclerView;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        db = Room.databaseBuilder(QueryActivity.this,AppDatabase.class,"Users")
                .allowMainThreadQueries()
                .build();



    }

    public void showAllUsers(View view) {

        recyclerView = findViewById(R.id.list_all_users);
        adapter = new RecyclerAdapter(db.UserDao().getAllUsers(), QueryActivity.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(QueryActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(QueryActivity.this, DividerItemDecoration.HORIZONTAL);
        recyclerView.addItemDecoration(itemDecoration);
    }

    public void fetchUser(View view) {
    }

    public void deleteAllUsers(View view) {

        db.UserDao().deleteUsers(db.UserDao().getAllUsers());
        Toast.makeText(QueryActivity.this,"Users where removed successfully",Toast.LENGTH_LONG).show();
        adapter.notifyDataSetChanged();

    }
}
