package com.example.udit.coffeemaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    int cost = 0;
    int coffeeRate= 5;
    int rate = coffeeRate;
    int chocoRate = 2;
    int wCreamRate = 1;
    String message;
    CheckBox chocolate,wCream;
    boolean chocolateSelected = false;
    boolean wCreamSelected = false;

    TextView costTextView,quantityTextView;
            //,orderTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chocolate = findViewById(R.id.chocolate);
        wCream = findViewById(R.id.wCream);
        quantityTextView = findViewById(R.id.quantityTextView);
        costTextView = findViewById(R.id.costTextView);

    }

    public void submit(View v){
        Toast.makeText(this,"Order is submitted",Toast.LENGTH_LONG).show();
        check();
        display();
        orderMessage();
        activity();
    }

    private void activity(){
        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra("mess", message);
        startActivity(i);

    }

    public void reset(View v){
        quantity = 0;
        cost = 0;
        rate = coffeeRate;
        quantityTextView.setText(""+0);
        costTextView.setText("");
        //orderTextView.setText("");
        chocolateSelected = false;
        wCreamSelected = false;
        if(chocolate.isChecked())
            chocolate.toggle();
        if(wCream.isChecked())
            wCream.toggle();
    }
    public void increment(View v){
        quantity++;
        if (quantity == 101)
            quantity = 100;
        displayQuantity();
        //check();
        display();
    }

    public void decrement(View v){
        quantity--;
        if(quantity==-1)
            quantity = 0;
        displayQuantity();
        //check();
        display();
    }

    private void check(){


        if(wCream.isChecked()) {
            rate += wCreamRate;
            chocolateSelected=true;
        }
        if(chocolate.isChecked()){
            rate +=  chocoRate;
            wCreamSelected=true;
        }
        //display();
    }


    private void displayQuantity(){
        quantityTextView.setText(""+quantity);

    }

    private void display(){
        cost = quantity*rate;
        costTextView.setText(""+cost);
    }
/*
    public void orderTextView(View v){
        orderTextView = findViewById(R.id.orderTextView);
        message = "Quantity : "+quantity+"\nChocolate selected :"+chocolateSelected+"\nWhipping Cream selected :"+wCreamSelected+
                "\nTotal Cost : "+cost+"\n";
        orderTextView.setText(message);
    }
  */
    private void orderMessage(){
        //orderTextView = findViewById(R.id.orderTextView);
        message = "Quantity : "+quantity+"\nChocolate selected :"+chocolateSelected+"\nWhipping Cream selected :"+wCreamSelected+
                "\nTotal Cost : "+cost+"\n";
        //orderTextView.setText(message);
    }




}
