package com.jhengweipan.pokemongo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jhengweipan.Guandisignonehundred.R;

import java.util.ArrayList;

public class MenuListActivity extends Activity {
    private ListView mListview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);
        initLayout();
    }

    private void initLayout() {
        mListview = (ListView) findViewById(R.id.menulist_Listview);
        ArrayList<String> marraylist = new ArrayList<>();
        marraylist.add("玩家分享區");
        marraylist.add("玩家推送訊息平台");
        ArrayAdapter<String> pageName = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, marraylist);
        mListview.setAdapter(pageName);
        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        //new一個intent物件，並指定Activity切換的class
                        Intent intent = new Intent();
                        intent.setClass(MenuListActivity.this, MainActivity.class);
                        //new一個Bundle物件，並將要傳遞的資料傳入
                        Bundle bundle = new Bundle();
                        bundle.putString("url","0");
                        //將Bundle物件assign給intent
                        intent.putExtras(bundle);
                        //切換Activity
                        startActivity(intent);
                        break;
                    case 1:
                        //new一個intent物件，並指定Activity切換的class
                        Intent intent2 = new Intent();
                        intent2.setClass(MenuListActivity.this, MainActivity.class);
                        //new一個Bundle物件，並將要傳遞的資料傳入
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("url","1");
                        //將Bundle物件assign給intent
                        intent2.putExtras(bundle2);
                        //切換Activity
                        startActivity(intent2);

                        break;

                }

            }
        });
    }
}
