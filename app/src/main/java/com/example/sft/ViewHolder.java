package com.example.sft;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder{
  public TextView textViewTitle, textViewAuthor;
  public CardView card_item;

  public ViewHolder(Context context, @NonNull View itemView) {
    super(itemView);
    card_item = itemView.findViewById(R.id.book_item);
    textViewTitle = itemView.findViewById(R.id.textViewTitle);
    textViewAuthor = itemView.findViewById(R.id.textViewAuthor);

    //유저가 카드뷰 클릭시 이벤트는 여기 작성. 그냥 토스트메시지.
    card_item.setOnClickListener(v->{
      Toast.makeText(context, textViewTitle.getText().toString(),
          Toast.LENGTH_SHORT).show();
    });
  }

}
