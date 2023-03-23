package com.example.aadhaarnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit=findViewById(R.id.ed1);
    }

    public void aadhaar(View view) {
        String adhaarnumber = edit.getText().toString();
        if(edit.length()==0){
            edit.setError("Please enter the aadhaar number");
        }
        else {
            boolean result = Veroff.validateVerhoeff(adhaarnumber);
            String validationResult = String.valueOf(result);
//                    System.out.println("Aadhar verify : "+validationResult);
            if (validationResult == "true") {
                if(edit.length()==12) {
                    Toast.makeText(this, "Valid aadhaar number", Toast.LENGTH_SHORT).show();
                }
                else if(edit.length()==16){
                    Toast.makeText(this, "Valid vid number", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(this, "Invalid aadhaar number", Toast.LENGTH_SHORT).show();
            }
            edit.setText("");
        }
    }
}