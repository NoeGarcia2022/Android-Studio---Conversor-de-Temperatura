package com.nagv.conversortemperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1=null;
    Spinner spinner1=null;
    TextView resultado=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText) findViewById(R.id.txt1);
        spinner1=(Spinner) findViewById(R.id.spinner1);
        resultado=(TextView) findViewById(R.id.tvResultado);

        String[]opciones={"SELECCIONE UNA OPCION", "°F a °C","°C a °F" };

        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, opciones);
        spinner1.setAdapter(adapter);
    }

    public void convertir(View view){
        if (et1.getText().toString().equals("")){
            Toast msg=Toast.makeText(this, "Ingrese una cantidad", Toast.LENGTH_SHORT);
            msg.show();
        }else{
            Double c=Double.parseDouble(et1.getText().toString());
            Double resul=null;
            int selec=spinner1.getSelectedItemPosition();
            switch (selec){
                case 0:
                    Toast.makeText(this, "Seleccione una opcion", Toast.LENGTH_SHORT).show();
                    break;

                case 1:
                    resul=(c-32)/1.8;
                    break;

                case 2:
                    resul=1.8*c+32;
                    break;
                default:
            }
            resultado.setText(resul.toString());
        }
    }

}