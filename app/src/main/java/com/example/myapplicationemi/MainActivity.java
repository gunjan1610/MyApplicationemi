package com.example.emicalculater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.IInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button SB,RB;
    EditText PA,IT,EM;
    TextView PAV,ITV,EMV;

    // TODO -6912-vinit anghan


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SB =findViewById(R.id.SB);
        RB = findViewById(R.id.RB);
        PA = findViewById(R.id.PA);
        IT = findViewById(R.id.IT);
        EM = findViewById(R.id.EM);
        PAV = findViewById(R.id.PAV);
        ITV = findViewById(R.id.ITV);
        EMV = findViewById(R.id.EMV);

        RB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PA.setText("");
                IT.setText("");
                EM.setText("");

            }
        });

        SB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Float P = Float.parseFloat(PA.getText().toString());
                Float I = Float.parseFloat(IT.getText().toString());
                Float M= Float.parseFloat(EM.getText().toString());

                I = I /(12*100);
                Float FA = 1.0f;

                for (int i = 0; i < M;i++){
                    FA *= 1+I;
                }
                float emi = (float) (P * I * (FA/ (FA - 1)));

                DecimalFormat decimalFormat = new DecimalFormat("0");

                int final_emi = Integer.parseInt(decimalFormat.format(emi));

                PAV.setText("EMI : " + final_emi);

                int PAV = (int) (final_emi*M);

                ITV.setText("Total Pay : "+PAV);
                EMV.setText("Total Interest : "+(PAV-P));


            }
        });
    }
}