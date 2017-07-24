package com.clayons.interviewquestions.Activities.Detail.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.clayons.interviewquestions.Model.Post;
import com.clayons.interviewquestions.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostViewholder extends RecyclerView.ViewHolder {
	@BindView (R.id.Viewholder_Post_TV_Title)
	TextView tvTitle;
	@BindView (R.id.Viewholder_Post_TV_Body)
	TextView tvBody;

	private View view;

	public PostViewholder (View itemView) {
		super(itemView);
		ButterKnife.bind(this, itemView);
		setViews();
	}

	private void setViews () {
		this.view = itemView;
	}

	public void bind (Post post) {
		tvTitle.setText(post.getTitle());
		tvBody.setText(post.getBody());
	}
}
