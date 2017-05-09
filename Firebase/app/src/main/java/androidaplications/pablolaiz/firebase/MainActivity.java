package androidaplications.pablolaiz.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private DatabaseReference mDatabase_user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        // To add or modify database
        mDatabase.child("HOLAHOLA").setValue("holasf");
        mDatabase.child("Hola1").child("hola2").setValue("eloii");
        mDatabase.child("Hola1").child("hola_as").setValue("pablo");

        mDatabase_user = mDatabase.child("HOLAHOLA");
        mDatabase_user.push().child("hola2").setValue("eloii");

        //Push object
        // Push create a inner id
        HashMap<String, String> dataMap = new HashMap<String, String>();
        dataMap.put("Name", "holii");
        dataMap.put("Email", "gmail");

        mDatabase.child("NewObject").push().setValue(dataMap);

        //query all database

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name = dataSnapshot.getValue().toString();
                Log.i("query?", name);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
