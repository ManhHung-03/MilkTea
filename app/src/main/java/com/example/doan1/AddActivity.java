package com.example.doan1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AddActivity extends AppCompatActivity {

    EditText edTitle,edPrice,edCategory;
    Button add_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        edTitle = findViewById(R.id.edTitle);
        edCategory = findViewById(R.id.edCategory);
        edPrice = findViewById(R.id.edPrice);
        add_button = findViewById(R.id.btnAdd);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Thêm sản phẩm");
        actionBar.setDisplayHomeAsUpEnabled(true);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addBook(edTitle.getText().toString().trim(),
                        edCategory.getText().toString().trim(),
                        Integer.valueOf(edPrice.getText().toString().trim()));
            }
        });
    }
}