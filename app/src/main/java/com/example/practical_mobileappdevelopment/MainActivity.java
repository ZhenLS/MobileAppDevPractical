package com.example.practical_mobileappdevelopment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SQLiteAdapter mySQLiteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        LinearLayout li = new LinearLayout(this);
        li.setOrientation(LinearLayout.VERTICAL);
        TextView listContent = new TextView(this);
        listContent.setTextSize(20.0f);

        mySQLiteAdapter = new SQLiteAdapter(this);
        mySQLiteAdapter.openToWrite();
        mySQLiteAdapter.deleteAll();
        mySQLiteAdapter.insert("Nasi Lemak", "Rice", 10);
        mySQLiteAdapter.insert("Roti Canai", "Flour", 1);
        mySQLiteAdapter.insert("Char Kuey Tiao", "Kuey Tiao", 6);
        mySQLiteAdapter.insert("Kuih Nyonya", "Pandan", 2);
        mySQLiteAdapter.insert("Ulam", "Vege", 12);
        mySQLiteAdapter.insert("Nasi Kandar", "Rice", 15);
        mySQLiteAdapter.insert("Curry Laksa", "Noodles", 21);
        mySQLiteAdapter.close();

        mySQLiteAdapter.openToRead();
//        String contentRead = mySQLiteAdapter.queueMultipleColumn();
//        String contentRead = mySQLiteAdapter.queueMultipleColumnOnSelection();
        String contentRead = mySQLiteAdapter.queueWithOrder();
        mySQLiteAdapter.close();

        listContent.setText(contentRead);
        li.addView(listContent);
        setContentView(li);
    }
}