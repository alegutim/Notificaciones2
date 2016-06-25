package mx.com.agutierrezm.notificaciones2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import mx.com.agutierrezm.notificaciones2.service.ServiceNotification;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnstartSerice).setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                startService((new Intent(getApplicationContext(), ServiceNotification.class)));
            }
        });
    }
}
