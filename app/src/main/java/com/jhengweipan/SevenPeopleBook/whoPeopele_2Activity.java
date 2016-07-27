package com.jhengweipan.SevenPeopleBook;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.NativeExpressAdView;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.jhengweipan.Guandisignonehundred.R;

public class whoPeopele_2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_who_peopele_2);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-7019441527375550~5747041824");
        NativeExpressAdView adView = (NativeExpressAdView)findViewById(R.id.NativeadView);
        AdRequest request = new AdRequest.Builder().addTestDevice("12FC57D3C43866AEAC108A9D2E96A704").build();
        adView.loadAd(request);



        AdLoader adLoader = new AdLoader.Builder(whoPeopele_2Activity.this, "ca-app-pub-7019441527375550/9441343821")
                .forAppInstallAd(new NativeAppInstallAd.OnAppInstallAdLoadedListener() {
                    @Override
                    public void onAppInstallAdLoaded(NativeAppInstallAd appInstallAd) {
                        Log.d("Jack", "onAppInstallAdLoaded");


                    }
                })
                .forContentAd(new NativeContentAd.OnContentAdLoadedListener() {
                    @Override
                    public void onContentAdLoaded(NativeContentAd contentAd) {
                        Log.d("Jack", "onContentAdLoaded");
                    }
                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(int errorCode) {
                        Log.d("Jack", "onAdFailedToLoad");
                        Log.d("Jack", errorCode+"");

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()
                        // Methods in the NativeAdOptions.Builder class can be
                        // used here to specify individual options settings.
                        .build())
                .build();
        adLoader.loadAd(new AdRequest.Builder().build());
    }


}
