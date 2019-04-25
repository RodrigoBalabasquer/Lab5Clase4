package com.example.alumno.clase4;

import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback {
    List<PersonaModel> personas;
    public static final int TEXTO = 1;
    public static final int IMAGEN = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler(this);
        //https://jsonplaceholder.typicode.com/users
        //http://www.lslutnfra.com/alumnos/practicas/listaPersonas.xml

        MyThread hilo = new MyThread(handler,"http://www.lslutnfra.com/alumnos/practicas/listaPersonas.xml",TEXTO);
        hilo.start();
        MyThread hilo2 = new MyThread(handler,"http://www.lslutnfra.com/pagina404/homer404.jpg",IMAGEN);
        hilo2.start();
    }

    @Override
    public boolean handleMessage(Message msg) {
        if(msg.arg1 == TEXTO){
            TextView textConexion = (TextView)super.findViewById(R.id.conexion);
            //Log.d("Mensaje del hilo",msg.obj.toString());
            textConexion.setText(msg.obj.toString());
        }
        else{
            ImageView imagen = (ImageView)super.findViewById(R.id.imagen);
            imagen.setImageBitmap(BitmapFactory.decodeByteArray((byte[])msg.obj,0,((byte[]) msg.obj).length));
        }
        return false;
    }
}
