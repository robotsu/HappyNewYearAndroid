/**
 * Author: À’Ïø
 * Create Date: 2013.12.25
 */
package com.objcc.happynewyear;

import com.objcc.happynewyear.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.ShareActionProvider;


public class MainActivity extends Activity {
	
	private WebView webView;
	
	private ShareActionProvider mShareActionProvider;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_fullscreen);
		
		webView = (WebView) this.findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/index.html");
        webView.getSettings().setJavaScriptEnabled(true);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate menu resource file.
	    getMenuInflater().inflate(R.menu.share, menu);

	    // Locate MenuItem with ShareActionProvider
	    MenuItem item = menu.findItem(R.id.menu_item_share);

	    // Fetch and store ShareActionProvider
	    mShareActionProvider = (ShareActionProvider) item.getActionProvider();
	    
	    setShareIntent(CreateIntent ());

	    // Return true to display menu
	    return true;
	}
	
	Intent CreateIntent ()
    {   
		Intent sendTextIntent = new Intent (Intent.ACTION_SEND);
		sendTextIntent.setType ("text/*");            
		sendTextIntent.putExtra (android.content.Intent.EXTRA_TEXT, 
				this.getString(R.string.share_content));

        return sendTextIntent;
    }

	// Call to update the share intent
	private void setShareIntent(Intent shareIntent) {
	    if (mShareActionProvider != null) {
	        mShareActionProvider.setShareIntent(shareIntent);
	    }
	}
}
