package com.example.digiednaloga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.digiednaloga.MainActivity.SHARED_PREFS;

public class ShranjevanjeActivity extends AppCompatActivity {
    private EditText editTextIme;
    private EditText editTextPriimek;
    private EditText editTextStarost;
    private Button buttonShrani;

    /*
    public static SharedPreferences prefrences;
    public static SharedPreferences modePrefrence;
    public static SharedPreferences settings;
    public static SharedPreferences.Editor editor;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String IME = "ime1";
    public static final String PRIIMEK = "priimek1";
    public static final String STAROST = "starost1";
     */





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shranjevanje);

        editTextIme = (EditText) findViewById(R.id.editTextImeId);
        editTextPriimek = (EditText) findViewById(R.id.editTextPriimekId);
        editTextStarost = (EditText) findViewById(R.id.editTextStarostId);
        buttonShrani = (Button) findViewById(R.id.buttonShraniId);

        buttonShrani.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                MainActivity.starost = 0;
                MainActivity.ime = "";
                MainActivity.priimek = "";
                try {
                    MainActivity.ime = editTextIme.getText().toString();
                    MainActivity.priimek = editTextPriimek.getText().toString();
                    MainActivity.starost = Integer.parseInt(editTextStarost.getText().toString());
                }catch(Exception e){}
                saveData();
            }
        });
    }

    public void saveData(){
        /*
        MainActivity.prefrences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = MainActivity.prefrences.edit();

        editor.putString(MainActivity.IME, MainActivity.ime);
        editor.putString(MainActivity.PRIIMEK, MainActivity.priimek);
        editor.putInt(MainActivity.STAROST, MainActivity.starost);

        editor.apply();

         */
        try {
            MainActivity.imePrefrence = getApplicationContext().getSharedPreferences("PREFS_NAME", 0);
            MainActivity.editor = MainActivity.settings.edit();
            MainActivity.editor.putInt("starostPr", MainActivity.starost);
            MainActivity.editor.putString("imePr", MainActivity.ime);
            MainActivity.editor.putString("priimekPr", MainActivity.priimek);
            MainActivity.editor.apply();

            //SharedPreferences.Editor editor = MainActivity.prefrences.edit();
            //editor.putBoolean("firstTimeInstall", false);
            //editor.apply();
        }catch(Exception e){

        }

        MainActivity.intent5 = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(MainActivity.intent5);
    }

}
