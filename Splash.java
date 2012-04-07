package com.easydiagnosis.chestpain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class Splash extends Activity {

	public static Splash splash;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		setContentView(R.layout.splash);
		splash = this;
		
		TextView versionTextView = (TextView)findViewById(R.id.versiontext);
		versionTextView.setText("Version: "+getString(R.string.appVersion));
	}

	@Override
	public void onStart() {
		super.onStart();

		new Thread() {
			public void run() {
				splashHandler.sendEmptyMessageDelayed(0, 3000);

			}
		}.start();

	}

	// handler for splash screen
	private Handler splashHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 0:
				finish();
				startActivity(new Intent(Splash.this, MainActivity.class));
				break;

			}
			super.handleMessage(msg);
		}
	};

}
