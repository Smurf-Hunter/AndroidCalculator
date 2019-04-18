package com.example.calculater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String display = "";
    int status = 0;
    String num3 = "";
    String num4 = "";
    int num1,num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void displayKey(View view)
    {
            if(status==0)
             {
                 String num6= ((Button)view).getText().toString();
                 num3 = num3 + num6;
                 num1 = Integer.parseInt(num3);
                 display = display + num6;
             }
             else {
                 String num5 =((Button) view).getText().toString();
                 num4 = num4 + num5;
                num2 = Integer.parseInt(num4);
                display = display + num5;

            }
            displayMain(display);
    }
    public void add(View view)
    {
        if(status==0) {
            num3="";
            status = 1;
            display = display + "+";
            displayMain(display);
        }
    }
    public void divide(View view)
    {   if(status==0) {
        status = 2;
        num3="";
        display = display + "/";
        displayMain(display);}
    }
    public void multiply(View view)
    {
        if(status==0) {
        status = 3;
        num3 = "";
        display = display + "*";
        displayMain(display);}
    }
    public void minus(View view)
    {   if(status==0) {
        status = 4;
        num3="";
        display = display + "-";
        displayMain(display);}
    }
    public void equal(View view)
    {
        int ans=0;
        if(status==1)
        {
            ans = num1+num2;
        }
        if(status==4)
        {
            ans = num1-num2;
        }
        if(status==3)
        {
            ans = num1*num2;
        }
        if(status==2)
        {   if(num2==0){ans=0;}
            else{
            ans = num1/num2;}
        }
        display = "";
        display = display + ans;
        displayMain(display);
        status = 0;
        num4="";
        display="";
    }
    public void displayMain(String display)
    {
        TextView textview = (TextView) findViewById(R.id.calculate);
        textview.setText(String.valueOf(display));
    }
}
