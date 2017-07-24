package com.clayons.interviewquestions.Activities.Detail.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.clayons.interviewquestions.Model.Post;
import com.clayons.interviewquestions.R;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter {
	List <Post> listOfPosts = new ArrayList <>();

	public PostAdapter (List <Post> listOfPosts) {
		this.listOfPosts = listOfPosts;
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
		LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
		View viewViewholderPost = layoutInflater.inflate(R.layout.viewholder_post, parent, false);
		PostViewholder postViewholder = new PostViewholder(viewViewholderPost);

		return postViewholder;
	}

	@Override
	public void onBindViewHolder (RecyclerView.ViewHolder holder, int position) {
		PostViewholder postViewholder = (PostViewholder) holder;
		postViewholder.bind(listOfPosts.get(position));
	}

	@Override
	public int getItemCount () {
		return listOfPosts.size();
	}
}
