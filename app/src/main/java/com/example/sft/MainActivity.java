package com.example.sft;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

  Toolbar toolbar;
  Fragment1 fragment1;
  Fragment2 fragment2;
  Fragment3 fragment3;

  Helper helper;
  SQLiteDatabase db;

  @Override
  protected void onCreate(Bundle savedInstanceState) {//
    super.onCreate(savedInstanceState);//
    setContentView(R.layout.activity_main);//

    toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    ActionBar actionBar = getSupportActionBar();
    actionBar.setDisplayShowTitleEnabled(false);
    fragment1 = new Fragment1();
    fragment2 = new Fragment2();
    fragment3 = new Fragment3();
    getSupportFragmentManager().beginTransaction()
        .replace(R.id.container, fragment1).commit();

    TabLayout tabs = findViewById(R.id.tabs);
    tabs.addTab(tabs.newTab().setText("입력"));//탭제목
    tabs.addTab(tabs.newTab().setText("조회"));
    tabs.addTab(tabs.newTab().setText("도움말"));
    tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

      @Override  //탭 선택시 코드
      public void onTabSelected(TabLayout.Tab tab) {
        int position = tab.getPosition();
        Fragment selected = null;
        if(position == 0){
          selected = fragment1;
        }else if(position==1){
          selected = fragment2;
        }else if(position == 2){
          selected = fragment3;
        }
        getSupportFragmentManager().beginTransaction()
            .replace(R.id.container, selected).commit();
      }

      @Override
      public void onTabUnselected(TabLayout.Tab tab) { }

      @Override
      public void onTabReselected(TabLayout.Tab tab) { }
    });


    helper= new Helper(this);
    db = helper.getReadableDatabase();

  }//onCreate

}//class MainActivity