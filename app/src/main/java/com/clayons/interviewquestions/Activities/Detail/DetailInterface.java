package com.clayons.interviewquestions.Activities.Detail;

import com.clayons.interviewquestions.Activities.Detail.RecyclerView.PostAdapter;
import com.clayons.interviewquestions.Model.Person;

public interface DetailInterface {

	public interface View {
		void showPerson (Person savedPerson);

		void setRecyclerView (PostAdapter postAdapter);
	}

	public interface Presenter {
	}

}
