package com.jhengweipan.Thunderstormsdivisiononehundredsign;


import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.jhengweipan.Guandisignonehundred.R;

public class HeadPageActivity extends Activity {
	private MediaPlayer mp;
	private AdView adView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_head_page);
		 // 建立 adView。
		
		AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

//
//	    // 啟動一般請求。
//	    AdRequest adRequest = new AdRequest.Builder().build();
//
//	    // 以廣告請求載入 adView。
//	    adView.loadAd(adRequest);
//		LinearLayout myLayout = (LinearLayout) findViewById(R.id.container);
//		AdLocusLayout ALLayout = new AdLocusLayout(this, 
//				AdLocusLayout.AD_SIZE_BANNER, //廣告大小, 可參考下表的ADSIZE, 非平板建議使用此項即可
//				"cd499e695a4171fb3a9d45b8863b872a127951d2",               //app key
//				15                            //輪播時間，最低 15 秒，-1 為不輪播只顯示一則
//				);
//
//		// 設定輪播動畫: 隨機, 置中
//		ALLayout.setTransitionAnimation(AdLocusLayout.ANIMATION_RANDOM);
//		LinearLayout.LayoutParams ALParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//		ALParams.gravity = Gravity.CENTER;
//
//		// 監聽廣告可加入下方範例
//
//		// 加入至您的Layout中
//		myLayout.addView(ALLayout, ALParams);
//		myLayout.setGravity(Gravity.CENTER_HORIZONTAL);
//		myLayout.invalidate();
//		mp = MediaPlayer.create(this, R.raw.music);
//		 mp.start();
//	        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//	            
//	            public void onCompletion(MediaPlayer mp) {
//	                mp.start();
//	            }
//	        });
////
////		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.head_page, menu);
		return true;
	}

public void BTC(View  v){
//	 mp.reset();
	Intent i = new Intent();
	i.setClass(this, ZeroActivity.class);
	startActivity(i);

	
}


}

