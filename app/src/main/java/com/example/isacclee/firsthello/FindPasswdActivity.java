package com.example.isacclee.firsthello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FindPasswdActivity extends AppCompatActivity {
    private TextView mEmailView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_passwd);

        mEmailView = (TextView) findViewById(R.id.editText5);
        final String email = mEmailView.getText().toString();
        Button SendButton = (Button) findViewById(R.id.send_button);
        SendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Controller controller = new Controller();
                controller.ForgetPassword(email);
                Toast.makeText(getApplicationContext(), "密码已发到邮箱", Toast.LENGTH_LONG).show();
                JumpToLogin();
            }
        });
    }

    public void JumpToLogin(){
        Intent intent = new Intent();
        intent.setClass(FindPasswdActivity.this,LoginActivity.class );

        startActivity(intent);
        finish();
    }

}
