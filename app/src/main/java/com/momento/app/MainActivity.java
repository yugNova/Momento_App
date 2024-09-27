package com.momento.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.momento.app.adapters.PostAdapter;
import com.momento.app.adapters.StoryAdapter;
import com.momento.app.data.Post;
import com.momento.app.data.story;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView storyRecyclerView;
    private List<story> storyList;
    private RecyclerView postRecyclerView;
    private List<Post> postList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        intialize();
       StoryAdapter storyAdapter= new StoryAdapter(storyList,this);
       storyRecyclerView.setAdapter(storyAdapter);
       storyRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        storyAdapter.setOnRemoveStoryListner((view, position) -> {
           // Toast.makeText(this,"Remove story "+position,Toast.LENGTH_SHORT).show();
            storyList.remove(position);

            storyAdapter.notifyDataSetChanged();

        });

        PostAdapter postAdapter=new PostAdapter(postList,this);
        postRecyclerView.setAdapter(postAdapter);
        postRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @SuppressLint("WrongViewCast")
    private void intialize() {

        this.storyRecyclerView=findViewById(R.id.story_container);
        this.postRecyclerView=findViewById(R.id.single_post);
        this.storyList=new ArrayList<>();
        this.postList=new ArrayList<>();
        //creating few default story


        this.storyList.add(new story(7,"Diana",R.drawable.story_1));
        this.storyList.add(new story(14,"Nehu",R.drawable.story_2));
        this.storyList.add(new story(5,"Aparana",R.drawable.story_3));
        this.storyList.add(new story(12,"Nil",R.drawable.story_4));
        this.storyList.add(new story(7,"Diana",R.drawable.story_1));
        this.storyList.add(new story(14,"Nehu",R.drawable.story_2));
        this.storyList.add(new story(5,"Aparana",R.drawable.story_3));
        this.storyList.add(new story(12,"Nil",R.drawable.story_4));
     //adding item to post list;
        this.postList.add(new Post(1,R.drawable.profile,R.drawable.story_1,
                "This is post caption","Sponsored ",
                "40 liked","View all 5 comments","Liara"));
        this.postList.add(new Post(2,R.drawable.profile,R.drawable.story_2,
                "It's new.....","Newly Sponsored ",
                "20 liked","View all 15 comments","Lucy"));

    }
}