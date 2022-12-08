package com.example.bookshareapp.adapters;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookshareapp.R;
import com.example.bookshareapp.models.BookDataClass;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
  private List<BookDataClass> getAllBookPostData;

    public PostAdapter(List<BookDataClass> getAllBookPostData) {
        this.getAllBookPostData = getAllBookPostData;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_row,parent,false);
        return new PostViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {

        final BookDataClass bookDataClass = getAllBookPostData.get(position);
        holder.userNameTV.setText(bookDataClass.getTitle());
        holder.descriptionTV.setText(bookDataClass.getDescription());
        holder.locationTV.setText(bookDataClass.getLocation());

    }

    @Override
    public int getItemCount() {
        return getAllBookPostData.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {
        TextView userNameTV,descriptionTV,locationTV;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            userNameTV = itemView.findViewById(R.id.userid);
            descriptionTV = itemView.findViewById(R.id.descriptionTV);
            locationTV = itemView.findViewById(R.id.locationTV);



        }
    }

}
