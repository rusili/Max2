package com.clayons.interviewquestions.Model;

import com.clayons.interviewquestions.Activities.Main.MainInterface;

import java.util.ArrayList;
import java.util.List;

public class StaticPersons implements MainInterface.Model {
	private static StaticPersons staticPersons;
	private List<Person> listOfPersons = new ArrayList<>();
	private Person savedPerson;

	private StaticPersons (){}

	public static StaticPersons getPersonStatic(){
		if (staticPersons == null){
			staticPersons = new StaticPersons();
		}
		return staticPersons;
	}

	@Override
	public void updateModel (List <Person> personsList) {
		this.listOfPersons = personsList;
	}

	@Override
	public List <Person> getPersons () {
		return listOfPersons;
	}

	public void savePerson(Person person){
		this.savedPerson = person;
	}

	public Person getSavedPerson(){
		return savedPerson;
	}
}
