package com.clayons.interviewquestions.Network;

import android.util.Log;

import com.clayons.interviewquestions.Model.Post;
import com.clayons.interviewquestions.Utility.Constants;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RXRetrofit {
	public RXRetrofit(){
		Retrofit retrofit = new Retrofit.Builder()
			  .baseUrl(Constants.Network.BASE_URL)
			  .addConverterFactory(GsonConverterFactory.create())
			  .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
			  .build();

		PostAPIRX postAPIRX = retrofit.create(PostAPIRX.class);
		Observable<Post[]> postAPIRXObservable = postAPIRX.getResponsePost();

		postAPIRXObservable.subscribeOn(Schedulers.newThread())
			  .observeOn(AndroidSchedulers.mainThread())
			  .subscribe(posts -> {Log.e("Current Weather", posts[1].getBody());
			  });
	}
}
