package com.clayons.interviewquestions.Activities.Main.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.clayons.interviewquestions.Model.Person;
import com.clayons.interviewquestions.R;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter{
	List<Person> listOfPersons = new ArrayList<>();

	public PersonAdapter (List <Person> listOfPersons) {
		this.listOfPersons = listOfPersons;
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
		LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
		View view = layoutInflater.inflate(R.layout.item_person_summary, parent, false);
		PersonViewholder personViewholder = new PersonViewholder(view);

		return personViewholder;
	}

	@Override
	public void onBindViewHolder (RecyclerView.ViewHolder holder, int position) {
		PersonViewholder personViewholder = (PersonViewholder) holder;
		personViewholder.bind(listOfPersons.get(position));
	}

	@Override
	public int getItemCount () {
		return listOfPersons.size();
	}
}
