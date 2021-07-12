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
        mySQLiteAdapter.insert("Nasi Lemak");
        mySQLiteAdapter.insert("Roti Canai");
        mySQLiteAdapter.insert("Char Kuey Tiao");
        mySQLiteAdapter.insert("Kuih Nyonya");
        mySQLiteAdapter.insert("Ulam");
        mySQLiteAdapter.insert("Nasi Kandar");
        mySQLiteAdapter.insert("Curry Laksa");
        mySQLiteAdapter.close();

        mySQLiteAdapter.openToRead();
        String contentRead = mySQLiteAdapter.queueAll();
        mySQLiteAdapter.close();

        listContent.setText(contentRead);
        li.addView(listContent);
        setContentView(li);
    }
}