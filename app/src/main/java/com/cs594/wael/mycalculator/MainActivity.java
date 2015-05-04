package com.cs594.wael.mycalculator;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    private Button adv, clr, del, no1, no2, no3, no4, no5, no6, no7, no8, no9, no0, mult, divid, equal, plus, minus, dot;
    private EditText txt;
    private float num1, num2;
    private String Operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Define buttons
        adv = (Button) findViewById(R.id.Advance_btn);
        clr = (Button) findViewById(R.id.Clear_btn);
        del = (Button) findViewById(R.id.Delete_btn);
        equal = (Button) findViewById(R.id.Equal_btn);
        plus = (Button) findViewById(R.id.Plus_btn);
        minus = (Button) findViewById(R.id.Minus_btn);
        divid = (Button) findViewById(R.id.Divide_btn);
        mult = (Button) findViewById(R.id.Multiply_btn);
        dot = (Button) findViewById(R.id.Dot_btn);
        no1 = (Button) findViewById(R.id.No1_btn);
        no2 = (Button) findViewById(R.id.No2_btn);
        no3 = (Button) findViewById(R.id.No3_btn);
        no4 = (Button) findViewById(R.id.No4_btn);
        no5 = (Button) findViewById(R.id.No5_btn);
        no6 = (Button) findViewById(R.id.No6_btn);
        no7 = (Button) findViewById(R.id.No7_btn);
        no8 = (Button) findViewById(R.id.No8_btn);
        no9 = (Button) findViewById(R.id.No9_btn);
        no0 = (Button) findViewById(R.id.No0_btn);

        //Define EditText
        txt = (EditText) findViewById(R.id.editText1);

        //Disable soft keyboard
        disableSoftInputFromAppearing(txt);

        //Get EditText value
        Intent intent = getIntent();
        txt.setText(intent.getStringExtra("editText"));


        //Go to Advance Mode
        adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Advance.class);
                intent.putExtra("editText", txt.getText().toString());
                startActivity(intent);
            }
        });


        //Clear EditText
        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText("");
                num1=0;
                num2=0;
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

        //Calculate depending on last operation
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (Operation){
                    case "Plus":
                        Plus();
                        Operation = "Equal";
                        break;
                    case "Minus":
                        Minus();
                        Operation = "Equal";
                        break;
                    case "Divide":
                        Divide();
                        Operation = "Equal";
                        break;
                    case "Multiply":
                        Multiply();
                        Operation = "Equal";
                        break;
                }

            }
        });


        //Sum numbers
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operation = "Plus";
                Plus();
            }
        });


        //Subtract numbers
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operation = "Minus";
                Minus();

            }
        });

        //Divide numbers
        divid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operation = "Divide";
                Divide();
            }
        });


        //Multiply numbers
        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operation = "Multiply";
                Multiply();
            }
        });


        //Add dot
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.append(".");
            }
        });

        //Print 1
        no1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmptyTextEdit();
                txt.append("1");
            }
        });

        //Print 2
        no2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmptyTextEdit();
                txt.append("2");
            }
        });

        //Print 3
        no3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmptyTextEdit();
                txt.append("3");
            }
        });

        //Print 4
        no4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmptyTextEdit();
                txt.append("4");
            }
        });

        //Print 5
        no5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmptyTextEdit();
                txt.append("5");

            }
        });

        //Print 6
        no6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EmptyTextEdit();
                txt.append("6");
            }
        });

        //Print 7
        no7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmptyTextEdit();
                txt.append("7");

            }
        });

        //Print 8
        no8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmptyTextEdit();
                txt.append("8");

            }
        });


        //Print 9
        no9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmptyTextEdit();
                txt.append("9");

            }
        });

        //Print 0
        no0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmptyTextEdit();
                txt.append("0");

            }
        });
    }

    private void EmptyTextEdit() {
        if(num2 != 0){
            num2 = 0;
            txt.setText("");
        }
    }

    private void Multiply() {
        num2 = Float.parseFloat(txt.getText().toString());
        if (num1 != 0){
            num1 = num1 * num2;
            txt.setText(Float.toString(num1));
        }
        else
        {
            num1 = num2;
            txt.setText("");
        }
    }

    private void Plus() {
        num2 = Float.parseFloat(txt.getText().toString());
        num1 = num1 + num2;
        txt.setText(Float.toString(num1));
    }

    private void Divide() {
        num2 = Float.parseFloat(txt.getText().toString());
        if (num1 != 0){
            num1 = num1 / num2;
            txt.setText(Float.toString(num1));
        }
        else
        {
            num1 = num2;
            txt.setText("");
        }
    }

    private void Minus() {
        num2 = Float.parseFloat(txt.getText().toString());
        txt.setText("");
        if (num1 != 0){
            num1 = num1 - num2;
            txt.setText(Float.toString(num1));
        }
        else
        {
            num1 = num2;
        }
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
