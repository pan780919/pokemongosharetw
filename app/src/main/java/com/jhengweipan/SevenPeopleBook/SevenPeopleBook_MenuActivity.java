package com.jhengweipan.SevenPeopleBook;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.adlocus.PushAd;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.igexin.sdk.PushManager;
import com.jhengweipan.Guandisignonehundred.R;
import com.jhengweipan.MyAPI.VersionChecker;
import com.jhengweipan.ga.MyGAManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import myAppKey.mykey;

public class SevenPeopleBook_MenuActivity extends Activity {
    private InterstitialAd interstitial;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seven_people_book__menu);
        PushManager.getInstance().initialize(this.getApplicationContext());
        Intent promotionIntent = new Intent(this, SevenPeopleBook_MenuActivity.class);
        PushAd.enablePush(this, mykey.AdLoucsKey, promotionIntent);
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        interstitial = new InterstitialAd(this);
        interstitial.setAdUnitId(mykey.ad);
        interstitial.loadAd(adRequest);
        // Create ad request.

//        PushAd.test(this);

        // Begin loading your interstitial.

        MyGAManager.sendScreenName(SevenPeopleBook_MenuActivity.this, getResources().getString(R.string.ga_homePage));
        test();


        initLayout();
        configVersionCheck();
    }


    private void initLayout() {

        mListView = (ListView) findViewById(R.id.SevenPeopleBook_MenuActivity_listview);
        String[] PageName = getResources().getStringArray(R.array.sevenpageame);
        ArrayAdapter<String> pageName = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, PageName);
        mListView.setAdapter(pageName);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        Intent newplayerteach = new Intent();
                        newplayerteach.setClass(SevenPeopleBook_MenuActivity.this, NewsPlayerTeachActivity.class);
                        startActivity(newplayerteach);
                        break;
                    case 1:
                        Intent hitcity = new Intent();
                        hitcity.setClass(SevenPeopleBook_MenuActivity.this, HitCityActivity.class);
                        startActivity(hitcity);

                        break;
                    case 2:
                        Intent Duplicate = new Intent();
                        Duplicate.setClass(SevenPeopleBook_MenuActivity.this,DuplicateActivity.class);
                        startActivity(Duplicate);
                        break;

                }

            }
        });


    }
    private void configVersionCheck() {

//        if (!GtApi.checkNetwork(IndexActivity.this)) return;

        VersionChecker.checkOnce(this, new VersionChecker.DoneAdapter() {

            @Override
            public void onHasNewVersion() {
                new AlertDialog.Builder(SevenPeopleBook_MenuActivity.this)
                        .setTitle("已有最新版本!")
                        .setMessage("目前有最新版本上架,請盡快更新")
                        .setNegativeButton("確定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                MyGAManager.sendActionName(SevenPeopleBook_MenuActivity.this,"updata","installation");
                                startActivity(VersionChecker.openMartketIntent());
                                dialog.dismiss();
                            }
                        })
                        .show();
            }


        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            interstitial.show();
            this.finish();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    private void  test(){


        Map<String, Object> param = new HashMap<String, Object>();
        param.put("action", "pushSpecifyMessage"); // pushSpecifyMessage为接口名，注意大小写
                /*---以下代码用于设定接口相应参数---*/
        param.put("appkey", "WN9VAyi7nn6HuApoxH6wr4");
        param.put("type", 2); // 推送类型： 2为消息
        param.put("com.jhengweipan.SevenPeopleBook", "通知栏测试"); // pushTitle请填写您的应用名称

        // 推送消息类型，有TransmissionMsg、LinkMsg、NotifyMsg三种，此处以LinkMsg举例
        param.put("pushType", "LinkMsg");

        param.put("offline", true); // 是否进入离线消息

        param.put("offlineTime", 72); // 消息离线保留时间
        param.put("priority", 1); // 推送任务优先级

        List<String> cidList = new ArrayList<String>();
//        cidList.add(tView.getText().toString()); // 您获取的ClientI
        param.put("tokenMD5List", cidList);

        // 生成Sign值，用于鉴权，需要MasterSecret，请务必填写
        param.put("sign", GetuiSdkHttpPost.makeSign("1DZ86bYLb063Kfe0sg5iu7", param));

        // LinkMsg消息实体
        Map<String, Object> linkMsg = new HashMap<String, Object>();
        linkMsg.put("linkMsgIcon", "push.png"); // 消息在通知栏的图标
        linkMsg.put("linkMsgTitle", "通知栏测试"); // 推送消息的标题
        linkMsg.put("linkMsgContent", "您收到一条测试消息，点击访问www.igetui.com！"); // 推送消息的内容
        linkMsg.put("linkMsgUrl", "http://www.igetui.com/"); // 点击通知跳转的目标网页
        param.put("msg", linkMsg);

        GetuiSdkHttpPost.httpPost(param);

    }
}