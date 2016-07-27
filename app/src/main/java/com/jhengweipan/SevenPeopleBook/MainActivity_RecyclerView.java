package com.jhengweipan.SevenPeopleBook;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.clockbyte.admobadapter.AdmobRecyclerAdapterWrapper;
import com.jhengweipan.Guandisignonehundred.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity_RecyclerView extends Activity {

    RecyclerView rvMessages;
    AdmobRecyclerAdapterWrapper adapterWrapper;
    Timer updateAdsTimer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recycleview);

        initRecyclerViewItems();
        initUpdateAdsTimer();
    }

    /**
     * Inits an adapter with items, wrapping your adapter with a {@link AdmobRecyclerAdapterWrapper} and setting the recyclerview to this wrapper
     * FIRST OF ALL Please notice that the following code will work on a real devices but emulator!
     */
    private void initRecyclerViewItems() {
        rvMessages = (RecyclerView) findViewById(R.id.rvMessages);
        rvMessages.setLayoutManager(new LinearLayoutManager(this));

        //creating your adapter, it could be a custom adapter as well
        RecyclerExampleAdapter adapter  = new RecyclerExampleAdapter(this);

        adapterWrapper = new AdmobRecyclerAdapterWrapper(this);
        adapterWrapper.setAdapter(adapter); //wrapping your adapter with a AdmobAdapterWrapper.
        //here you can use the following string to set your custom layouts for a different types of native ads
//        adapterWrapper.setInstallAdsLayoutId(R.layout.your_installad_layout);
//        adapterWrapper.setcontentAdsLayoutId(R.layout.your_installad_layout);

        //Sets the max count of ad blocks per dataset, by default it equals to 3 (according to the Admob's policies and rules)
        adapterWrapper.setLimitOfAds(3);

        //Sets the number of your data items between ad blocks, by default it equals to 10.
        //You should set it according to the Admob's policies and rules which says not to
        //display more than one ad block at the visible part of the screen,
        // so you should choose this parameter carefully and according to your item's height and screen resolution of a target devices
        adapterWrapper.setNoOfDataBetweenAds(3);

        //It's a test admob ID. Please replace it with a real one only when you will be ready to deploy your product to the Release!
        //Otherwise your Admob account could be banned
        String admobUnitId = getResources().getString(R.string.banner_admob_unit_id);
        adapterWrapper.setAdmobReleaseUnitId(admobUnitId);


        rvMessages.setAdapter(adapterWrapper); // setting an AdmobRecyclerAdapterWrapper to a ListView

//        //preparing the collection of data
//        final String sItem = "item #";
//        ArrayList<String> lst = new ArrayList<String>(100);
//        for(int i=1;i<=100;i++)
//            lst.add(sItem.concat(Integer.toString(i)));

        //adding a collection of data to your adapter and rising the data set changed event
        JSONArray  jsonArray = new JSONArray();

        String [] a = getResources().getStringArray(R.array.newplayteach_tittle);
        String [] b = getResources().getStringArray(R.array.teachurl);
        JSONObject jsonObject = new JSONObject();

        ArrayList<String> lst = new ArrayList<String>();
        lst.add("a");
        lst.add("b");
        lst.add("c");
        lst.add("d");
        lst.add("e");
        lst.add("f");
        lst.add("g");
        lst.add("h");
        lst.add("i");
        lst.add("j");
        lst.add("k");
        adapter.addAll(lst);
        HashMap<String ,Object> hashMap = new HashMap<>();
        jsonArray.put(jsonObject);
        Log.d("Jack",jsonArray.toString());
        adapter.notifyDataSetChanged();
    }

    /*
    * Could be omitted. It's only for updating an ad blocks in each 60 seconds without refreshing the list
     */
    private void initUpdateAdsTimer() {
        updateAdsTimer = new Timer();
        updateAdsTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapterWrapper.requestUpdateAd();
                    }
                });
            }
        }, 60*1000, 60*1000);
    }

    /*
    * Seems to be a good practice to destroy all the resources you have used earlier :)
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(updateAdsTimer!=null)
            updateAdsTimer.cancel();
        adapterWrapper.destroyAds();
    }
}
