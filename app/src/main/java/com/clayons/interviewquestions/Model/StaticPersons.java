package com.clayons.interviewquestions.Model;

import com.clayons.interviewquestions.Activities.Main.MainInterface;

import java.util.ArrayList;
import java.util.List;

public class StaticPersons implements MainInterface.Model {
	private static StaticPersons staticPersons;
	private List <Person> listOfPersons = new ArrayList <>();
	private Person savedPerson;

	private StaticPersons () {
	}

	public static StaticPersons getPersonStatic () {
		if (staticPersons == null) {
			staticPersons = new StaticPersons();
		}
		return staticPersons;
	}

	@Override
	public void updateModel (List <Person> personsList) {
		this.listOfPersons = personsList;
	}

	public Person getPerson(int position){
		return listOfPersons.get(position);
	}

	public void updatePerson (int position, boolean isLiked) {
		listOfPersons.get(position).setIsLiked(isLiked);
	}

	@Override
	public List <Person> getPersonList () {
		return listOfPersons;
	}

	@Override
	public void addPosts (Post[] postsResponse) {
		for (int i = 0; i < postsResponse.length; i++) {
			if (listOfPersons.size() > postsResponse[i].getUserId()) {
				listOfPersons.get(((int) (long) (postsResponse[i].getUserId())) - 1).addPost(postsResponse[i]);
			}
		}
	}

	public void savePerson (Person person) {
		this.savedPerson = person;
	}

	public Person getSavedPerson () {
		return savedPerson;
	}
}
