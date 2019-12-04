package com.example.ibw_sg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bu(View view) {
        EditText eth =(EditText) findViewById(R.id.eth);
        EditText etw =(EditText)findViewById(R.id.etw);
        //EditText Gender = (EditText)findViewById(R.id.G);
        TextView Result = (TextView)findViewById(R.id.result);
        TextView Advice = (TextView)findViewById(R.id.advice);


       float h = Float.parseFloat(eth.getText().toString());
       float w = Float.parseFloat(etw.getText().toString());
       //String Gen = Gender.getText().toString();
        //int Gen = Integer.parseInt(Gender.getText().toString());

        RadioButton male = (RadioButton)findViewById(R.id.ma);
        RadioButton female = (RadioButton)findViewById(R.id.fe);

       /*The Broca equation
       Women: IBW [kg] = (height[cm] - 100) - ((height[cm] - 100) × 15%)
       Men: IBW [kg] = (height[cm] - 100) - ((height[cm] - 100) × 10%)
        */
        if (male.isChecked()){
            double  IBW =(h-100)-((h-100)*10/100);
            //Math.ceil(IBW);
            Result.setText("IBW: "+(int)(IBW)+"kg");
            if (IBW>w){
                Advice.setText("You Need to get more "+(int)(IBW-w)+"kg to reach IBW");
            }
            else if (IBW<w){
                Advice.setText("You Need to lose more "+(int)(w-IBW)+"kg to reach IBW");
            }
            else{
                Advice.setText("Your Weight is IBW");
            }

        }
        else if (female.isChecked()){
            double IBW =(h-100)-((h-100)*15/100);
            Result.setText("IBW: "+(int)(IBW)+"kg");
            if (IBW>w){
                Advice.setText("You Need to get more "+(int)(IBW-w)+"kg to reach IBW");
            }
            else if (IBW<w){
                Advice.setText("You Need to lose more "+(int)Math.ceil(w-IBW)+"kg to reach IBW");
            }
            else{
                Advice.setText("Your Weight is IBW");
            }
        }
        else
        {
            Result.setText("Error");
        }


    }
}
