package com.example.debuuger_logcat;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etA, etB; // Cajas de texto para los números
    private Button btnDividir; // Botón para dividir A y B (¡Va con B mayúscula!)
    private TextView tvResultado; // TextView para mostrar el resultado

    // TAG para poder filtrar tus mensajes en el Logcat de Android Studio
    private static final String TAG = "CESBA_DEBUG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ¡Aquí van los enlaces con la interfaz gráfica que faltaban!
        etA = findViewById(R.id.etA);
        etB = findViewById(R.id.etB);
        btnDividir = findViewById(R.id.btnDividir);
        tvResultado = findViewById(R.id.tvResultado);

        // Evento del botón al darle clic
        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 1. Extraemos el texto que escribió el usuario
                String aTxt = etA.getText().toString();
                String bTxt = etB.getText().toString();

                try {
                    // 2. Convertimos ese texto a números enteros (int)
                    int a = Integer.parseInt(aTxt);
                    int b = Integer.parseInt(bTxt);

                    // Imprime información en el Logcat (Letra 'i' de Info)
                    Log.i(TAG, "Convertidos: a=" + a + ", b=" + b);

                    // 3. Hacemos la operación
                    int resultado = a / b;

                    // 4. Mostramos el resultado en pantalla y en Logcat
                    tvResultado.setText("Resultado: " + resultado);
                    Log.i(TAG, "Resultado mostrado: " + resultado);

                } catch (ArithmeticException e) {
                    // Si intenta dividir entre cero, cae aquí
                    Log.e(TAG, "Division entre cero: " + e.getMessage()); // 'e' de Error
                    Toast.makeText(MainActivity.this, "No se puede dividir entre 0", Toast.LENGTH_SHORT).show();

                } catch (NumberFormatException e) {
                    // Si dejó el campo vacío o puso letras, cae aquí
                    Log.e(TAG, "Formato Invalido: " + e.getMessage());
                    Toast.makeText(MainActivity.this, "Ingresa números válidos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        sLED1.setOnCheckedChangeListener(new View.OnClickListener(){

        }


        ibtn_ventiladorON.setOnClickListener(new View.OnClickListener())
                @Override
                public void onClick(View view){
                    databasereference.child("/tarjeta/dispositivo/VENTILADOR/estado").setValue("ON");
                    ibtn_ventiladorOFF.setVisibility(View.VISIBLE);
                    ibtn_ventiladorON.setVisibility(View.GONE);
        }

        ibnt_ventiladorOFF.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                databasereference.child("/tarjeta/dispositivo/VENTILADOR/estado").setValue("ON");
            }
        }
    }
}