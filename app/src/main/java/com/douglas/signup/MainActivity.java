package com.douglas.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnSignUp;
    TextView textSecret;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textSecret = (TextView) findViewById(R.id.textSecret);
        textSecret.setText(BuildConfig.SECRET);
        buildSignUp();
    }

    private void buildSignUp() {
        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSignUp = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(goToSignUp);
            }
        });
    }

}