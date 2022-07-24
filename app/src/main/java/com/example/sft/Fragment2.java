package com.example.sft;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class Fragment2 extends Fragment {

  Helper helper;
  RecyclerView recyclerView;
  Adapter adapter;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    ViewGroup rootView =
        (ViewGroup)inflater.inflate(R.layout.fragment_2, container, false);
    helper = new Helper(getContext());

    //rootView에서 xml파일의 요소 찾는것을 잊지 말자.
    recyclerView = rootView.findViewById(R.id.recyclerView);

    LinearLayoutManager layoutManager =
        new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
    //(위 코드) 3번째 파라미터 false는 뷰가 정방향임을 의미. true는 역방향.
    recyclerView.setLayoutManager(layoutManager);

    adapter = new Adapter();

    //데이터베이스의 'table1' 이른 이름의 테이블에 몇 라인(행/raw)가 있는지 검색.
    int combienLigne = helper.lineSize("table1");

    String[] sa; //자료를 받을 String형 배열 먼저 선언.
    //어댑터 객체에 DB의 아이템 넣기
    for(int i=0; i<combienLigne; i++){
      sa = helper.findLine(i, "table1"); //table1 테이블의 i번 raw 조회, 리턴받음.
      adapter.setArrayData(new Book(sa[0], sa[1]));
    }

    //그냥 테스트를 위한 자료입력일 뿐. 별거아님.
    adapter.setArrayData(new Book("title1", "author1"));
    adapter.setArrayData(new Book("title2", "author2"));
    adapter.setArrayData(new Book("title3", "author3"));
    adapter.setArrayData(new Book("title4", "author4"));

    //위에서 만든 어댑터를 리사이클러뷰 객체에 설정(set)
    recyclerView.setAdapter(adapter);

    return rootView;
  }

}// class Fragment2