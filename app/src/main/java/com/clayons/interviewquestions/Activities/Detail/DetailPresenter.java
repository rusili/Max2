package com.clayons.interviewquestions.Activities.Detail;

import com.clayons.interviewquestions.Activities.Detail.RecyclerView.PostAdapter;
import com.clayons.interviewquestions.Model.Person;
import com.clayons.interviewquestions.Model.StaticPersons;

public class DetailPresenter implements DetailInterface.Presenter {
	private static DetailPresenter detailPresenter;
	private DetailInterface.View view;
	private PostAdapter postAdapter;

	private DetailPresenter () {
		initialize();
	}

	public static DetailPresenter getDetailPresenter () {
		if (detailPresenter == null) {
			detailPresenter = new DetailPresenter();
		}
		return detailPresenter;
	}

	public void bindToView (DetailInterface.View view) {
		this.view = view;
		Person person = StaticPersons.getPersonStatic()
			  .getSavedPerson();
		view.showPerson(person);

		if (person.getListOfPosts() != null) {
			postAdapter = new PostAdapter(person.getListOfPosts());
		}
		view.setRecyclerView(postAdapter);
	}

	private void initialize () {
	}

	public void updateListofPersons () {
		int position = StaticPersons.getPersonStatic()
			  .getSavedPerson()
			  .getPosition();

		boolean isLiked =  StaticPersons.getPersonStatic()
			  .getSavedPerson()
			  .getIsLiked();

		StaticPersons.getPersonStatic()
			  .updatePerson(position, isLiked);
	}

	public void unbind () {
		this.view = null;
	}
}