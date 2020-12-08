package com.example.eva_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.Prestos;


public class Prestamos_act extends AppCompatActivity {

    private Spinner spin1, spin2;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamos_act);

        text = (TextView)findViewById(R.id.tvRes);
        spin1 = (Spinner)findViewById(R.id.spinCl);
        spin2 = (Spinner)findViewById(R.id.spinPr);

        ArrayList<String> listaCliente = (ArrayList<String>) getIntent().getSerializableExtra("listaCliente");
        ArrayAdapter<String> ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaCliente);
        spin1.setAdapter(ad);

        ArrayList<String> listaPrestamos = (ArrayList<String>) getIntent().getSerializableExtra("listaPrestamos");
        ArrayAdapter<String> ad2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaPrestamos);
        spin2.setAdapter(ad2);

    }

    public void calPrestamo(View v)
    {
        Prestos pre = new Prestos();
        String cliente = spin1.getSelectedItem().toString();
        String prestamos = spin2.getSelectedItem().toString();
        int hipotecario = Integer.parseInt(pre.getHipotecario());
        int automotriz = Integer.parseInt(pre.getAutomotriz());
        int saldAlex = 750000;
        int salRoxana = 900000;
        int saldo = 0;

        if(cliente.equals("AXEL")) {
            if (prestamos.equals("Hipotecario"))
            {
                saldo = hipotecario - saldAlex;
                text.setText("El valor del saldo es: "+ saldo);
            }
            if(prestamos.equals("Automotriz"))
            {
                saldo = hipotecario - saldAlex;
                text.setText("El valor del saldo es: "+ saldo);
            }

        }

        if(cliente.equals("ROXANA"))
        {
            if (prestamos.equals("Hipotecario"))
            {
                saldo = hipotecario - salRoxana;
                text.setText("El valor del saldo es: "+ saldo);
            }
            if(prestamos.equals("Automotriz"))
            {
                saldo = hipotecario - salRoxana;
                text.setText("El valor del saldo es: "+ saldo);
            }
        }
    }

    public void calDeuda(View v)
    {
        Prestos pre = new Prestos();
        String cliente = spin1.getSelectedItem().toString();
        String prestamos = spin2.getSelectedItem().toString();
        int hipotecario = Integer.parseInt(pre.getHipotecario());
        int automotriz = Integer.parseInt(pre.getAutomotriz());
        int saldAlex = 750000;
        int salRoxana = 900000;
        int saldo = 0;
        float cuota = 0;

        if(cliente.equals("AXEL")) {
            if (prestamos.equals("Hipotecario"))
            {
                saldo = hipotecario - saldAlex;
                cuota = saldo / 12;
                text.setText("El valor del saldo es: "+ saldo + "\n" + "El valor cuota es: "+ cuota );
            }
            if(prestamos.equals("Automotriz"))
            {
                saldo = hipotecario - saldAlex;
                cuota = saldo / 8;
                text.setText("El valor del saldo es: "+ saldo + "\n" + "El valor cuota es: "+ cuota );
            }

        }

        if(cliente.equals("ROXANA"))
        {
            if (prestamos.equals("Hipotecario"))
            {
                saldo = hipotecario - salRoxana;
                cuota = saldo / 12;
                text.setText("El valor del saldo es: "+ saldo + "\n" + "El valor cuota es: "+ cuota );
            }
            if(prestamos.equals("Automotriz"))
            {
                saldo = hipotecario - salRoxana;
                cuota = saldo / 8;
                text.setText("El valor del saldo es: "+ saldo + "\n" + "El valor cuota es: "+ cuota );
            }
        }
    }

}