package com.clayons.interviewquestions.Activities.Main;

import com.clayons.interviewquestions.Model.Person;

import java.util.List;

public interface MainInterface {

	public interface View{
		void showListOfPersons ();
	}

	public interface Presenter{
	}

	interface Model{
		void updateModel(List <Person> personsList);
		List<Person> getPersons();
	}
}
