package id.sch.smktelkom_mlg.privateassignment.xirpl333.shown;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    public String url = "https://image.tmdb.org/t/p/w500";
    String Id, img, des, gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        Id = intent.getStringExtra("movie_title");
        img = intent.getStringExtra("poster_path");
        des = intent.getStringExtra("description");
        setTitle(Id);
        gambar = url + img;
        ImageView detail = (ImageView) findViewById(R.id.imageViewDetail);
        TextView descipsi = (TextView) findViewById(R.id.DetailDescription);
        Glide.with(this).load(gambar)
                .crossFade()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher)
                .into(detail);
        descipsi.setText(des);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
