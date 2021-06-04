package sg.edu.rp.c347.id19023980.app4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import id.ionbit.ionalert.IonAlert;

public class AnimalsActivity extends AppCompatActivity {
    EditText etChoice;
    Button btnSubmit;
    ImageView imgAnimal;
    ArrayList<Images> al;
    TextView tvPoints;
    int n;
    Images choice;
    int points;

    public void random() {
        Random rand = new Random();
        n = rand.nextInt(al.size());
        choice = al.get(n);
        if (choice.getImgChoice() == 0) {
            imgAnimal.setImageResource(R.drawable.bear);
        } else if (choice.getImgChoice() == 1) {
            imgAnimal.setImageResource(R.drawable.bird);
        } else if (choice.getImgChoice() == 2) {
            imgAnimal.setImageResource(R.drawable.cat);
        } else if (choice.getImgChoice() == 3) {
            imgAnimal.setImageResource(R.drawable.dog);
        } else if (choice.getImgChoice() == 4) {
            imgAnimal.setImageResource(R.drawable.fish);
        } else if (choice.getImgChoice() == 5) {
            imgAnimal.setImageResource(R.drawable.lion);
        } else if (choice.getImgChoice() == 6) {
            imgAnimal.setImageResource(R.drawable.tiger);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);
        etChoice = findViewById(R.id.etAnimalName);
        btnSubmit = findViewById(R.id.btnSubmitAnimal);
        imgAnimal = findViewById(R.id.ivAnimals);
        tvPoints = findViewById(R.id.tvPointsAnimals);

        al = new ArrayList<Images>();
        al.add(new Images("bear", 0));
        al.add(new Images("bird", 1));
        al.add(new Images("cat", 2));
        al.add(new Images("dog", 3));
        al.add(new Images("fish", 4));
        al.add(new Images("lion", 5));
        al.add(new Images("tiger", 6));
        random();
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etChoice.getText().toString();
                AlertDialog.Builder builder1 = new AlertDialog.Builder(AnimalsActivity.this);
                if (choice.getName().equalsIgnoreCase(name)) {
                    if (al.size() != 1) {
                        points += 1;
                        new IonAlert(AnimalsActivity.this, IonAlert.SUCCESS_TYPE)
                                .setTitleText("Congratulation!!")
                                .setContentText("You got it correct! You earned 1 point!")
                                .setConfirmText("Next!")
                                .setConfirmClickListener(new IonAlert.ClickListener() {
                                    @Override
                                    public void onClick(IonAlert sDialog) {
                                        sDialog.dismissWithAnimation();
                                        al.remove(n);
                                        random();
                                        etChoice.setText("");
                                        tvPoints.setText(points + " / 7 pts");
                                    }
                                })
                                .show();
                    } else {
                        points += 1;
                        builder1.setMessage("Congratulation!! You scored " + points + " points!");
                        builder1.setCancelable(true);
                        builder1.setPositiveButton(
                                "Try Again!",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Intent intent = new Intent(AnimalsActivity.this,AnimalsActivity.class);
                                        startActivity(intent);
                                        dialog.cancel();
                                    }
                                });
                        builder1.setNegativeButton("Go to home", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(AnimalsActivity.this,MainActivity.class);
                                startActivity(intent);
                                dialogInterface.cancel();
                            }
                        });

                    }
                } else if (!(choice.getName().equalsIgnoreCase(name)) && !(name.isEmpty())) {
                    if (al.size() != 1) {
                        new IonAlert(AnimalsActivity.this, IonAlert.ERROR_TYPE)
                                .setTitleText("Sorry!")
                                .setContentText("You got it wrong! Try Again.")
                                .setConfirmText("Next!")
                                .setConfirmClickListener(new IonAlert.ClickListener() {
                                    @Override
                                    public void onClick(IonAlert sDialog) {
                                        sDialog.dismissWithAnimation();
                                        al.remove(n);
                                        random();
                                        etChoice.setText("");

                                    }
                                })
                                .show();
                    } else {
                        builder1.setMessage("Congratulation!! You scored " + points + " points!");
                        builder1.setCancelable(true);
                        builder1.setPositiveButton(
                                "Try Again!",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Intent intent = new Intent(AnimalsActivity.this,AnimalsActivity.class);
                                        startActivity(intent);
                                        dialog.cancel();
                                    }
                                });
                        builder1.setNegativeButton("Go to home", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(AnimalsActivity.this,MainActivity.class);
                                startActivity(intent);
                                dialogInterface.cancel();
                            }
                        });
//                        new IonAlert(ColoursActivity.this, IonAlert.CUSTOM_IMAGE_TYPE)
//                                .setTitleText("Sweet!")
//                                .setContentText("Here's a custom image.")
//                                .setCustomImage(R.drawable.trophy)
//                                .show();
//
                    }

//                    builder1.setMessage("Awww! You got it wrong. Try Again");
//                    builder1.setCancelable(true);
//                    builder1.setPositiveButton(
//                            "Next!",
//                            new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//                                    al.remove(n);
//                                    random();
//                                    dialog.cancel();
//                                    etChoice.setText("");
//                                }
//                            });
                } else if (name.isEmpty()){
                    new IonAlert(AnimalsActivity.this, IonAlert.ERROR_TYPE)
                            .setTitleText("No input")
                            .setContentText("Key in a word to submit an answer")
                            .setConfirmText("Okay!")
                            .setConfirmClickListener(new IonAlert.ClickListener() {
                                @Override
                                public void onClick(IonAlert sDialog) {
                                    sDialog.dismissWithAnimation();
                                    etChoice.setText("");

                                }
                            })
                            .show();
                }
                AlertDialog alert11 = builder1.create();
                alert11.setCanceledOnTouchOutside(false);
                alert11.show();
            }
        });
    }
}