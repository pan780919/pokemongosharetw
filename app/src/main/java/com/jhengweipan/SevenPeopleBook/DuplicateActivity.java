package com.jhengweipan.SevenPeopleBook;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.jhengweipan.Guandisignonehundred.R;
import com.jhengweipan.ga.MyGAManager;
import com.nostra13.universalimageloader.core.ImageLoader;

import myAppKey.mykey;

public class DuplicateActivity extends Activity implements View.OnClickListener{
    private ImageView mImageView, mImageView2, mImageView3, mImageView4, mImageView5;
    private TextView mTextView,mTextView2,mTextView3,mTextView4,mTextView5;
    private InterstitialAd interstitial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duplicate);
        initLayout();
        MyGAManager.sendScreenName(DuplicateActivity.this,getString(R.string.ga_dargon));
        final AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("12FC57D3C43866AEAC108A9D2E96A704").build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                Log.d("JAck","使用者按下橫幅廣告後返回應用程式");
            }


        });

        interstitial = new InterstitialAd(this);
        interstitial.setAdUnitId(mykey.ad);
        interstitial.loadAd(adRequest);

    }

    private void initLayout() {
        ImageLoader loader = ImageLoaderInitializer.Instance(DuplicateActivity.this);
        mImageView = (ImageView) findViewById(R.id.duplicate_img1);
        mImageView2 = (ImageView) findViewById(R.id.duplicate_img2);
        mImageView3 = (ImageView) findViewById(R.id.duplicate_img3);
        mImageView4 = (ImageView) findViewById(R.id.duplicate_img4);
        mImageView5 = (ImageView) findViewById(R.id.duplicate_img5);
        findViewById(R.id.duplicate_img1).setOnClickListener(this);
        findViewById(R.id.duplicate_img2).setOnClickListener(this);
         findViewById(R.id.duplicate_img3).setOnClickListener(this);
        findViewById(R.id.duplicate_img4).setOnClickListener(this);
        findViewById(R.id.duplicate_img5).setOnClickListener(this);
//        mTextView = (TextView) findViewById(R.id.dargon_tittle1);
//        mTextView2 = (TextView) findViewById(R.id.dargon_tittle2);
//        mTextView3 = (TextView) findViewById(R.id.dargon_tittle3);
//        mTextView4 = (TextView) findViewById(R.id.dargon_tittle4);
//        mTextView5 = (TextView) findViewById(R.id.dargon_tittle5);
//        mTextView.setText(getString(R.string.dragon_tittle_1));
//        mTextView2.setText(getString(R.string.dragon_tittle_2));
//        mTextView3.setText(getString(R.string.dragon_tittle_3));
//        mTextView4.setText(getString(R.string.dragon_tittle_4));
//        mTextView5.setText(getString(R.string.dragon_tittle_5));
        loader.displayImage(getString(R.string.dragon_url_1),mImageView);
        loader.displayImage(getString(R.string.dragon_url_2),mImageView2);
        loader.displayImage(getString(R.string.dragon_url_3),mImageView3);
        loader.displayImage(getString(R.string.dragon_url_4),mImageView4);
        loader.displayImage(getString(R.string.dragon_url_5),mImageView5);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.duplicate_img1:
                Toast.makeText(DuplicateActivity.this,getString(R.string.dragon_tittle_1),Toast.LENGTH_SHORT).show();
                break;
            case R.id.duplicate_img2:
                Toast.makeText(DuplicateActivity.this,getString(R.string.dragon_tittle_2),Toast.LENGTH_SHORT).show();

                break;
            case R.id.duplicate_img3:
                Toast.makeText(DuplicateActivity.this,getString(R.string.dragon_tittle_3),Toast.LENGTH_SHORT).show();
                break;
            case R.id.duplicate_img4:
                Toast.makeText(DuplicateActivity.this,getString(R.string.dragon_tittle_4),Toast.LENGTH_SHORT).show();
                break;
            case R.id.duplicate_img5:
                Toast.makeText(DuplicateActivity.this,getString(R.string.dragon_tittle_5),Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
