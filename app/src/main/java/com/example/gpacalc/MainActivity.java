package com.example.gpacalc;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result;
    EditText num1,num2,num3,num4,num5;
    Button calculate, clear;
    float result_num;
    float number1,number2,number3,number4,number5;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        result = (TextView)findViewById(R.id.Result);
        num1 = (EditText)findViewById(R.id.num1);
        num2 = (EditText)findViewById(R.id.num2);
        num3 = (EditText)findViewById(R.id.num3);
        num4 = (EditText)findViewById(R.id.num4);
        num5 = (EditText)findViewById(R.id.num5);
        calculate = (Button)findViewById(R.id.calculate);
       // clear = (Button)findViewById(R.id.calculate);
        view = this.getWindow().getDecorView();
        calculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                if (calculate.getText() == "Clear Form") {
                    num1.setText("");
                    num2.setText("");
                    num3.setText("");
                    num4.setText("");
                    num5.setText("");
                    result.setText("");
                    calculate.setText("Compute GPA");
                    view.setBackgroundResource(R.color.white);
                } else {

                    if (num1.getText().length() == 0 || Float.parseFloat(num1.getText().toString()) > 100 || Float.parseFloat(num1.getText().toString()) < 0) {
                        num1.setError("Invalid input.");
                        view.setBackgroundResource(R.color.red);
                    }else if (num2.getText().length() == 0 || Float.parseFloat(num2.getText().toString()) > 100 || Float.parseFloat(num2.getText().toString()) < 0){
                        num2.setError("Invalid input.");
                        view.setBackgroundResource(R.color.red);
                    }else if (num3.getText().length() == 0 || Float.parseFloat(num3.getText().toString()) > 100 || Float.parseFloat(num3.getText().toString()) < 0){
                        num3.setError("Invalid input.");
                        view.setBackgroundResource(R.color.red);
                    }else if (num4.getText().length() == 0 || Float.parseFloat(num4.getText().toString()) > 100 || Float.parseFloat(num4.getText().toString()) < 0){
                        num4.setError("Invalid input.");
                        view.setBackgroundResource(R.color.red);
                    }else if (num5.getText().length() == 0 || Float.parseFloat(num5.getText().toString()) > 100 || Float.parseFloat(num5.getText().toString()) < 0){
                        num5.setError("Invalid input.");
                        view.setBackgroundResource(R.color.red);
                    }else {

                        number1 = Float.parseFloat(num1.getText().toString());
                        number2 = Float.parseFloat(num2.getText().toString());
                        number3 = Float.parseFloat(num3.getText().toString());
                        number4 = Float.parseFloat(num4.getText().toString());
                        number5 = Float.parseFloat(num5.getText().toString());

                        result_num = (number1 + number2 + number3 + number4 + number5) / 5;

                        if (result_num <= 60) {
                            view.setBackgroundResource(R.color.red);
                        } else if (result_num < 80) {
                            view.setBackgroundResource(R.color.yellow);
                        } else {
                            view.setBackgroundResource(R.color.green);
                        }
                        calculate.setText("Clear Form");
                    }
                    result.setText(String.valueOf(result_num));

/*                    if (result_num <= 65){
                        result_num = 0.0F;
                    } else if (result_num<=66){
                        result_num = 1.0F;
                    }else if (result_num<=69){
                        result_num = 1.3F;
                    }else if (result_num<=72){
                        result_num = 1.7F;
                    }else if (result_num<=76){
                        result_num = 2.0F;
                    }else if (result_num<=79){
                        result_num = 2.3F;
                    }else if (result_num<=82){
                        result_num = 2.7F;
                    }else if (result_num<=86){
                        result_num = 3.0F;
                    }else if (result_num<=89){
                        result_num = 3.3F;
                    }else if (result_num<=92){
                        result_num = 3.7F;
                    }else if (result_num<92){
                        result_num = 4.0F;
                    }*/


/*                    if (result_num <= 60) {
                        view.setBackgroundResource(R.color.red);
                    } else if (result_num < 80) {
                        view.setBackgroundResource(R.color.yellow);
                    } else {
                        view.setBackgroundResource(R.color.green);
                    }
                    calculate.setText("Clear Form");*/
                }
            }
        });




        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
