package com.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.app.adapter.carAdapter;

import com.app.beans.car;


import com.app.services.carservice;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private carservice cs;
    private ListView liste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cs= carservice.getInstance();

        cs.create(new car("SUV", 350, R.mipmap.suv));
        cs.create(new car("citadine", 200, R.mipmap.citadine));
        cs.create(new car("cabriolet", 450, R.mipmap.cabriolet));
        cs.create(new car("utilitaire", 400, R.mipmap.utilitaire));
        cs.create(new car("SUV", 350, R.mipmap.suv));
        cs.create(new car("citadine", 200, R.mipmap.citadine));
        cs.create(new car("cabriolet", 450, R.mipmap.cabriolet));
        cs.create(new car("utilitaire", 400, R.mipmap.utilitaire));




        liste = findViewById(R.id.liste);
        liste.setAdapter(new carAdapter(this, cs.findAll()));

        liste.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView idd = view.findViewById(R.id.id);

        Toast.makeText(this, idd.getText().toString(), Toast.LENGTH_SHORT).show();

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Choisir une option");
        alertDialogBuilder.setPositiveButton("Supprimer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

                cs.delete(cs.findById(Integer.parseInt(idd.getText().toString())));
                liste.setAdapter(new carAdapter(MainActivity.this, cs.findAll()));

            }
        });
        alertDialogBuilder.setNegativeButton("Details",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
}