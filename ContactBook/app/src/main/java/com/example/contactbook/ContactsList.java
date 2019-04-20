package com.example.contactbook;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class ContactsList extends ArrayAdapter<ContactBook> {
    private Activity context;
    private List<ContactBook> contactList;

    public ContactsList(Activity context, List<ContactBook> contactList)
    {
        super(context, R.layout.contact_list, contactList);
        this.context = context;
        this.contactList = contactList;
    }

   @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.contact_list, null, true);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewAddress = (TextView) listViewItem.findViewById(R.id.textViewAddress);
        TextView textViewPhone = (TextView) listViewItem.findViewById(R.id.textViewPhone);

        ContactBook contact = contactList.get(position);

        textViewName.setText(contact.getName());
       textViewAddress.setText(contact.getAddress());
       textViewPhone.setText(contact.getPhone());
       return listViewItem;


    }
}
