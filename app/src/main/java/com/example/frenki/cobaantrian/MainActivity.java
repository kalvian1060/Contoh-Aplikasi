package com.example.frenki.cobaantrian;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.EXTEND;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_nomor_antrian ;
    Button kasir1;
    Button kasir2;
    Button kasir3;

    TextView nomor_antrian_user;
    TextView nomor_antrian_kasir;
    TextView nomor_antrian_dipanggil;

    int NOMOR_ANTRIAN = 0;
    int NOMOR_ANTRIAN_KASIR = 0;

    private boolean KASIR1_ISBUSY = false;
    private boolean KASIR2_ISBUSY = false;
    private boolean KASIR3_ISBUSY = false;
    private static int CEK1=0;

    String Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Text = "nomor Antrian\n";

        //===== TEXTVIEW ====\\

        nomor_antrian_user = (TextView) findViewById(R.id.nomor_antrian_user);
        nomor_antrian_kasir = (TextView) findViewById(R.id.nomor_antrian_kasir);
        nomor_antrian_dipanggil = (TextView) findViewById(R.id.nomor_antrian_dipanggil);

        //==== BUTTON KASIR ====\\

        kasir1 = (Button) findViewById(R.id.btn_kasir1);
        kasir2 = (Button) findViewById(R.id.btn_kasir2);
        kasir3 = (Button) findViewById(R.id.btn_kasir3);

        kasir1.setOnClickListener(this);
        kasir2.setOnClickListener(this);
        kasir3.setOnClickListener(this);

        kasir1State(CEK1);

    }



    @Override
    public void onClick (View view){
        if (view == kasir1){
            if(CEK1==0) {
                CEK1++;
                kasir1State(CEK1);
                //ketika di klik naik
                Log.e("COUNT",String.valueOf(CEK1));
            }else{
                CEK1--;
                //ketika di klik turun
                kasir1State(CEK1);
                Log.e("COUNT",String.valueOf(CEK1));
            }
        }
    }
    private void kasir1State(int count) {
        if (count == 0)
            kasir1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        else
            kasir1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

    }
}
