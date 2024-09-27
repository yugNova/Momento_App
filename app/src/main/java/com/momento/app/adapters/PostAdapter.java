package com.momento.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.momento.app.R;
import com.momento.app.data.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
  private List<Post> postList;
  private Context context;

    public PostAdapter(List<Post> postList, Context context) {
        this.postList = postList;
        this.context = context;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view= LayoutInflater.from(context).inflate(R.layout.single_post_view,parent,false);
     PostViewHolder postViewHolder=new PostViewHolder(view);
     return postViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
Post post=postList.get(position);
holder.userImage.setImageResource(post.getUserImage());
holder.postUserName.setText(post.getPostUserName());
holder.subTitle.setText(post.getSubTitle());
holder.mainImage.setImageResource(post.getMainImage());
holder.likedText.setText(post.getLikedText());
holder.commentText.setText(post.getCommentText());

holder.caption.setText(post.getCaption());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder{
        private ImageView userImage, mainImage;
        private TextView postUserName,subTitle,likedText,commentText,caption;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            userImage=itemView.findViewById(R.id.postImage);
            mainImage=itemView.findViewById(R.id.mainPostImage);
            postUserName=itemView.findViewById(R.id.postUserName);
            subTitle=itemView.findViewById(R.id.postSubTitle);
            likedText=itemView.findViewById(R.id.likeTestView);
            commentText=itemView.findViewById(R.id.commentText);
            caption=itemView.findViewById(R.id.postCaption);
        }
    }

}
