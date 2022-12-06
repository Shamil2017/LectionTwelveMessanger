package com.example.lectiontwelvemessanger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = "MainActivity";
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();


        auth.createUserWithEmailAndPassword("shami25@mail.ru", "12345679").addOnSuccessListener
                (new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        FirebaseUser user = auth.getCurrentUser();
                        if (user==null)
                        {
                            Log.d(LOG_TAG, "No authorizes");
                        }
                        else
                        {
                            Log.d(LOG_TAG, "Authorizes");
                            Toast.makeText(MainActivity.this,
                                    "autorizes", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this,
                        e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}