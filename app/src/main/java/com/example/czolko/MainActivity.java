package com.example.czolko;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private String[] Zwierzeta = {"kot", "pies", "słoń", "żyrafa", "jeleń", "tygrys"};
    private String[] Kraje = {"Polska", "Niemcy", "Francja", "Włochy", "Hiszpania", "Japonia"};
    private String[] Jedzenie = {"pizza", "sushi", "hamburger", "spaghetti", "sałatka", "kebab"};
    private String[] Kolory = {"czerwony", "niebieski", "zielony", "żółty", "fioletowy", "pomarańczowy"};
    private String[] Zawody = {"lekarz", "nauczyciel", "informatyk", "policjant", "dziennikarz", "artysta"};
    private String[] Owoce = {"jabłko", "banan", "truskawka", "winogrono", "pomarańcza", "ananas"};
    private String[] Samochody = {"BMW", "Audi", "Mercedes", "Toyota", "Honda", "Volkswagen"};
    private String[] Sporty = {"piłka nożna", "koszykówka", "siatkówka", "bieganie", "pływanie", "rower"};
    private String[] Filmy = {"Forrest Gump", "Gwiezdne wojny", "Titanic", "Harry Potter", "Avengers", "Piraci z Karaibów"};
    private String[] Napoje = {"kawa", "herbata", "cola", "sok", "woda", "piwo"};
    private String[] WybraneSlowa;
    private int IndexWybranychSlow = 0;
    private TextView WybraneSlowaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WybraneSlowaTextView = findViewById(R.id.currentWordTextView);


        if (savedInstanceState != null) {
            WybraneSlowa = savedInstanceState.getStringArray("WybraneSłowa");
            IndexWybranychSlow = savedInstanceState.getInt("IndexWybranychSlow");
            displayCurrentWord();
        }
    }


    public void nextWord(View view) {
        if (WybraneSlowa == null) {
            return;
        }
        IndexWybranychSlow = (IndexWybranychSlow + 1) % WybraneSlowa.length;
        displayCurrentWord();
    }
//Mateusz Szewczuk

    public void chooseCategory(View view) {
        Random random = new Random();
        int categoryIndex = random.nextInt(10);
        switch (categoryIndex) {
            case 0:
                WybraneSlowa = Zwierzeta;
                break;
            case 1:
                WybraneSlowa = Kraje;
                break;
            case 2:
                WybraneSlowa = Jedzenie;
                break;
            case 3:
                WybraneSlowa = Kolory;
                break;
            case 4:
                WybraneSlowa = Zawody;
                break;
            case 5:
                WybraneSlowa = Owoce;
                break;
            case 6:
                WybraneSlowa = Samochody;
                break;
            case 7:
                WybraneSlowa = Sporty;
                break;
            case 8:
                WybraneSlowa = Filmy;
                break;
            case 9:
                WybraneSlowa = Napoje;
                break;
        }
        IndexWybranychSlow = 0;
        displayCurrentWord();
    }


    private void displayCurrentWord() {
        if (WybraneSlowa == null) {
            return;
        }
        WybraneSlowaTextView.setText(WybraneSlowa[IndexWybranychSlow]);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putStringArray("WybraneSłowa", WybraneSlowa);
        outState.putInt("IndexWybranychSlow", IndexWybranychSlow);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

    }
}
