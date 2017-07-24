package com.clayons.interviewquestions.Model;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private String firstName;
	private String lastName;
	private int age;
	private String phoneNum;
	private String photoUrl;
	private boolean isLiked;
	private int position;
	private List <Post> listOfPosts = new ArrayList <>();

	public Person (String firstName, String lastName, Integer age, String phoneNum, String photoUrl, boolean isLiked) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.age = age;
		this.photoUrl = photoUrl;
		this.isLiked = isLiked;
	}

	public String getFirstName () {
		return firstName;
	}

	public String getLastName () {
		return lastName;
	}

	public int getAge () {
		return age;
	}

	public String getPhoneNum () {
		return phoneNum;
	}

	public String getPhotoUrl () {
		return photoUrl;
	}

	public boolean getIsLiked () {
		return isLiked;
	}

	public int getPosition () {
		return position;
	}

	public List <Post> getListOfPosts () {
		return listOfPosts;
	}

	public void setIsLiked (boolean isLiked) {
		this.isLiked = isLiked;
	}

	public void setPosition (int position) {
		this.position = position;
	}

	public void addPost (Post post) {
		this.listOfPosts.add(post);
	}
}
