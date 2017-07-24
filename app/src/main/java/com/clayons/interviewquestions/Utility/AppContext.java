package com.clayons.interviewquestions.Utility;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;

public class AppContext extends Application {
	private static Context context;

	@Override
	public void onCreate () {
		super.onCreate();
		LeakCanary.install(this);
		this.context = getApplicationContext();
	}

	public static Context getContext () {
		return context;
	}
}
