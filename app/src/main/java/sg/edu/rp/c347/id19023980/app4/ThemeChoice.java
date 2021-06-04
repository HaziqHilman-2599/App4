package sg.edu.rp.c347.id19023980.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThemeChoice extends AppCompatActivity {
    Button btnColours,btnAnimals,btnVehicles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_choice);

        btnColours = findViewById(R.id.btnColours);
        btnAnimals = findViewById(R.id.btnAnimals);
        btnVehicles = findViewById(R.id.btnVehicles);

        btnColours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ThemeChoice.this,ColoursActivity.class);
                startActivity(i);
            }
        });

        btnAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ThemeChoice.this,AnimalsActivity.class);
                startActivity(i);
            }
        });
        btnVehicles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ThemeChoice.this,VehiclesActivity.class);
                startActivity(i);
            }
        });
    }
}