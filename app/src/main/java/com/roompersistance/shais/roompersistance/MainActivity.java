package com.roompersistance.shais.roompersistance;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.roompersistance.shais.roompersistance.RoomPersistance.AppDatabase;
import com.roompersistance.shais.roompersistance.RoomPersistance.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button create;
    private EditText enter_name,enter_last,enter_phone;
    private AppDatabase db;
    private List<User> userList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = Room.databaseBuilder(MainActivity.this,AppDatabase.class,"Users")
                .allowMainThreadQueries()
                .build();

        initViews();
    }

    private void initViews() {

        userList = new ArrayList<>();
        create = findViewById(R.id.btn_create);
        enter_name = findViewById(R.id.edt_enter_name);
        enter_last = findViewById(R.id.edt_last_name);
        enter_phone = findViewById(R.id.edt_phone_number);
    }

    public void createUser(View view) {
        if (enter_name.getText().toString().trim().equalsIgnoreCase(""))
        {
            enter_name.setError("This is mandatory field");
        }
        else if (enter_last.getText().toString().trim().equalsIgnoreCase(""))
        {
            enter_last.setError("This is mandatory field");

        }
        else if (enter_phone.getText().toString().trim().equalsIgnoreCase(""))
        {
            enter_last.setError("This is mandatory field");
        }
        else
        {
            userList.add(new User(enter_name.getText().toString(),enter_last.getText().toString(),enter_phone.getText().toString()));
            db.UserDao().insertAll(userList);
            enter_name.setText("");
            enter_last.setText("");
            enter_phone.setText("");
            Toast.makeText(MainActivity.this,"User where created successfully",Toast.LENGTH_LONG).show();
        }
    }

    public void nextActivity(View view) {
        startActivity(new Intent(MainActivity.this,QueryActivity.class));
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("name",enter_name.getText().toString());
        outState.putString("last",enter_last.getText().toString());
        outState.putString("phone",enter_phone.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        enter_name.setText(savedInstanceState.getString("name"));
        enter_last.setText(savedInstanceState.getString("last"));
        enter_phone.setText(savedInstanceState.getString("phone"));
    }
}
