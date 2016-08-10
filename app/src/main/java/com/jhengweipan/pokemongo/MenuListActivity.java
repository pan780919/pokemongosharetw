package com.jhengweipan.pokemongo;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
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
        marraylist.add("關於這個APP");
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
                    case 2:
                        showDilog();
                        break;

                }

            }
        });
    }
    private void showDilog(){
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.poke)
                .setTitle("關於")
                .setMessage("這個是類似共享的平台,玩家可以分享文章至blog,也可以用推播訊息 告知附近有什麼特別的pokemon\n\n" +
                        "如有意願或興趣 可以加入我們\n\n" +
                        "blog 開放申請 可以寫信告知會第一時間把您加入作者行列\n\n" +
                        "推播訊息平台每個人都可以使用\n" +
                        "帳號:pokemontw\n" +
                        "密碼:pokemon123\n" +
                        "請勿亂改密碼 以便大家使用 感謝!!"

                )
                .setNegativeButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();

    }
}
