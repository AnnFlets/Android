package com.fletes.myappsensoresproxacel;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class MAProximidad extends AppCompatActivity {
    private Sensor sensor;
    private SensorManager sensorManager;
    private SensorEventListener sensorEventListener;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maproximidad);
        imageView = findViewById(R.id.imgOjos);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
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
                        imageView.setImageResource(R.drawable.ic_ojos_cerrados);
                    }else{
                        imageView.setImageResource(R.drawable.ic_ojos_abiertos);
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

    private void iniciarSensor(){
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    private void detenerSensor(){
        sensorManager.unregisterListener(sensorEventListener);
    }

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