package com.example.digiednaloga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static Intent intent5;

    public static SharedPreferences prefrences;
    public static SharedPreferences imePrefrence;
    public static SharedPreferences settings;
    public static SharedPreferences.Editor editor;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String IME = "ime1";
    public static final String PRIIMEK = "priimek1";
    public static final String STAROST = "starost1";

    public static String ime;
    public static String priimek;
    public static int starost;

    public static boolean splashlocked;
    String items[] = new String[] {"Shranjevanje", "WebView", "API Klic", "Imenik"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listviewid);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        //Toast.makeText(MainActivity.this,"Shranjevanje", Toast.LENGTH_SHORT).show();
                        Intent intentShranjevanje = new Intent(MainActivity.this, ShranjevanjeActivity.class);
                        startActivity(intentShranjevanje);
                        break;
                    case 1:
                        //Toast.makeText(MainActivity.this, "WebView", Toast.LENGTH_SHORT).show();
                       //if(Build.VERSION.SDK_INT > 18) {
                            Intent intentWebView = new Intent(MainActivity.this, WebViewActivity.class);
                            startActivity(intentWebView);
                        //}
                        break;
                    case 2:
                        Intent intentApi = new Intent(MainActivity.this, ApiActivity.class);
                        startActivity(intentApi);
                        break;
                    case 3:
                        //Toast.makeText(MainActivity.this, "Imenik", Toast.LENGTH_SHORT).show();
                        Intent intentImenik = new Intent(MainActivity.this, ImenikActivity.class);
                        startActivity(intentImenik);
                        break;
                }
            }
        });

        if (!splashlocked) {
            Intent intent2 = new Intent(MainActivity.this, SplashScreenActivity.class);
            startActivity(intent2);
            finish();
        }


        starost = 0;
        ime = "";
        priimek = "";

        settings = getApplicationContext().getSharedPreferences("PREFS_NAME", 0);
        starost = settings.getInt("starostPr", 0);
        ime = settings.getString("imePr", "");
        priimek = settings.getString("priimekPr", "");


        if (starost != 0 && !ime.equals("") && !priimek.equals("")){
            TextView textView = findViewById(R.id.instructionsTextView);
            String text3 = "Zdravo " + ime + " " + priimek + ", " + starost;
            textView.setText(text3);
        }
    }
}
