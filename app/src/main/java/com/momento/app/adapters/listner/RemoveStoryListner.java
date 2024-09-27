package com.momento.app.adapters.listner;


import android.view.View;
@FunctionalInterface
public interface RemoveStoryListner {
    void removeStory(View view, int position);

}
