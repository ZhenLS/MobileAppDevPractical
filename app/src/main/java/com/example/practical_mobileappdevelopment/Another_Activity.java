package com.example.practical_mobileappdevelopment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Another_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another_);

        /** Act 2: Access from another activity
         *
         */

        // Extract data
        SharedPreferences pref_output = getSharedPreferences(
                "MySharedPreferences", 0);

        String name = pref_output.getString("Name", "N/A");
        String name_other = pref_output.getString("Name_other", "N/A");   // To check effect of default value
        int age = pref_output.getInt("Age", -1);
        int age_other = pref_output.getInt("Age_other", -1);
        double height = pref_output.getFloat("Height", -1);
        int weight = pref_output.getInt("Weight", -1);

        TextView textView = new TextView(this);
        textView.setTextSize(20.0f);
        textView.setText("This is from another activity..." +
                "\nName: " + name +
                "\nname: " + name_other + "" +
                "\nAge: " + age + "" +
                "\nAge_other: " + age_other + "" +
                "\nHeight: " + height + "" +
                "\nWeight: " + weight);

        setContentView(textView);
    }
}