package com.example.exemplefirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;


import com.google.android.play.core.tasks.OnFailureListener;
import com.google.android.play.core.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.view.View;
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    casseobjet oobj;
    TextView tvread;
    private DatabaseReference mDatabase;
Button btwrite,btread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabase = FirebaseDatabase.getInstance("https://exemplefirebase-1423b-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
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



                mDatabase.setValue("Hello, World!");
                mDatabase.child("users").child("userId1").setValue("user11");
                mDatabase.child("users").child("userId2").setValue("user22");
                mDatabase.child("users").child("userId3").setValue("user33")
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                
                            }});



                mDatabase = FirebaseDatabase.getInstance("https://exemplefirebase-1423b-default-rtdb.europe-west1.firebasedatabase.app/").getReference();



                break;
            case R.id.bt_read:

                final String[] userString = new String[1];

                mDatabase.child("users").get()
                        .addOnSuccessListener(new OnSuccessListener<DataSnapshot>() {
                            @Override
                            public void onSuccess(DataSnapshot dataSnapshot) {
                               // userString[0] = dataSnapshot.getValue().toString();
                                String abc = dataSnapshot.child("userId1").getValue().toString();
                                oobj = new casseobjet (dataSnapshot.child("userId1").getValue().toString(),dataSnapshot.child("userId2").getValue().toString(),dataSnapshot.child("userId3").getValue().toString());
                                tvread.setText(abc);
                            }
                        });



                break;





        }
    }



    private void finallya() {
        //case R.id.bt_read:

        final String[] userString = new String[1];

        mDatabase.child("users").get()
                .addOnSuccessListener(new OnSuccessListener<DataSnapshot>() {
                    @Override
                    public void onSuccess(DataSnapshot dataSnapshot) {
                        userString[0] = dataSnapshot.getValue().toString();
                        tvread.setText(userString[0]);
                    }
                });
    }


}

