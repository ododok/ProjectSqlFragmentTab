package com.example.sft;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class Helper extends SQLiteOpenHelper {
  SQLiteDatabase sdb;

  public Helper(@Nullable Context context) {
    super(context, "booksDB", null, 1);
    //이 생성자의 Context를
  }

  @Override //DB와 테이블 생성 기능. (초기화를 담당하는 메서드인듯)
  public void onCreate(SQLiteDatabase db) {
    db.execSQL("DROP TABLE IF EXISTS table1");//만약 이 테이블 존재하면 지움.

    //테이블만들기
    db.execSQL("CREATE TABLE table1 (_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
        +" title TEXT, author TEXT, content TEXT);" );
    Log.d("db", "Helper클래스의 onCreate메서드로 db와 테이블 'table1'이 생성됨");
  }

  @Override //테이블 삭제 및 다시 생성하는 기능
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS table1");
    onCreate(db);
  }

  //특정 테이블에 자료를 입력하는 insert메서드.
  public void insert(String title, String author, String content, String table){
    sdb = getWritableDatabase();////
    String sql = "INSERT INTO "+table+"(title, author, content) VALUES ('"
        +title+"', '"+author+"', '"+content+"');";
    Log.d("db", "MainActivity의 insert 함수에서 DB입력 처리했습니다.");
    sdb.execSQL(sql);
    sdb.close();
  }


  //특정 테이블에 몇 개의 raw(ligne / 행)이 입력되어 있는지 (레코드 갯수) 조회
  public int lineSize(String tableName){
    sdb = getReadableDatabase();
    Cursor cursor = sdb.rawQuery("SELECT * FROM "+tableName+";", null);
    int result = cursor.getCount();
    sdb.close();
    return result;
  }

  //db의 특정 테이블에서 라인(레코드)하나 찾아주는 메서드
  public String[] findLine(int lineIndex, String tableName) {
    String[] arr = new String[2];
    sdb = getReadableDatabase();
    Cursor cursor = sdb.rawQuery("SELECT title, author FROM "+tableName+";", null);
    cursor.moveToPosition(lineIndex);

    //위 SQL문에서 title, author만 SELECT했다. 고로 title은 columnIndex 0이 되고,
    //author 는 columnIndex 1이 된다.
    arr[0] = cursor.getString(0);
    arr[1] = cursor.getString(1);
    sdb.close();
    return arr;
  }

}//class Helper
