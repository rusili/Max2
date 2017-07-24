package com.clayons.interviewquestions.Activities.Main;

import com.clayons.interviewquestions.Activities.Main.RecyclerView.PersonAdapter;
import com.clayons.interviewquestions.Model.Person;
import com.clayons.interviewquestions.Model.StaticPersons;
import com.clayons.interviewquestions.Network.PostRetrofit;
import com.clayons.interviewquestions.Network.RXRetrofit;
import com.clayons.interviewquestions.Utility.AppContext;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter implements MainInterface.Presenter {
	private static MainPresenter mainPresenter;
	private MainInterface.View view;

	private PersonAdapter personAdapter;

	private MainPresenter () {
		initialize();
	}

	public static MainPresenter getMainPresenter () {
		if (mainPresenter == null) {
			mainPresenter = new MainPresenter();
		}
		return mainPresenter;
	}

	public void bindToView (MainInterface.View view) {
		this.view = view;

		personAdapter = new PersonAdapter(StaticPersons
			  .getPersonStatic()
			  .getPersonList());
		view.setRecyclerView(personAdapter);
	}

	private void initialize () {
		createAppContext();
		initPersons();
		retrievePosts();
		testRX();
	}

	private void testRX () {
		RXRetrofit rxRetrofit = new RXRetrofit();
	}

	public void unbind () {
		this.view = null;
	}

	private void initPersons () {
		List <Person> listOfPersons = new ArrayList <>();

		listOfPersons.add(new Person("Shubhanshu", "Yadav", 5, "111-222-3337", "http://www.max2.com/img/SHUBHANSHU.png", false));
		listOfPersons.add(new Person("Atesh", "Yurdakul", 5, "111-222-3337", "http://www.max2.com/img/ATESH.png", false));
		listOfPersons.add(new Person("Daniel", "Yurdakul", 5, "111-222-3337", "http://www.max2.com/img/DANIEL.png", false));
		listOfPersons.add(new Person("Pranav", "Bhalla", 5, "111-222-3337", "http://www.max2.com/img/PRANAV.png", false));
		listOfPersons.add(new Person("Rohan", "Nagrani", 20, "111-222-3333", "http://www.max2.com/img/ROHAN.png", false));
		listOfPersons.add(new Person("Michael", "Salmasi", 30, "111-222-3334", "http://www.max2.com/img/MICHAEL.png", false));
		listOfPersons.add(new Person("Josh", "Williams", 24, "111-222-3335", "http://www.max2.com/img/josh.png", false));
		listOfPersons.add(new Person("Jing", "Guo", 15, "111-222-3336", "http://www.max2.com/img/jing.png", false));
		listOfPersons.add(new Person("Zhenyu", "Wen", 5, "111-222-3337", "http://www.max2.com/img/zhenyu.png", false));

		StaticPersons.getPersonStatic()
			  .updateModel(listOfPersons);
	}

	private void createAppContext () {
		AppContext appContext = new AppContext();
	}

	public void retrievePosts () {
		PostRetrofit.getPostRetrofit().getPosts();
	}

	@Override
	public void notifyDataChange () {
		personAdapter.notifyDataSetChanged();
	}
}