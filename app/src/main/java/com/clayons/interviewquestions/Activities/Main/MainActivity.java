package com.clayons.interviewquestions.Activities.Main;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.clayons.interviewquestions.Activities.Main.RecyclerView.PersonAdapter;
import com.clayons.interviewquestions.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import it.gmariotti.recyclerview.adapter.AlphaAnimatorAdapter;

public class MainActivity extends AppCompatActivity implements MainInterface.View {
	@BindView (R.id.Activity_Main_Recyclerview_Persons)
	RecyclerView rvPersons;

	@Override
	protected void onResume () {
		super.onResume();
		MainPresenter.getMainPresenter()
			  .notifyDataChange();
	}

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initialize();
	}

	private void initialize () {
		setViews();
		setPresenter();
		isConnectedToInternet();
	}

	private void setViews () {
		ButterKnife.bind(this);

		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setIcon(R.mipmap.ic_launcher);
	}

	public void setPresenter () {
		MainPresenter.getMainPresenter()
			  .bindToView(this);
	}

	public void setRecyclerView (PersonAdapter personAdapter) {
		LinearLayoutManager linearLayoutManagerVertical = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
		rvPersons.setLayoutManager(linearLayoutManagerVertical);

		AlphaAnimatorAdapter alphaAnimatorAdapter = new AlphaAnimatorAdapter(personAdapter, rvPersons);
		rvPersons.setAdapter(alphaAnimatorAdapter);
	}

	private void isConnectedToInternet () {
		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

		if (activeNetwork == null && activeNetwork.isConnectedOrConnecting()) {
			Toast.makeText(this, "Connection Unavailable", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	protected void onDestroy () {
		MainPresenter.getMainPresenter().unbind();
		super.onDestroy();
	}
}
