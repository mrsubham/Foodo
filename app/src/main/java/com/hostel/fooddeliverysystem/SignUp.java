package com.hostel.fooddeliverysystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
    public void Signup(View view)
    {
        Intent i=new Intent(this,Restaurant_Selection.class);
        startActivity(i);
    }
}
