package com.example.contactapp;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fetchContacts();  //fetchContacts() function is called inside the MainActivity
    }

    private void fetchContacts(){

        final ArrayList<String> contactsFirst = new ArrayList<>();//declaring the first array list
        final ArrayList<String> contactsSecond = new ArrayList<>();//declaring the second array list

        //All the arguments for the query method is initialised here
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String[] projection = {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER,
                ContactsContract.CommonDataKinds.Phone._ID, ContactsContract.CommonDataKinds.Phone.PHOTO_ID,
                ContactsContract.CommonDataKinds.Phone.PHOTO_THUMBNAIL_URI,  ContactsContract.CommonDataKinds.Phone.LOOKUP_KEY,
        ContactsContract.CommonDataKinds.Email._ID};
        String selection = null;
        String[] selectionArgs = null;

        //Content resolver provides access to the content model
        ContentResolver resolver  = getContentResolver();
        //cursor provides read-write access to the result set returned by the content resolver
        final Cursor cursor = resolver.query(uri, projection, selection, selectionArgs, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC");

        while(cursor.moveToNext()){

            //Each column are accessed using moveToNext() method
            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String num = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            String ID = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone._ID));
            String Photo_Id = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_ID));

            //Each value accessed previously are added to the array list
            contactsFirst.add(name+"\n"+num);
            contactsSecond.add(name+"\n"+num+"\n"+ID+"\n"+Photo_Id);
        }
        //Defining the list view
        ListView list = ((ListView)findViewById(R.id.listContacts));
        //arrayadapter creates the view and setadapter displays the value in list
        list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contactsFirst));

        //calling click method in the list
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            //when user clicks the list, next activity opens with Contact Details.
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Each value of the clicked list value is accessed here
                String listViewResult = contactsSecond.get(position);
                        //intent helps in sending the data from current activity to next activity
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        //message is the keyword used in the putExtra() method of intent, which is used in the nex activity to access the sent data
                        intent.putExtra("message",listViewResult);
                        startActivity(intent);
                }
        });

    }
}
