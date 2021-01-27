package com.example.mylibrary;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.example.mylibrary.jobdispatcherservices.MyJobService;


public class ProductService extends Service {
    //IAdd service;
    int i;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // Return the interface
        return mBinder;
    }

    private final IRemoteProductService.Stub mBinder = new IRemoteProductService.Stub() {


        @Override
        public void addProduct(String name, int quantity, float cost) throws RemoteException {
            //Add product called on the service.
            //Idealy you should store the product in a local data base
            //or in some remote service.
            //You can add that code here . We are just storing in In memory list.
        }

        @Override
        public String getProduct(String name) throws RemoteException {
            //getProduct product called on the service.
            //Idealy you should store the product in a local data base
            //or in some remote service. Hence the product should be fetched from there.
            //You can add that code here .
            //We are just storing in In memory list.So fetching from in memory list.


            // connectService();

            JobScheduler jobScheduler = (JobScheduler) getApplicationContext().getSystemService(Context.JOB_SCHEDULER_SERVICE);

            JobInfo jobInfo = new JobInfo.Builder(11, new ComponentName(getApplicationContext(), MyJobService.class))
                    .build();

            jobScheduler.schedule(jobInfo);

            Intent intent=new Intent(getApplicationContext(),MainActivityLibrary.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("a",123);
            startActivity(intent);

            return i + "";


        }
    };


    /*private void connectService() {
        Intent i = new Intent();
        i.setClassName("com.example.serverdemo", "com.anilshokeen.mylibrary.LocalService");
        boolean ret = bindService(i, RemoteServiceConnection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection RemoteServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            service = IAdd.Stub.asInterface(iBinder);
            try {
                i = service.addNumbers(1, 1);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
*/

}
