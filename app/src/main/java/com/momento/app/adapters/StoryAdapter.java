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
import com.momento.app.adapters.listner.RemoveStoryListner;
import com.momento.app.data.story;

import java.util.List;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryViewHolder> {

  private List<story> storyList;
  private Context context;
  private RemoveStoryListner removeStoryListner;

    public StoryAdapter(List<story> storyList, Context context) {
        this.storyList = storyList;
        this.context = context;
    }
    public void setOnRemoveStoryListner(RemoveStoryListner listner){
        this.removeStoryListner=listner;

    }

    @NonNull
    @Override
    public StoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.story_single_view,parent,false);
        StoryViewHolder storyViewHolder=new StoryViewHolder(view);
        return storyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StoryViewHolder holder, int position) {
        story storyAdapter=storyList.get(position);

     holder.storyImage.setImageResource(storyAdapter.getStoryImage());
     holder.storyUsername.setText(storyAdapter.getUserName());
     holder.storyImage.setOnClickListener(view->{
         this.removeStoryListner.removeStory(view,position);
     });
    }

    @Override
    public int getItemCount() {
        return storyList.size();
    }

    class StoryViewHolder extends RecyclerView.ViewHolder{

        private ImageView storyImage;
        private TextView storyUsername;
        public StoryViewHolder(@NonNull View itemView) {

            super(itemView);
            storyImage=itemView.findViewById(R.id.storyImage);
            storyUsername=itemView.findViewById(R.id.storyUsername);
        }
    }
}
