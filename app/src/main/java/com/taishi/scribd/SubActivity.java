package com.taishi.scribd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class SubActivity extends AppCompatActivity {

	ImageView ivThumbnail;
	String imageLink,sampleLink,isbn;
	TextView tvTitle,tvAuthor,tvReview,tvDescription;
	Button btnPlaySample;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub);

		ivThumbnail = (ImageView) findViewById(R.id.iv_thumbnail);
		btnPlaySample = (Button) findViewById(R.id.btn_play_sample);

		tvTitle = (TextView) findViewById(R.id.tv_title);
		tvAuthor = (TextView) findViewById(R.id.tv_author);
		tvReview = (TextView) findViewById(R.id.tv_review);

		Intent i = getIntent();
		imageLink = i.getStringExtra("IMAGELINK");
		sampleLink = i.getStringExtra("SAMPLELINK");
		isbn = i.getStringExtra("ISBN");
//		Log.v("imageLink",imageLink);

//		if(!(singleItem.getVolumeInfo().getImageLinks().getSmallThumbnail().isEmpty())){
			Glide.with(getApplicationContext())
					.load(imageLink)
					.diskCacheStrategy(DiskCacheStrategy.ALL)
					.centerCrop()
					.error(R.mipmap.ic_launcher)
					.into(ivThumbnail);
//		}


		btnPlaySample.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(getApplicationContext(),WebViewActivity.class);
				intent.putExtra("ISBN",isbn);
				startActivity(intent);
//				new FinestWebView.Builder(getApplicationContext()).show("https://books.google.com/books/reader?id=c9QGODYINKgC&hl=&printsec=frontcover&output=reader&source=gbs_api");
//				https://books.google.com/books/reader?id=c9QGODYINKgC&hl=&printsec=frontcover&output=reader&source=gbs_api
			}
		});
	}
}
