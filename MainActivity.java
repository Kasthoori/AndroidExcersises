package application.ucsc.com.smsapplication;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button sendbtn, resetbtn;
    EditText phonenum, mess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendbtn = (Button) findViewById(R.id.sendbtn);
        resetbtn = (Button) findViewById(R.id.resetbtn);

        sendbtn.setOnClickListener(this);
        resetbtn.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {

        phonenum = (EditText) findViewById(R.id.phonenumber);
        mess = (EditText) findViewById(R.id.messbody);

        String teleNum = phonenum.getText().toString();
        String meesBody = mess.getText().toString();


          switch (v.getId()){

              case R.id.sendbtn:

                  //Toast.makeText(getApplicationContext(), "Tele:" + teleNum + "\n Text: " + meesBody, Toast.LENGTH_LONG).show();

                 SmsManager  smsManager = SmsManager.getDefault();
                 smsManager.sendTextMessage(teleNum, null, meesBody,null, null);

                  break;

              case R.id.resetbtn:


                  phonenum.setText("");
                  mess.setText("");

                  break;

          }

    }


    private void sendSMS(String phoneNum, String message){

        String SENT = "SMS_SENT";
        String DELIVERED = "SMS_DELIVERED";

        PendingIntent sentPI = PendingIntent.getBroadcast(this, 0, new Intent(SENT), 0);
        
        PendingIntent deliveredPI = PendingIntent.getBroadcast(this, 0 , new Intent(DELIVERED), 0);
        
        
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                
                switch (getResultCode()){

                    case Activity.RESULT_OK:

                        Toast.makeText(getApplicationContext(), "SMS sent", Toast.LENGTH_LONG).show();

                        break;

                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:

                        Toast.makeText(getApplicationContext(), "Generic Failure", Toast.LENGTH_LONG).show();
                        break;

                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                        Toast.makeText(getApplicationContext(), "No Service", Toast.LENGTH_LONG).show();

                        break;

                    case SmsManager.RESULT_ERROR_NULL_PDU:

                        Toast.makeText(getApplicationContext(), "Null PDU", Toast.LENGTH_LONG).show();

                        break;

                    case SmsManager.RESULT_ERROR_RADIO_OFF:

                        Toast.makeText(getApplicationContext(), "Radio Off", Toast.LENGTH_LONG).show();

                        break;
                }
                
            }
        })


    }

    private void registerReceiver(BroadcastReceiver broadcastReceiver) {
    }
}
