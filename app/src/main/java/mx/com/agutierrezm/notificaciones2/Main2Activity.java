package mx.com.agutierrezm.notificaciones2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import mx.com.agutierrezm.notificaciones2.service.ServiceNotification;

public class Main2Activity extends AppCompatActivity {

    private EditText etNombre;
    private EditText etDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        etNombre = (EditText)findViewById(R.id.etNombre);
        etDescripcion = (EditText)findViewById(R.id.etDescripcion);
        findViewById(R.id.btnsave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("key_name",etNombre.getText().toString());
                i.putExtra("key_description",etDescripcion.getText().toString());
                setResult(RESULT_OK,i);
                finish();
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.tbSave);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Hola mundo");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_2,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            case R.id.menu_update:
                startService((new Intent(getApplicationContext(), ServiceNotification.class)));
                return true;
            case R.id.menu_descarga:
                Toast.makeText(Main2Activity.this, "Descargando", Toast.LENGTH_SHORT).show();
                return true;


        }
        return super.onOptionsItemSelected(item);
    }
}

