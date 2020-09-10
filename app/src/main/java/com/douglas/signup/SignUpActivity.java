package com.douglas.signup;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.douglas.signup.service.UserService;
import com.douglas.signup.service.exception.InvalidUserException;

public class SignUpActivity extends AppCompatActivity {

    private UserService userService;

    private EditText firstName;
    private EditText lastName;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        password = findViewById(R.id.password);

        initBeans();
        buildRegister();
    }

    private void initBeans() {
        userService = new UserService();
    }

    private void buildRegister() {
        Button btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    userService.registerUser(firstName.getText().toString().trim(),
                            lastName.getText().toString().trim(),
                            password.getText().toString().trim());
                    showMessage("Success!");
                } catch (InvalidUserException e) {
                    showMessage(e.getMessage());
                }
            }
        });
    }

    private void showMessage(String message) {
        Toast dialog = Toast.makeText(
                SignUpActivity.this, message, Toast.LENGTH_LONG);
        dialog.setGravity(Gravity.CENTER, 0, 0);
        dialog.show();
    }
}