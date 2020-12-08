package com.example.eva_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Clases.AdminSQLiteOpenHelper;

public class Gestion_act extends AppCompatActivity {

    private EditText edCodigo,edNombre,edSalario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_act);

        edCodigo = (EditText)findViewById(R.id.etCod);
        edNombre = (EditText)findViewById(R.id.etNom);
        edSalario = (EditText)findViewById(R.id.etSal);
    }

    public void AnadirCliente(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase(); //Permito la sobre escritura en mi base de datos.

        if(!edCodigo.getText().toString().isEmpty())
        {
            ContentValues registro = new ContentValues();//Añade insumo

            registro.put("codigo", edCodigo.getText().toString());
            registro.put("nombre", edNombre.getText().toString());
            registro.put("salario", edSalario.getText().toString());


            edCodigo.setText("");
            edNombre.setText("");
            edSalario.setText("");


            bd.insert("gestion", null, registro);
            bd.close();

            Toast.makeText(this, "Se ha guardado un cliente",Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(this,"Debe ingresar cliente",Toast.LENGTH_LONG).show();
        }

    }

    public void MostrarCliente(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String codigo = edCodigo.getText().toString();

        if(!codigo.isEmpty())
        {
            //Clase cursor me permite recorrer filas
            Cursor fila = bd.rawQuery("SELECT nombre, salario FROM insumos where codigo="+codigo,null);

            if(fila.moveToFirst())
            {
                edNombre.setText(fila.getString(0));
                edSalario.setText(fila.getString(1));


                edCodigo.setText("");
                edNombre.setText("");
                edSalario.setText("");

            }
            else{
                Toast.makeText(this,"El cliente no existe",Toast.LENGTH_LONG).show();
            }

        }
        else
        {
            Toast.makeText(this, "Debe ingresar el codigo del cliente", Toast.LENGTH_SHORT).show();
        }
    }

    public void EliminarCliente(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String codigo = edCodigo.getText().toString();

        if(!codigo.isEmpty())
        {

            bd.delete("gestion","codigo="+codigo,null);//Eliminar el campo según el codigo
            bd.close();
            Toast.makeText(this,"Has eliminado al cliente",Toast.LENGTH_LONG).show();

            edCodigo.setText("");
            edNombre.setText("");
            edSalario.setText("");


        }
        else
        {
            Toast.makeText(this, "Debe ingresar el codigo del cliente", Toast.LENGTH_SHORT).show();
        }



    }

    public void ActualizarCliente(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String codigo = edCodigo.getText().toString();

        ContentValues cont = new ContentValues();

        cont.put("codigo", edCodigo.getText().toString());
        cont.put("nombre", edNombre.getText().toString());
        cont.put("salario", edSalario.getText().toString());


        if(!codigo.isEmpty())
        {
            bd.update("gestion", cont, "codigo="+codigo, null);
            Toast.makeText(this, "Se ha actualizado el campo",Toast.LENGTH_LONG).show();

            edCodigo.setText("");
            edNombre.setText("");
            edSalario.setText("");



        }
    }


}