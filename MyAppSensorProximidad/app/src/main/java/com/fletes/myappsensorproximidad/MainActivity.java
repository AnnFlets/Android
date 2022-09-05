package com.fletes.myappsensorproximidad;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Sensor sensor;
    private SensorManager sensorManager;
    private SensorEventListener sensorEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Define la activación y uso de un sensor a futuro
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        //Define el tipo de sensor que se va a utilizar
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        accionDelSensorProximidad();
        iniciarSensor();
    }

    private void accionDelSensorProximidad(){
        if(sensor != null){
            sensorEventListener = new SensorEventListener() {
                @Override
                public void onSensorChanged(SensorEvent event) {
                    if(event.values[0] < sensor.getMaximumRange()){
                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FA69B8"));
                    }else{
                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#F5FF29"));
                    }
                }

                @Override
                public void onAccuracyChanged(Sensor sensor, int accuracy) {

                }
            };
        }else{
            Toast.makeText(this, "No cuenta con el sensor a utilizar", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    //Método para inicia la acción y escucha del sensor
    private void iniciarSensor(){
        //Escuchador, sensor, proceso para estimar el acercamiento del sensor
        //Qué tanto va a tardar el sensor en activarse al utilizarlo
        //Tiempo de reacción
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    //Método para detener la acción y escucha del sensor
    private void detenerSensor(){
        sensorManager.unregisterListener(sensorEventListener);
    }

    //Métodos que se encargarán del comportamiento de la actividad para el sensor
    //Controlar un comportamiento de algo que se desea
    @Override
    protected void onResume() {
        super.onResume();
        iniciarSensor();
    }

    @Override
    protected void onPause() {
        super.onPause();
        detenerSensor();
    }
}