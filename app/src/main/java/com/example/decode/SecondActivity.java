package com.example.decode;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import net.khirr.android.privacypolicy.PrivacyPolicyDialog;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        privacyCheck();
    }

    private void privacyCheck() {
        PrivacyPolicyDialog dialog = new PrivacyPolicyDialog(this,
                "https://localhost/terms",
                "https://localhost/privacy");

        // Dialog
        dialog.addPoliceLine("This application uses a unique user identifier for advertising purposes, it is shared with third-party companies.");
        dialog.addPoliceLine("This application sends error reports, installation and send it to a server of the Fabric.io company to analyze and process it.");
        dialog.addPoliceLine("This application requires internet access and must collect the following information: Installed applications and history of installed applications, ip address, unique installation id, token to send notifications, version of the application, time zone and information about the language of the device.");
        dialog.addPoliceLine("All details about the use of data are available in our Privacy Policies, as well as all Terms of Service links below.");

        // Title Dialog
        dialog.setTitle("Terms Of Services");

        // Terms
        dialog.setTermsOfServiceSubtitle("If you click on (accept), you acknowledge that is makes the bla bla");
        // Dialog set
        dialog.setTitleTextColor(Color.parseColor("#222222"));
        dialog.setAcceptButtonColor(ContextCompat.getColor(this, R.color.colorAccent));
        dialog.show();

        final Intent intent = new Intent(this, MainActivity.class);

        dialog.setOnClickListener(new PrivacyPolicyDialog.OnClickListener() {
            @Override
            public void onAccept(boolean b) {
                Log.e("SecondActivity", "Policies accepted");
                startActivity(intent);
                finish();
            }

            @Override
            public void onCancel() {
                Log.e("SecondActivity", "Policies not accepted");
                finish();
            }
        });
    }



}
