package com.example.kosci;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int wynikLosowania = 0;
    private int wynikGry = 0;
    private int liczbaRzutow = 0;

    private TextView wynikLosowania2;
    private TextView wynikGry2;
    private TextView liczbaRzutow2;

    private TextView kosc1;
    private TextView kosc2;
    private TextView kosc3;
    private TextView kosc4;
    private TextView kosc5;

    private TextView[] iloscrzutow = new TextView[5];
    private int[] rzutyKosc = new int[5];

    private Button rzut;
    private Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        kosc1 = findViewById(R.id.kosc1);
        kosc2 = findViewById(R.id.kosc2);
        kosc3 = findViewById(R.id.kosc3);
        kosc4 = findViewById(R.id.kosc4);
        kosc5 = findViewById(R.id.kosc5);

        iloscrzutow[0] = kosc1;
        iloscrzutow[1] = kosc2;
        iloscrzutow[2] = kosc3;
        iloscrzutow[3] = kosc4;
        iloscrzutow[4] = kosc5;

        wynikLosowania2 = findViewById(R.id.wyniklos);
        wynikGry2 = findViewById(R.id.wynikgry);
        liczbaRzutow2 = findViewById(R.id.liczbarzut);

        rzut = findViewById(R.id.rollDice);
        reset = findViewById(R.id.resetGame);

        rzut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDice();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });
    }

    void rollDice() {
        Random random = new Random();
        int suma = 0;
        for(int i=0;i<rzutyKosc.length;i++)
        {
            int rzut = random.nextInt(6)+1;
            rzutyKosc[i] = rzut;
            suma = suma + rzut;
        }
        updateScore(suma);
        updateRollCount();
        displayDiceResults(rzutyKosc);

    }
    void resetGame() {
        for(int i=0;i<iloscrzutow.length;i++) {
            iloscrzutow[i].setText("?");
        }
        wynikLosowania = 0;
        wynikGry = 0;
        liczbaRzutow = 0;

        wynikLosowania2.setText("Wynik tego losowania: 0");
        wynikGry2.setText("Wynik gry: 0");
        liczbaRzutow2.setText("Liczba rzutów: 0");

    }
    void updateScore(int newScore) {
        wynikGry = wynikGry + newScore;
        wynikLosowania2.setText("Wynik tego losowania: " + String.valueOf(newScore));
        wynikGry2.setText("Wynik gry: " + String.valueOf(wynikGry));

    }
    void updateRollCount() {
        liczbaRzutow++;
        liczbaRzutow2.setText("Liczba rzutów: " + String.valueOf(liczbaRzutow));

    }
    void displayDiceResults(int[] diceResults) {
        for(int i=0;i<iloscrzutow.length;i++){
            iloscrzutow[i].setText(String.valueOf(diceResults[i]));
        }
    }
}