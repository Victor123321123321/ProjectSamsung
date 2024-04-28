package com.example.projectsamsung;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String[] theorems = {"Теорема Пифагора", "Теорема Фалеса", "Теорема о синусах", "Теорема о косинусах"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theorems);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedTheorem = theorems[position];
                Toast.makeText(MainActivity.this, selectedTheorem, Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (theorems[position].equals("Теорема Пифагора")) {
                    Intent intent = new Intent(MainActivity.this, activity_theorem_details.class);
                    startActivity(intent);
                }
                if (theorems[position].equals("Теорема Фалеса")) {
                    Intent intent = new Intent(MainActivity.this, Fales.class);
                    startActivity(intent);
                }
                if (theorems[position].equals("Теорема о синусах")) {
                    Intent intent = new Intent(MainActivity.this, sinus.class);
                    startActivity(intent);
                }
                if (theorems[position].equals("Теорема о косинусах")) {
                    Intent intent = new Intent(MainActivity.this, Cosinus.class);
                    startActivity(intent);
                }
            }
        });
    }
}