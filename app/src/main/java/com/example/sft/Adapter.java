package com.example.sft;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<ViewHolder>{
  private ArrayList<Book> items; //Book형 자료들이 들어가는 리스트.

  public Adapter(){
    items = new ArrayList<>();
  }


  @NonNull
  @Override //아이템 뷰를 위한 뷰홀더 객체를 생성하여 리턴하는 메서드.
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    Context context = parent.getContext();
    LayoutInflater inflater =
        (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View view = inflater.inflate(R.layout.book_item, parent, false);
    ViewHolder viewHolder = new ViewHolder(context, view);
    return viewHolder;
  }

  @Override //재활용기능
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    Book book = items.get(position);
    holder.textViewTitle.setText(book.getTitle());
    holder.textViewAuthor.setText(book.getAuthor());
    //content는 커스텀 뷰에 없기 때문에 여기서는 쓰지 않는다.
  }

  @Override
  public int getItemCount() {
    return items.size(); //리스트의 사이즈.
  }

  //book 데이터 한 개만 입력하는 메서드
  public void setArrayData(Book book){
    items.add(book);
  }

}
