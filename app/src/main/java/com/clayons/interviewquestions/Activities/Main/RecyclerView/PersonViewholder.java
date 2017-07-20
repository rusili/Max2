package com.clayons.interviewquestions.Activities.Main.RecyclerView;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.clayons.interviewquestions.Activities.Detail.DetailActivity;
import com.clayons.interviewquestions.Model.Person;
import com.clayons.interviewquestions.Model.StaticPersons;
import com.clayons.interviewquestions.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PersonViewholder extends RecyclerView.ViewHolder implements View.OnClickListener{
	@BindView(R.id.Viewholder_TV_Name) TextView tvName;
	@BindView(R.id.Viewholder_IV_AvatarPerson) ImageView ivAvatar;
	@BindView(R.id.Viewholder_IV_IsLiked) ImageView ivIsLiked;

	private View view;
	private Person savedPerson;

	public PersonViewholder (View itemView) {
		super(itemView);
		ButterKnife.bind(this, itemView);
		setViews();
		setOnClickListeners();
	}

	private void setViews () {
		this.view = itemView;
	}

	private void setOnClickListeners () {
		tvName.setOnClickListener(this);
	}

	public void bind (Person person){
		this.savedPerson = person;

		tvName.setText((person.getFirstName() + " " + person.getLastName()).toString());
		Picasso.with(view.getContext())
			  .load(person.getPhotoUrl())
			  .placeholder(R.drawable.ic_action_account_circle_40)
			  .into(ivAvatar);

		if (person.getIsLiked()){
			Picasso.with(view.getContext()).
				  load(R.drawable.ic_heart_filled)
				  .into(ivIsLiked);
		} else {
			Picasso.with(view.getContext())
				  .load(R.drawable.ic_heart_outline)
				  .into(ivIsLiked);
		}
	}

	@Override
	public void onClick (View view) {
		StaticPersons.getPersonStatic().savePerson(savedPerson);
		Intent toDetailActivity = new Intent(view.getContext(), DetailActivity.class);
		view.getContext().startActivity(toDetailActivity);
	}
}
