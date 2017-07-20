package com.clayons.interviewquestions.Activities.Main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.clayons.interviewquestions.Activities.Main.RecyclerView.PersonAdapter;
import com.clayons.interviewquestions.Model.StaticPersons;
import com.clayons.interviewquestions.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainInterface.View{
    @BindView(R.id.Recyclerview_Persons) RecyclerView rvPersons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        initialize();
    }

    private void initialize () {
        ButterKnife.bind(this);
        setPresenter();
    }

    public void setPresenter(){
        MainPresenter.getMainPresenter().bindToView(this);
    }

    @Override
    public void showListOfPersons () {
        setRecyclerView();
    }

    private void setRecyclerView (){
        LinearLayoutManager linearLayoutManagerVertical = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvPersons.setLayoutManager(linearLayoutManagerVertical);
        rvPersons.setAdapter(new PersonAdapter(StaticPersons.getPersonStatic().getPersons()));
    }

    @Override
    protected void onDestroy () {
        MainPresenter.getMainPresenter().unbind();
        super.onDestroy();
    }
}
