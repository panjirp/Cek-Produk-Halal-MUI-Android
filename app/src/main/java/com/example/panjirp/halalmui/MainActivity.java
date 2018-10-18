package com.example.panjirp.halalmui;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG ="MainActivity" ;
    private PaginationAdapter sAdapter;
    //create variables for storing message & button objects
    private EditText msgTextField;
    private Spinner staticSpinner;
    private String spinK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        staticSpinner = (Spinner) findViewById(R.id.static_spinner);
        msgTextField = (EditText) findViewById(R.id.search);

        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter.createFromResource(this, R.array.kategori, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        staticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        staticSpinner.setAdapter(
                new NothingSelectedSpinnerAdapter(
                        staticAdapter,
                        R.layout.contact_spinner_row_nothing_selected,
                        // R.layout.contact_spinner_nothing_selected_dropdown, // Optional
                        this));



    }
    public void onClick(View v) {
        Intent semuaKat = new Intent(MainActivity.this, Kategori.class);
        startActivity(semuaKat);
    }
    //When the send button is clicked
    public void send(View v)
    {
        if(staticSpinner.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView)staticSpinner.getSelectedView();
            errorText.setError("");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Harap Pilih Kategori");
        }
        else if(msgTextField.getText().toString().equals("") ){
            msgTextField.setError("required");
            msgTextField.setHintTextColor(Color.RED);//just to highlight that this is an error
            msgTextField.setHint("Harap Diisi");
        }
        else {
            if (staticSpinner.getSelectedItem().equals("Nama Produk")) {
                spinK = "nama_produk";
            } else if (staticSpinner.getSelectedItem().equals("Nama Produsen")) {
                spinK = "nama_produsen";
            } else {
                spinK = "nomor_sertifikat";
            }
            String msgSearch = msgTextField.getText().toString();
            Intent searchIntent = new Intent(MainActivity.this, HasilCari.class);
            Bundle extras = new Bundle();
            extras.putString("spinKat", spinK);
            extras.putString("msgSearch", msgSearch);
            searchIntent.putExtras(extras);
            startActivity(searchIntent);
            Log.v(TAG, spinK);
        }
    }
}