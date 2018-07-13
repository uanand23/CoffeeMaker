package com.example.udit.coffeemaker;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {


    //EditText ed1,ed2;
    String name,emailId;
    EditText nameEditText,emailIdEditText;
    TextView orderTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i = getIntent();
        String msg = i.getStringExtra("mess");
        orderTextView = findViewById(R.id.orderTextView);
        orderTextView.setText(msg);
        //tv = findViewById(R.id.tv);
        //tv.setText(msg);
    }
    public void back(View v){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

    private void emailActivity(){
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",emailId,null));
       // emailIntent.putExtra(Intent.EXTRA_EMAIL,emailId);
       // emailIntent.putExtra(Intent.EXTRA_BCC,"manager@xyz");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Order Confirmed");
        emailIntent.putExtra(Intent.EXTRA_TEXT,"Hi "+name);
        startActivity(Intent.createChooser(emailIntent,"Send Email"));
    }

    public void confirm(View v){

        name = ((EditText)findViewById(R.id.nameEditText)).getText().toString();
        emailId = ((EditText)findViewById(R.id.emailIdEditText)).getText().toString();
        String message = "Name :"+name+"\nEmailId : "+emailId;
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
        emailActivity();
    }
}
