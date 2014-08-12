package com.example.magic_8;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements SensorEventListener {

	public TextView tvA, tvB;
	SensorManager sm;
	private static final int SHAKE_THRESHOLD = 800;
	long lastUpdate = 0;
	public float x, y, z;
	public float last_x = 0;
	public float last_y = 0;
	public float last_z = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		
		intials();

		if (sm.getSensorList(Sensor.TYPE_ACCELEROMETER).size() != 0) {
			Sensor r = sm.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
			sm.registerListener(this, r, SensorManager.SENSOR_DELAY_GAME);

		}

	}

	public void intials() {
		setContentView(R.layout.activity_main);
		sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		tvA = (TextView) findViewById(R.id.tv1);
		tvB = (TextView) findViewById(R.id.tv2);
	}

	public void job() {
		Random crazy = new Random();
		int k = crazy.nextInt(20);
		int i = 15;
		switch (k) {
		case 0:
			tvB.setText("It is certain");

			tvB.setTextColor(Color.rgb(crazy.nextInt(265), crazy.nextInt(265),
					crazy.nextInt(265)));
			break;
		case 1:
			tvB.setText("Outlook not so good");

			tvB.setTextColor(Color.rgb(crazy.nextInt(265), crazy.nextInt(265),
					crazy.nextInt(265)));
			break;
		case 2:
			tvB.setText("It is decidedly so");

			tvB.setTextColor(Color.rgb(crazy.nextInt(265), crazy.nextInt(265),
					crazy.nextInt(265)));
			break;
		case 3:
			tvB.setText("Without a doubt");

			tvB.setTextColor(Color.rgb(crazy.nextInt(265), crazy.nextInt(265),
					crazy.nextInt(265)));
			break;
		case 4:
			tvB.setText("Yes definitely");

			tvB.setTextColor(Color.rgb(crazy.nextInt(265), crazy.nextInt(265),
					crazy.nextInt(265)));
			break;
		case 5:
			tvB.setText("You may rely on it");

			tvB.setTextColor(Color.rgb(crazy.nextInt(265), crazy.nextInt(265),
					crazy.nextInt(265)));
			break;
		case 6:
			tvB.setText("As I see it, yes");

			tvB.setTextColor(Color.rgb(crazy.nextInt(265), crazy.nextInt(265),
					crazy.nextInt(265)));
			break;
		case 7:
			tvB.setText("Most likely");

			tvB.setTextColor(Color.rgb(crazy.nextInt(265), crazy.nextInt(265),
					crazy.nextInt(265)));
			break;
		case 8:
			tvB.setText("Outlook good");

			tvB.setTextColor(Color.rgb(crazy.nextInt(265), crazy.nextInt(265),
					crazy.nextInt(265)));
			break;
		case 9:
			tvB.setText("Yes");

			tvB.setTextColor(Color.rgb(crazy.nextInt(265), crazy.nextInt(265),
					crazy.nextInt(265)));
			break;
		case 10:
			tvB.setText("Signs point to yes");

			tvB.setTextColor(Color.rgb(crazy.nextInt(265), crazy.nextInt(265),
					crazy.nextInt(265)));
			break;
		case 11:
			tvB.setText("Very doubtful ");

			tvB.setTextColor(Color.rgb(crazy.nextInt(265), crazy.nextInt(265),
					crazy.nextInt(265)));
			break;
		case 12:
			tvB.setText("Reply hazy try again");

			tvB.setTextColor(Color.rgb(crazy.nextInt(265), crazy.nextInt(265),
					crazy.nextInt(265)));
			break;
		case 13:
			tvB.setText("Ask again later");

			tvB.setTextColor(Color.rgb(crazy.nextInt(265), crazy.nextInt(265),
					crazy.nextInt(265)));
			break;
		case 14:
			tvB.setText(" Better not tell you now");

			tvB.setTextColor(Color.rgb(crazy.nextInt(265), crazy.nextInt(265),
					crazy.nextInt(265)));
			break;
		case 15:
			tvB.setText("Cannot predict now");

			tvB.setTextColor(Color.rgb(crazy.nextInt(265), crazy.nextInt(265),
					crazy.nextInt(265)));
			break;
		case 16:
			tvB.setText("Concentrate and ask again");

			tvB.setTextColor(Color.rgb(crazy.nextInt(265), crazy.nextInt(265),
					crazy.nextInt(265)));
			break;
		case 17:
			tvB.setText("Don't count on it");

			tvB.setTextColor(Color.rgb(crazy.nextInt(265), crazy.nextInt(265),
					crazy.nextInt(265)));
			break;
		case 18:
			tvB.setText("My reply is no");

			tvB.setTextColor(Color.rgb(crazy.nextInt(265), crazy.nextInt(265),
					crazy.nextInt(265)));
			break;
		case 19:
			tvB.setText("My sources say no");

			tvB.setTextColor(Color.rgb(crazy.nextInt(265), crazy.nextInt(265),
					crazy.nextInt(265)));
			break;

		}

	}

	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSensorChanged(SensorEvent k) {
		// TODO Auto-generated method stub

		long curTime = System.currentTimeMillis();
		// only allow one update every 100ms.
		if ((curTime - lastUpdate) > 100) {
			long diffTime = (curTime - lastUpdate);
			lastUpdate = curTime;

			x = k.values[0];
			y = k.values[1];
			z = k.values[2];

			float speed = Math.abs(x + y + z - last_x - last_y - last_z)
					/ diffTime * 10000;

			if (speed > SHAKE_THRESHOLD) {
				
				job();
			}
			last_x = x;
			last_y = y;
			last_z = z;

		}
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		sm.unregisterListener(this);
	}

}
