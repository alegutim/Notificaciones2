package mx.com.agutierrezm.notificaciones2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import mx.com.agutierrezm.notificaciones2.service.ServiceNotification;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_CODE_SECOND_ACTIVITY =1;
    private TextView txtnombre;
    private TextView txtdescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnstartSerice).setOnClickListener(this);
        findViewById(R.id.txteditar).setOnClickListener(this);

        txtnombre = (TextView)findViewById(R.id.txtnombre);
        txtdescripcion = (TextView)findViewById(R.id.txtdescripcion);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tbSave);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Hola mundo");
        getSupportActionBar().setIcon(android.R.drawable.ic_dialog_email);

        //getSupportActionBar().setLogo(R.drawable.ic_communication_ring_volume);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnstartSerice:
                iniService();
                break;
            case R.id.txteditar:
                startActivityForResult(new Intent(getApplicationContext(),Main2Activity.class)
                        ,REQUEST_CODE_SECOND_ACTIVITY);
                break;
        }
            
        
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (REQUEST_CODE_SECOND_ACTIVITY==requestCode && resultCode==RESULT_OK){
            String name = data.getExtras().getString("key_name"," ");
            String description = data.getExtras().getString("key_description"," ");
            txtnombre.setText(name);
            txtdescripcion.setText(description);
            getSupportActionBar().setTitle(name);
        }else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }



    protected void iniService(){
        startService((new Intent(getApplicationContext(), ServiceNotification.class)));
    }
    
    
}
