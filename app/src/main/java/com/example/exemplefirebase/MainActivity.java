package com.example.exemplefirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.play.core.tasks.OnFailureListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.view.View;
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
TextView tvread;
    private DatabaseReference mDatabase;
Button btwrite,btread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

tvread = findViewById(R.id.tv_main);
        btwrite = findViewById(R.id.bt_write);
        btread = findViewById(R.id.bt_read);

btwrite.setOnClickListener(this);
        btread.setOnClickListener(this);




// https://exemplefirebase-1423b-default-rtdb.europe-west1.firebasedatabase.app/


    }
    @Override
    public void onClick(View v){
        switch(v.getId()) {
            case R.id.bt_write:

                mDatabase = FirebaseDatabase.getInstance("https://exemplefirebase-1423b-default-rtdb.europe-west1.firebasedatabase.app/").getReference();

                mDatabase.setValue("Hello, World!");
                mDatabase.child("users").child("userId").setValue("user");
                mDatabase.child("users").child("userId5").setValue("user5");
                mDatabase.child("users").child("userId").setValue("user")
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                
                            }});



                mDatabase = FirebaseDatabase.getInstance("https://exemplefirebase-1423b-default-rtdb.europe-west1.firebasedatabase.app/").getReference();

                mDatabase.child("users").child("userId5").get().addOnSuccessListener();

                break;


        }
    }


}

