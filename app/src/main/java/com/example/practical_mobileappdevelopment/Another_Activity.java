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


        /**
         * Q3: Self Preferences
         */
        SharedPreferences preferences_self = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor pref_editor = preferences_self.edit();

        pref_editor.putInt("Bank Account No", 843924432);
        pref_editor.putInt("Amount" , 2192);
        pref_editor.putString("Beneficiary", "Zhen");
        pref_editor.commit();
        pref_editor.remove("Beneficiary: ");
        pref_editor.remove("Amount: ");
        pref_editor.remove("Bank Account No: ");
        pref_editor.commit();

        // Extract data
        SharedPreferences preferences_output = getPreferences(MODE_PRIVATE);

        int bankNo = preferences_output.getInt("Bank Account No", 0001);
        int bank_no_other = preferences_output.getInt("Bank Account other", -1);
        int total_MONEY = preferences_output.getInt("Amount", 0);
        name = preferences_output.getString("Beneficiary", "N/A");

        textView.setText("Reading from private preferences...\n" +
                "\nBank Account: " + bankNo + "" +
                "\nBank Account Other: " + bank_no_other + "" +
                "\nTotal Saving: " + total_MONEY + "" +
                "\nBeneficiary: " + name);

        setContentView(textView);

    }
}