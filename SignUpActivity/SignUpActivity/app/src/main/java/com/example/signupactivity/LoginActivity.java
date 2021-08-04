package com.example.signupactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
public class LoginActivity extends AppCompatActivity implements Base {
    TextInputLayout mEditTextName, mEditTextPassword;
    Button mButton;
    String mUserName, mPassword;
    Bundle mBundle;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        listener();
    }

    @Override
    public void init() {
        mBundle = getIntent().getExtras();
        if (mBundle != null) {
            mUserName = mBundle.getString("NAME");
            mPassword = mBundle.getString("PASSWORD");
        }
        mEditTextName = (TextInputLayout)findViewById(R.id.login_username_layout);
        mEditTextPassword = (TextInputLayout)findViewById(R.id.login_password_layout);
        mButton = (Button) findViewById(R.id.logInButton);
    }

    @Override
    public void listener() {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count < 3) {
                    if (mUserName.equals(mEditTextName.getEditText().getText().toString()) && mPassword.equals(mEditTextPassword.getEditText().getText().toString())) {
                        Toast.makeText(LoginActivity.this, "Successful Login", Toast.LENGTH_SHORT).show();
                    } else {
                        count++;
                        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    mButton.setEnabled(false);
                }
            }
        });
    }
}