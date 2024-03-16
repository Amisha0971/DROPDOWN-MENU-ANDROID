package com.example.dropdownmenu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] items = {"C", "C++", "JAVA", "PHP", "WORDPRESS" , "ANDROID" , "HIBERNATE" , "SPRING", "PYTHON"};
    AutoCompleteTextView autoCompleteTextView;

    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoCompleteTextView = findViewById(R.id.autoComplete_text);
        adapterItems = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, items);

        autoCompleteTextView.setAdapter(adapterItems);

        autoCompleteTextView.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View view) {
                // No need for onItemClick listener for AutoCompleteTextView, it handles item selection automatically
                // Instead, you can use the OnItemClickListener for the Spinner
            }
        });

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, "Item: " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
