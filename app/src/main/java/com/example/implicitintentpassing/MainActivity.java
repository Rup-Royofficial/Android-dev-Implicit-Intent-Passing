package com.example.implicitintentpassing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
Button btnCall,btnEmail,btnShare,btnSMS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCall = findViewById(R.id.btnCall);
        btnEmail = findViewById(R.id.btnEmail);
        btnShare = findViewById(R.id.btnShare);
        btnSMS = findViewById(R.id.btnSMS);


        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent();
                callIntent.setAction(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel: +91 8942980490"));
                startActivity(callIntent);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent();
                emailIntent.setAction(Intent.ACTION_SEND);
                emailIntent.setType("message/rfc822");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"aditriroy2805@gmail.com","atanuroy2006@gmail.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Trial Testing");
                emailIntent.putExtra(Intent.EXTRA_TEXT,"Please send a ticket, if it working alright!");
                startActivity(Intent.createChooser(emailIntent,"Email via"));
            }
        });

        btnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent smsIntent = new Intent();
                smsIntent.setAction(Intent.ACTION_SENDTO);
                smsIntent.setData(Uri.parse("smsto:"+Uri.encode("9476184147")));
                smsIntent.putExtra("sms_body","Please call me asap");
                startActivity(smsIntent);
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT,"Download kor na app ta");
                startActivity(Intent.createChooser(shareIntent,"Email via"));
            }
        });
    }
}