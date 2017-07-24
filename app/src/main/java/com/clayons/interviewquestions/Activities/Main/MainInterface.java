package com.clayons.interviewquestions.Activities.Main;

import com.clayons.interviewquestions.Activities.Main.RecyclerView.PersonAdapter;
import com.clayons.interviewquestions.Model.Person;
import com.clayons.interviewquestions.Model.Post;

import java.util.List;

public interface MainInterface {

	public interface View {
		void setRecyclerView (PersonAdapter personAdapter);
	}

	public interface Presenter {
		void notifyDataChange ();
	}

	interface Model {
		void updateModel (List <Person> personsList);

		List <Person> getPersonList ();

		void addPosts (Post[] postsResponse);
	}
}
