package com.jhengweipan.pokemongo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.ValueCallback;
import android.webkit.WebView;

import com.adlocus.PushAd;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.iid.FirebaseInstanceId;
import com.igexin.sdk.PushManager;
import com.jhengweipan.Guandisignonehundred.R;
import com.jhengweipan.MyAPI.VersionChecker;
import com.jhengweipan.ga.MyGAManager;

import myAppKey.mykey;


public class MainActivity extends Activity {
    private WebView mCityStroeWebView;
    Context context = MainActivity.this;
    ProgressDialog myDialog = null;
    private ValueCallback<Uri> mUploadMessage;
    private final static int FILECHOOSER_RESULTCODE = 1;
    private String uri ;
    private boolean isNetWork = true;
    private boolean isFirst = true;
    private ValueCallback<Uri[]> mFilePathCallback;
    private String mCameraPhotoPath;
    private FirebaseAnalytics mFirebaseAnalytics;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent promotionIntent = new Intent(this, MainActivity.class);
        PushAd.enablePush(MainActivity.this, mykey.AdLoucsKey, promotionIntent);
//        PushAd.test(this);
        configVersionCheck();
        PushManager.getInstance().initialize(this.getApplicationContext());
//        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
//        Bundle bundle = new Bundle();
//        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "123");
//        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "test");
//        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);



        if (savedInstanceState == null) {

            getFragmentManager().beginTransaction()
                    .add(R.id.container, new MainFragment())
                    .commit();
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }





    @Override
    protected void onStart() {

        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {

        super.onPause();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.e("landscape","landscape");
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Log.e("portrait", "portrait");
        }
        super.onConfigurationChanged(newConfig);
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if ((keyCode == KeyEvent.KEYCODE_BACK)) {   //確定按下退出鍵

            ConfirmExit(); //呼叫ConfirmExit()函數

            return true;

        }

        return super.onKeyDown(keyCode, event);

    }



    public void ConfirmExit() {

        AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this); //創建訊息方塊

        ad.setTitle("離開");

        ad.setMessage("確定要離開?");

        ad.setPositiveButton("是", new DialogInterface.OnClickListener() { //按"是",則退出應用程式

            public void onClick(DialogInterface dialog, int i) {

                MainActivity.this.finish();//關閉activity

            }

        });

        ad.setNegativeButton("否", new DialogInterface.OnClickListener() { //按"否",則不執行任何操作

            public void onClick(DialogInterface dialog, int i) {

            }

        });

        ad.show();//顯示訊息視窗


    }

    private void configVersionCheck() {

//        if (!GtApi.checkNetwork(IndexActivity.this)) return;

        VersionChecker.checkOnce(this, new VersionChecker.DoneAdapter() {

            @Override
            public void onHasNewVersion() {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("已有最新版本!")
                        .setMessage("目前有最新版本上架,請盡快更新")
                        .setNegativeButton("確定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                MyGAManager.sendActionName(MainActivity.this,"updata","installation");
                                startActivity(VersionChecker.openMartketIntent());
                                dialog.dismiss();
                            }
                        })
                        .show();
            }


        });

    }

}



