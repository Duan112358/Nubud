package com.emacs.nubud;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DetailsActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);
		
		WebView webView = (WebView)findViewById(R.id.webView);
		webView.setWebViewClient(new MyWebViewClient());
		String url = getIntent().getStringExtra("articleURL");
		webView.loadUrl(url);
	}
	
	private class MyWebViewClient extends WebViewClient{
		@Override
	    public boolean shouldOverrideUrlLoading(WebView view, String url) {
	        /*if (Uri.parse(url).getHost().equals("android-developers.blogspot.com")) {
	            // This is my web site, so do not override; let my WebView load the page
	            return false;
	        }
	        // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
	        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
	        startActivity(intent);*/
	        return false;
	    }
	}
}
