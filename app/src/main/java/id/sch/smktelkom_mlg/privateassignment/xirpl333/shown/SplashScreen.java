package id.sch.smktelkom_mlg.privateassignment.xirpl333.shown;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        EasySplashScreen config = new EasySplashScreen(SplashScreen.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(5000)
                .withBackgroundColor(Color.parseColor("#0ED2F7"))
                .withLogo(R.mipmap.ic_launcher)
                .withAfterLogoText("Show !n")
                .withFooterText("Copyright 2017");

        config.getAfterLogoTextView().setTextColor(Color.BLUE);
        config.getFooterTextView().setTextColor(Color.BLUE);

        View view = config.create();
        setContentView(view);
    }
}
