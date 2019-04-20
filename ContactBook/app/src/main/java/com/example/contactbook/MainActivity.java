package com.example.contactbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {
    DatabaseReference dataBaseContacts;
    ListView message;
    EditText name, address, phone;
    Button save;
    Button delete;
    Button UpdateData;
    List<ContactBook> contactList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        dataBaseContacts = FirebaseDatabase.getInstance().getReference("Contacts");
        setContentView(R.layout.activity_main);
        message =(ListView) findViewById(R.id.listView);
        save    = findViewById(R.id.save);
        delete = findViewById(R.id.DeleteData);
        UpdateData = findViewById(R.id.UpdateData);
        name = (EditText) findViewById(R.id.name);
        address = (EditText) findViewById(R.id.address);
        phone = (EditText) findViewById(R.id.phone);
        contactList = new ArrayList<>();


       save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewContact();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteContact();
            }
        });
        UpdateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateContact();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        dataBaseContacts.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                contactList.clear();
                for(DataSnapshot contactSnapShot: dataSnapshot.getChildren()){
                    ContactBook contact = contactSnapShot.getValue(ContactBook.class);
                    contactList.add(contact);
                }
                ContactsList adapter = new ContactsList(MainActivity.this, contactList);
                message.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void addNewContact(){
        String Name = name.getText().toString();
        String Address = address.getText().toString();
        String Phone = phone.getText().toString();
        if(!TextUtils.isEmpty(Name)){
            ContactBook contact = new ContactBook(Name, Address, Phone);
            dataBaseContacts.child(Name).setValue(contact);
        }else{
            Toast.makeText(this,"You should enter a name", Toast.LENGTH_LONG).show();
        }
    }
    private void deleteContact(){
        String Name = name.getText().toString();
        String Address = address.getText().toString();
        String Phone = phone.getText().toString();
        if(!TextUtils.isEmpty(Name)){
            ContactBook contact = new ContactBook(Name, Address, Phone);
            dataBaseContacts.child(Name).removeValue();
        }else{
            Toast.makeText(this,"You should enter a name", Toast.LENGTH_LONG).show();
        }
    }
    private void updateContact(){
        String Name = name.getText().toString();
        String Address = address.getText().toString();
        String Phone = phone.getText().toString();
        if(!TextUtils.isEmpty(Name)){
            ContactBook contact = new ContactBook(Name, Address, Phone);
            dataBaseContacts.child(Name).setValue(contact);
        }else{
            Toast.makeText(this,"You should enter a name", Toast.LENGTH_LONG).show();
        }
    }
}