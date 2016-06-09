package com.shopnosoft.dataconnection;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WifiManager wfm;
    private ConnectivityManager cntm;
    private
    Button wifi;
    Button mbldta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        wifi = (Button)findViewById(R.id.button_wifi);
        mbldta = (Button)findViewById(R.id.button_mobileData);

//Get the wifi service of device
        wfm= (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
//Get the Mobile Dtata service of device
        cntm=(ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo nInfo = cntm.getActiveNetworkInfo();


        wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(wfm.isWifiEnabled()){
                    //Toast.makeText(this,"Wifi is enabled",Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(),"Wifi is enabled", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Wifi is Disabled", Toast.LENGTH_LONG).show();

                }

            }
        });


        mbldta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if( nInfo!=null && nInfo.isConnected()){
                        //Toast.makeText(this,"Wifi is enabled",Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(),"Data is enabled", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Data is Disabled", Toast.LENGTH_LONG).show();
                    }

            }
        });


    }
}
