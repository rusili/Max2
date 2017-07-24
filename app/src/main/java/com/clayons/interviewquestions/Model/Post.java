package com.clayons.interviewquestions.Model;

import com.google.gson.annotations.SerializedName;

public class Post {
	@SerializedName ("userId")
	Long userId;
	@SerializedName ("id")
	Long id;
	@SerializedName ("title")
	String title;
	@SerializedName ("body")
	String body;

	public Long getId () {
		return id;
	}

	public Long getUserId () {
		return userId;
	}

	public String getTitle () {
		return title;
	}

	public String getBody () {
		return body;
	}
}
