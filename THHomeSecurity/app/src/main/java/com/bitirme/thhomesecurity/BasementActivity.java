package com.bitirme.thhomesecurity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class BasementActivity extends AppCompatActivity {
    private ToggleButton lightswitch,curtainswitch,aircondswitch,thiefswitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basement);
        lightswitch= findViewById(R.id.light1toggle);
        curtainswitch = findViewById(R.id.curtain1toggle);
        aircondswitch = findViewById(R.id.ventilation1toggle);
        thiefswitch= findViewById(R.id.burglar1toggle);

        lightswitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (lightswitch.isChecked()){

                    sendMessage("@BasementActivity:LED-ON");
                }else{
                    sendMessage("@BasementActivity:LED-OFF");
                }
            }

        });

        curtainswitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (curtainswitch.isChecked()){

                    sendMessage("@BasementActivity:CURTAIN-ON");
                }else{
                    sendMessage("@BasementActivity:CURTAIN-OFF");
                }
            }

        });

        aircondswitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (aircondswitch.isChecked()){

                    sendMessage("@BasementActivity:AIRCON-ON");
                }else{
                    sendMessage("@BasementActivity:AIRCON-OFF");
                }
            }

        });
        thiefswitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (thiefswitch.isChecked()){

                    sendMessage("@BasementActivity:BURGLAR-ON");
                }else{
                    sendMessage("@BasementActivity:BURGLAR-OFF");
                }
            }

        });

    }

    private void sendMessage(String Message){

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("message" , Message);
        reference.child("Commands").push().setValue(hashMap);
    }

}