package com.example.sft;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;


public class Fragment1 extends Fragment {

  EditText editTextTitle, editTextAuthor, editTextContent;
  Button btnSave;

  Helper helper;



  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    ViewGroup rootView =
        (ViewGroup)inflater.inflate(R.layout.fragment_1, container, false);
    editTextTitle = rootView.findViewById(R.id.editTextTitle);
    editTextAuthor = rootView.findViewById(R.id.editTextAuthor);
    editTextContent = rootView.findViewById(R.id.editTextContent);

    //Helper객체
    helper = new Helper(getContext()); //이렇게 해도 될까? 되면 정리 잘 해놓자.

    btnSave = rootView.findViewById(R.id.btnSave);
    btnSave.setOnClickListener(view->{
      String title, author, content;
      title = editTextTitle.getText().toString();
      author = editTextAuthor.getText().toString();
      content = editTextContent.getText().toString();

      //이제 여기서 예전엔 인터페이스에서 강제하고 메인액티비티에 선언했던
      //메서드를 헬퍼클래스에 있는걸로 써보자.
      helper.insert(title, author, content, "table1");
      Log.d("db", "fragment1에서 helper클래스의 insert호출");

      editTextTitle.setText(null);
      editTextAuthor.setText(null);
      editTextContent.setText(null);
    });


    return rootView;
  }//onCreateView

}//class Fragment1