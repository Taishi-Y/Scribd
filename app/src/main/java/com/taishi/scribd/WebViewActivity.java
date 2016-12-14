package com.taishi.scribd;

/**
 * Created by yamasakitaishi on 2016/11/26.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * Created by TheFinestArtist on 3/11/16.
 */
public class WebViewActivity extends AppCompatActivity {

	FloatingActionButton fabNext,fabBack;
	WebView webView;
	String isbn;

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

//		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
//		getSupportActionBar().hide();


		setContentView(R.layout.webview);


		Intent i = getIntent();
		isbn = i.getStringExtra("ISBN");

		fabNext = (FloatingActionButton) findViewById(R.id.fab_next);
		fabBack = (FloatingActionButton) findViewById(R.id.fab_back);

		webView = (WebView) findViewById(R.id.webView);
		webView.getSettings().setJavaScriptEnabled(true);
//		webView.loadUrl("http://books.google.com/books/reader?id=c9QGODYINKgC&hl=&printsec=frontcover&output=reader&source=gbs_api");


		String html ="<!DOCTYPE html '-//W3C//DTD XHTML 1.0 Strict//EN'\n" +
				"  'http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd'>\n" +
				"<html xmlns='http://www.w3.org/1999/xhtml'>\n" +
				"  <head>\n" +
				"    <meta name='viewport' content='width=device-width, initial-scale=1, maximum-scale=1'>\n" +
				"    <meta http-equiv='content-type' content='text/html; charset=utf-8'/>\n" +
				"    <title></title>\n" +
				"    <script type='text/javascript' src='https://www.google.com/books/jsapi.js'></script>\n" +
				"    <script type='text/javascript'>\n" +
				"      google.books.load();\n" +
				"\n" +
				"      var viewer;\n" +
				"      function nextStep() {\n" +
				"        this.viewer.nextPage();\n" +
				"      }\n" +
				"\n" +
				"      function backStep() {\n" +
				"        this.viewer.previousPage();\n" +
				"      }\n" +
				"      \n" +
				"      function initialize() {\n" +
				"        viewer = new google.books.DefaultViewer(document.getElementById('viewerCanvas'));\n" +
				"        viewer.load('ISBN:"+"0738531367"+"');\n" +
				"      }\n" +
				"\n" +
				"      google.books.setOnLoadCallback(initialize);\n" +
				"    </script>\n" +
				"  </head>\n" +
				"  <body>\n" +
				"    <div id='viewerCanvas' style='width: 400px; height: 700px'></div>\n" +
				"  </body>\n" +
				"</html>";

		webView.loadData( html, "text/html", "utf-8" );


//		webView.loadUrl("file:///android_asset/wevview.html");
//		webView.loadUrl("javascript:isbnInitialize('9780226115047');");


		fabNext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				webView.loadUrl("javascript:nextStep();");
			}
		});

		fabBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				webView.loadUrl("javascript:backStep();");
			}
		});
	}
}