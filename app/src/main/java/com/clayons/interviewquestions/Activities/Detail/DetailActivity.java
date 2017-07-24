package com.clayons.interviewquestions.Activities.Detail;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.clayons.interviewquestions.Activities.Detail.RecyclerView.PostAdapter;
import com.clayons.interviewquestions.Model.Person;
import com.clayons.interviewquestions.Model.StaticPersons;
import com.clayons.interviewquestions.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import it.gmariotti.recyclerview.adapter.AlphaAnimatorAdapter;

public class DetailActivity extends AppCompatActivity implements DetailInterface.View {
	@BindView (R.id.Activity_Detail_IV_Avatar)
	ImageView ivAvatar;
	@BindView(R.id.Activity_Detail_FloatingButton)
	FloatingActionButton fbLike;
	@BindView (R.id.Activity_Detail_TV_Name)
	TextView tvName;
	@BindView (R.id.Activity_Detail_TV_Age)
	TextView tvAge;
	@BindView (R.id.Activity_Detail_TV_Phone)
	TextView tvPhone;
	@BindView (R.id.Activity_Detail_RecyclerView_Posts)
	RecyclerView rvPosts;

	private Person person;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);

		initialize();
	}

	private void initialize () {
		ButterKnife.bind(this);
		setPresenter();
		setOnClickListener();
	}

	private void setOnClickListener () {
		fbLike.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick (View view) {
				StaticPersons.getPersonStatic()
					  .getSavedPerson()
					  .setIsLiked(!StaticPersons
						    .getPersonStatic()
						    .getSavedPerson()
						    .getIsLiked());
				updateListofPersons();
				updateLikedButton();
			}
		});
	}

	private void updateListofPersons () {
		DetailPresenter.getDetailPresenter()
			  .updateListofPersons();
	}

	private void setPresenter () {
		DetailPresenter.getDetailPresenter()
			  .bindToView(this);
	}

	public void showPerson (Person savedPerson) {
		this.person = savedPerson;
		setViews();
	}

	private void setViews () {
		Glide.with(this)
			  .load(person.getPhotoUrl())
			  .placeholder(R.drawable.ic_action_account_circle_40)
			  .into(ivAvatar);
		tvName.setText(person.getFirstName() + " " + person.getLastName());
		tvAge.setText(String.valueOf(person.getAge()));
		tvPhone.setText(person.getPhoneNum());
		updateLikedButton();
	}

	private void updateLikedButton () {
		if (person.getIsLiked()) {
			fbLike.setImageDrawable(getResources().getDrawable(R.drawable.ic_favorite_black_24dp));
		} else {
			fbLike.setImageDrawable(getResources().getDrawable(R.drawable.ic_favorite_border_black_24dp));
		}
	}

	public void setRecyclerView (PostAdapter postAdapter) {
		LinearLayoutManager linearLayoutManagerVertical = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
		rvPosts.setLayoutManager(linearLayoutManagerVertical);
		AlphaAnimatorAdapter alphaAnimatorAdapter = new AlphaAnimatorAdapter(postAdapter, rvPosts);
		rvPosts.setAdapter(alphaAnimatorAdapter);
	}

	@Override
	protected void onDestroy () {
		DetailPresenter.getDetailPresenter().unbind();
		super.onDestroy();
	}

}
