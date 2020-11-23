package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
private EditText edName, edPoroda, edSity, edAge;
private DatabaseReference mDataBase;
private String USER_KEY = "User";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init ()
    {
        edName = findViewById(R.id.edName);
        edSity = findViewById(R.id.edSity);
        edAge = findViewById(R.id.edAge);
        edPoroda = findViewById(R.id.edPoroda);
        mDataBase = FirebaseDatabase.getInstance().getReference(USER_KEY);
    }


    public void onClickSave (View view)
    {
    String id = mDataBase.getKey();
    String name = edName.getText().toString();
    String poroda = edPoroda.getText().toString();
    String sity = edSity.getText().toString();
    String age = edAge.getText().toString();
    Cat newUser = new Cat(id, name, poroda, sity, age);
    if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(poroda) && !TextUtils.isEmpty(sity) && !TextUtils.isEmpty(age))
    {
        Toast.makeText(this, "Все сохранено ", Toast.LENGTH_SHORT).show();
        mDataBase.push().setValue(newUser);
    }
    else
    {
        Toast.makeText(this, "Пустое поле", Toast.LENGTH_SHORT).show();
    }

    }
    public void onClickRead(View view)
    {
    Intent i = new Intent(MainActivity.this, ReadActivity.class);
    startActivity(i);
    }

}