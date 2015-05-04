package com.cs594.wael.mycalculator;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Advance extends ActionBarActivity {

    private Button del, clr, simple, openBrac, closeBrac, piBtn, cosBtn, sinBtn, tanBtn, logBtn, lnBtn, eBtn, modBtn, powBtn, sqrBtn;
    private EditText txt;
    private float num;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance);

        //Define buttons
        simple = (Button) findViewById(R.id.Simple_btn);
        clr = (Button) findViewById(R.id.Clear_btn);
        del = (Button) findViewById(R.id.Delete_btn);
        openBrac = (Button) findViewById(R.id.StartCont_btn);
        closeBrac = (Button) findViewById(R.id.EndCont_btn);
        eBtn = (Button) findViewById(R.id.e_btn);
        piBtn = (Button) findViewById(R.id.Pi_btn);
        sqrBtn = (Button) findViewById(R.id.SquareRt_btn);
        powBtn = (Button) findViewById(R.id.Pow_btn);
        modBtn = (Button) findViewById(R.id.Mod_btn);
        logBtn = (Button) findViewById(R.id.log_btn);
        lnBtn = (Button) findViewById(R.id.ln_btn);
        cosBtn = (Button) findViewById(R.id.Cos_btn);
        sinBtn = (Button) findViewById(R.id.Sin_btn);
        tanBtn = (Button) findViewById(R.id.Tan_btn);

        //Define EditText
        txt = (EditText) findViewById(R.id.editText2);

        //Disable soft keyboard
        disableSoftInputFromAppearing(txt);

        //Get EditText value
        Intent intent = getIntent();
        txt.setText(intent.getStringExtra("editText"));


        //Go to Simple Mode
        simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Advance.this, MainActivity.class);
                intent.putExtra("editText", txt.getText().toString());
                startActivity(intent);
            }
        });

        //Clear EditText
        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText("");
            }
        });

        //Delete last number
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = txt.getText().toString();
                txt.setText(s.substring(0, s.length() - 1));
            }
        });

        //Print (
        openBrac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.append("(");
            }
        });

        //Print )
        closeBrac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.append(")");
            }
        });

        //Print e value
        eBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = Float.parseFloat(txt.getText().toString());
                num *= Math.E;
                txt.setText(Float.toString(num));
            }
        });

        //Print Pi value
        piBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = Float.parseFloat(txt.getText().toString());
                num *= Math.PI;
                txt.setText(Float.toString(num));
            }
        });

        //Print square root
        sqrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = Float.parseFloat(txt.getText().toString());
                txt.setText(Float.toString((float) Math.sqrt(num)));
            }
        });

        //Print power
        powBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = Float.parseFloat(txt.getText().toString());
                txt.setText(Float.toString((float) Math.pow(num,2)));
            }
        });

        //Print mod 2
        modBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = Float.parseFloat(txt.getText().toString());
                txt.setText(Float.toString(num%2));
            }
        });

        //Print log(
        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = Float.parseFloat(txt.getText().toString());
                txt.setText(Float.toString((float) Math.log10(num)));
            }
        });

        //Print ln(
        lnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = Float.parseFloat(txt.getText().toString());
                txt.setText(Float.toString((float) Math.log(num)));
            }
        });

        //Print cos(
        cosBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = Float.parseFloat(txt.getText().toString());
                txt.setText(Float.toString((float) Math.cos(num)));
            }
        });

        //Print sin(
        sinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = Float.parseFloat(txt.getText().toString());
                txt.setText(Float.toString((float) Math.sin(num)));
            }
        });

        //Print tan(
        tanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = Float.parseFloat(txt.getText().toString());
                txt.setText(Float.toString((float) Math.tan(num)));
            }
        });
    }

    //disable soft keyboard
    public static void disableSoftInputFromAppearing(EditText editText) {
        if (Build.VERSION.SDK_INT >= 11) {
            editText.setRawInputType(InputType.TYPE_CLASS_NUMBER);
            editText.setTextIsSelectable(true);
        } else {
            editText.setRawInputType(InputType.TYPE_NULL);
            editText.setFocusable(true);
        }
    }

}
