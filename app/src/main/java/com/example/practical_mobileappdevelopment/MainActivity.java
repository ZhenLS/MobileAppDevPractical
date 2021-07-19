package com.example.practical_mobileappdevelopment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        /** Shared Preference
         * 1. Use private mode normally
         * 2. Open up editor
         * 3. Put Data
         * 4. Commit changes
         * 5. Validate shared preference file
         */
        SharedPreferences preferences = getSharedPreferences("MySharedPreferences", MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = preferences.edit();

        // Insert some data: key & value
        prefEditor.putString("Name", "John");
        prefEditor.putInt("Age", 30);
        prefEditor.putFloat("Height", 181);
        prefEditor.putInt("Weight", 65);

        prefEditor.commit();

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
        textView.setText("Name: " + name +
                "\nname: " + name_other + "" +
                "\nAge: " + age + "" +
                "\nAge_other: " + age_other + "" +
                "\nHeight: " + height + "" +
                "\nWeight: " + weight);

//        setContentView(textView);

        /**
         * Q2: Access from another activity
         */
//        Intent intent = new Intent(this, Another_Activity.class);
//        startActivity(intent);

        /**
         * Q3: Reading Self Preference from another Activity
         */

        // Extract data
        SharedPreferences preferences_output = getSharedPreferences("Another_Activity",MODE_PRIVATE);

        int bankNo = preferences_output.getInt("Bank Account No", 0001);
        int bank_no_other = preferences_output.getInt("Bank Account other", -1);
        int total_MONEY = preferences_output.getInt("Amount", 0);
        name = preferences_output.getString("Beneficiary", "N/A");

        textView.setText("Reading from private preferences in Main Activity...\n" +
                "\nBank Account: " + bankNo + "" +
                "\nBank Account Other: " + bank_no_other + "" +
                "\nTotal Saving: " + total_MONEY + "" +
                "\nBeneficiary: " + name);

        setContentView(textView);


        /**
         * Q4: Writing to a file
         * Need to write in bytestream
         */
        FileOutputStream fileOutputStream;
        String strFileContents = "Lets write something is this file...";
        String fileName = "TempInput.txt";

        try {
            fileOutputStream = openFileOutput(fileName, MODE_PRIVATE);
            fileOutputStream.write(strFileContents.getBytes());
            fileOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();    // from getting file
        } catch (IOException e) {
            e.printStackTrace();    // from writing file content
        }

        textView.setText("File has successfully written");
        setContentView(textView);

        // Extract data from text file
        FileInputStream inputStream;
        StringBuffer buffer = new StringBuffer();
        BufferedReader bufferedReader;
        String strLine = null;

        try {
            inputStream = openFileInput(fileName);
            /** inputStream in byte form, convert using InputStreamReader
             * An InputStreamReader is a bridge from byte stream to character streams
             */
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            while((strLine = bufferedReader.readLine()) != null){
                buffer.append(strLine + "\nHello World");
            }
            inputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        textView.setText(new String(buffer));
        setContentView(textView);

        // Extra
        // To obtain the file directory for a specified text file
        File file = getFileStreamPath("Inputfile.txt");
        String s = file.getAbsolutePath();
        textView.setText(s);


        // To obtain only directory
        file = getFilesDir();
        s = file.getAbsolutePath();

        textView.setText(s);
        setContentView(textView);
    }
}