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

public class ColoursActivity extends AppCompatActivity {
    EditText etChoice;
    Button btnSubmit;
    ImageView imgColour;
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
            imgColour.setImageResource(R.drawable.black);
        } else if (choice.getImgChoice() == 1) {
            imgColour.setImageResource(R.drawable.blue);
        } else if (choice.getImgChoice() == 2) {
            imgColour.setImageResource(R.drawable.green);
        } else if (choice.getImgChoice() == 3) {
            imgColour.setImageResource(R.drawable.orange);
        } else if (choice.getImgChoice() == 4) {
            imgColour.setImageResource(R.drawable.pink);
        } else if (choice.getImgChoice() == 5) {
            imgColour.setImageResource(R.drawable.purple);
        } else if (choice.getImgChoice() == 6) {
            imgColour.setImageResource(R.drawable.red);
        } else if (choice.getImgChoice() == 7) {
            imgColour.setImageResource(R.drawable.yellow);
        } else if (choice.getImgChoice() == 8) {
            imgColour.setImageResource(R.drawable.brown);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colours);
        etChoice = findViewById(R.id.etColourName);
        btnSubmit = findViewById(R.id.btnSubmit);
        imgColour = findViewById(R.id.ivColours);
        tvPoints = findViewById(R.id.tvPoints);

        al = new ArrayList<Images>();
        al.add(new Images("black", 0));
        al.add(new Images("blue", 1));
        al.add(new Images("green", 2));
        al.add(new Images("orange", 3));
        al.add(new Images("pink", 4));
        al.add(new Images("purple", 5));
        al.add(new Images("red", 6));
        al.add(new Images("yellow", 7));
        al.add(new Images("brown", 8));
        random();
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etChoice.getText().toString();
                AlertDialog.Builder builder1 = new AlertDialog.Builder(ColoursActivity.this);
                if (choice.getName().equalsIgnoreCase(name)) {
                    if (al.size() != 1) {
                        points += 1;
                        new IonAlert(ColoursActivity.this, IonAlert.SUCCESS_TYPE)
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
                                        tvPoints.setText(points + " / 9 pts");
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
                                        Intent intent = new Intent(ColoursActivity.this,ColoursActivity.class);
                                        dialog.cancel();
                                        startActivity(intent);
                                    }
                                });
                        builder1.setNegativeButton("Go to home", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(ColoursActivity.this,MainActivity.class);
                                startActivity(intent);
                                dialogInterface.cancel();
                            }
                        });

                    }
                } else if (!(choice.getName().equalsIgnoreCase(name)) && !(name.isEmpty())) {
                    if (al.size() != 1) {
                        new IonAlert(ColoursActivity.this, IonAlert.ERROR_TYPE)
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
                                        Intent intent = new Intent(ColoursActivity.this,ColoursActivity.class);
                                        dialog.cancel();
                                        startActivity(intent);
                                    }
                                });
                        builder1.setNegativeButton("Go to home", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(ColoursActivity.this,MainActivity.class);
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
                    new IonAlert(ColoursActivity.this, IonAlert.ERROR_TYPE)
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