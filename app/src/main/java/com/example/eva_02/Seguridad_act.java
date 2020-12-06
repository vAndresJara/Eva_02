package com.example.eva_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Seguridad_act extends AppCompatActivity {

    private EditText edit;
    private TextView tvi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguridad_act);

        edit = (EditText)findViewById(R.id.etSeg);
        tvi = (TextView)findViewById(R.id.tvSeg);
    }

    private SecretKeySpec generateKey(String password)throws Exception{

        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        byte[] key = password.getBytes("UTF-8");
        key = sha.digest(key);
        SecretKeySpec secretkey = new SecretKeySpec(key, "AES");


        return secretkey;
    }

    public String Encriptar(String datos, String password) throws Exception{
        if(!edit.getText().toString().isEmpty())//Si no esta vacio el edit text
        {
            //hago el encriptado de datos
            SecretKeySpec secretkey = generateKey(password);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretkey);

            byte[] datosEncriptadosByte = cipher.doFinal(datos.getBytes()); //Cadena de byte para su encriptación
            String datosEncriptadosString = Base64.encodeToString(datosEncriptadosByte, Base64.DEFAULT); //encode a String
            return datosEncriptadosString;
        }
        else
        {
            Toast.makeText(this, "Debe inhresar una clave", Toast.LENGTH_LONG).show();
            return null;
        }

    }

    public void Encriptar1(View v)
    {
        try{
            String mensaje = Encriptar(edit.getText().toString(), tvi.getText().toString());
            tvi.setText(mensaje);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}