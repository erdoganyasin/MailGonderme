package com.example.mailgonderme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText icerik ;
    EditText konu;
    EditText mailAdres;
    Button button;

    String icerikText, konuText, mailAdresText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Tanımla();
        Bilgial();
        mailUygulamalarınıGorveGonder();
    }

    public void  Tanımla()
    {
        icerik = findViewById(R.id.editTextMailIcerik);
        konu = findViewById(R.id.editTextMailKonu);
        mailAdres = findViewById(R.id.editTextMailAdres);
        button = findViewById(R.id.butonAramaYap);

    }

    public void Bilgial()
    {
        icerikText = icerik.getText().toString();
        konuText = konu.getText().toString();
        mailAdresText = mailAdres.getText().toString();
    }

    public void mailUygulamalarınıGorveGonder()
    {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bilgial();
                try {

                    Intent ıntent = new Intent(Intent.ACTION_SEND);
                    ıntent.setType("message/rfc822");
                    ıntent.putExtra(Intent.EXTRA_EMAIL,mailAdresText);
                    ıntent.putExtra(ıntent.EXTRA_SUBJECT,konuText);
                    ıntent.putExtra(ıntent.EXTRA_TEXT,mailAdresText);
                    startActivity(Intent.createChooser(ıntent,"Mail Gönderinizzz"));

                }catch (Exception e)
                {
                    System.out.print(""+e);
                }


            }
        });
    }
}
