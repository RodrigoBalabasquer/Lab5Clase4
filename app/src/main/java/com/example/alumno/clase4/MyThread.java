package com.example.alumno.clase4;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by alumno on 11/04/2019.
 */

public class MyThread extends Thread {
    Handler handler;
    String url;
    int imagenText;
    public MyThread(Handler handler,String url, int imagenText){
        this.handler = handler;
        this.url = url;
        this.imagenText = imagenText;
    }
    @Override
    public void run(){
        HttpManager http = new HttpManager();
        Message m = new Message();
        m.arg1 = imagenText;
        if(imagenText == MainActivity.TEXTO){

            String s = http.Conectar(url);
            m.obj = s;
        }
        else{
            byte [] img = http.ConectarImagen(url);
            m.obj = img;
        }
        this.handler.sendMessage(m);
    }

}
