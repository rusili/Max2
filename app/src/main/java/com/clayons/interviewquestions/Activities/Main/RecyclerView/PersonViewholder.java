package com.clayons.interviewquestions.Activities.Main.RecyclerView;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.clayons.interviewquestions.Activities.Detail.DetailActivity;
import com.clayons.interviewquestions.Activities.Main.MainPresenter;
import com.clayons.interviewquestions.Model.Person;
import com.clayons.interviewquestions.Model.StaticPersons;
import com.clayons.interviewquestions.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PersonViewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
	@BindView (R.id.Viewholder_Person_TV_Name)
	TextView tvName;
	@BindView (R.id.Viewholder_Person_IV_AvatarPerson)
	ImageView ivAvatar;
	@BindView (R.id.Viewholder_Person_IV_IsLiked)
	ImageView ivIsLiked;

	private View view;
	private Person savedPerson;
	private int position;

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
		ivIsLiked.setOnClickListener(this);
	}

	public void bind (Person person, int position) {
		this.position = position;
		this.savedPerson = person;
		this.savedPerson.setPosition(position);

		tvName.setText((person.getFirstName() + " " + person.getLastName()).toString());

		Glide.with(view.getContext())
			  .load(person.getPhotoUrl())
			  .placeholder(R.drawable.ic_action_account_circle_40)
			  .into(ivAvatar);

		displayIsLiked(person);
	}

	private void displayIsLiked (Person person) {
		if (person.getIsLiked()) {
			ivIsLiked.setImageDrawable(view.getContext().getResources().getDrawable(R.drawable.ic_favorite_black_24dp));
		} else {
			ivIsLiked.setImageDrawable(view.getContext().getResources().getDrawable(R.drawable.ic_favorite_border_black_24dp));
		}
	}

	@Override
	public void onClick (View view) {
		if (view.getId() == R.id.Viewholder_Person_TV_Name) {
			StaticPersons.getPersonStatic()
				  .savePerson(savedPerson);

			Intent toDetailActivity = new Intent(view.getContext(), DetailActivity.class);
			view.getContext().startActivity(toDetailActivity);

		} else if (view.getId() == R.id.Viewholder_Person_IV_IsLiked){
			boolean newIsLiked = !StaticPersons.getPersonStatic()
				  .getPerson(position)
				  .getIsLiked();

			StaticPersons.getPersonStatic()
				  .updatePerson(position, newIsLiked);

			MainPresenter.getMainPresenter()
				  .notifyDataChange();
		}
	}
}
