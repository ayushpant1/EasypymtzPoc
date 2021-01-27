package com.example.serverdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

import com.example.mylibrary.IRemoteProductService;
import com.example.mylibrary.interfaces.MyProduct;

public class MainActivity2 extends AppCompatActivity implements MyProduct {
    private  IRemoteProductService service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        connectService();
    }

    private void connectService() {

        Intent i = new Intent();
        i.setClassName("com.example.serverdemo","com.example.mylibrary.ProductService");

        boolean ret = bindService(i, RemoteServiceConnection, Context.BIND_AUTO_CREATE);
        Log.d("service status",String.valueOf(ret));
    }

    private  ServiceConnection RemoteServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        service = IRemoteProductService.Stub.asInterface(iBinder);

            try {
                service.getProduct("");

            } catch (RemoteException e) {
                e.printStackTrace();
            }
            String xyx="";
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            String v="";

        }
    };

    @Override
    public void getProduct(String name) {
        Toast.makeText(MainActivity2.this,name,Toast.LENGTH_LONG).show();
    }
}