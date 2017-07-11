package com.example.isacclee.firsthello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FindPasswdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_passwd);
        Button SendButton = (Button) findViewById(R.id.send_button);
        SendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
