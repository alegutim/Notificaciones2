package mx.com.agutierrezm.notificaciones2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

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
    }

}

