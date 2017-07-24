package com.clayons.interviewquestions.Network;

import android.util.Log;

import com.clayons.interviewquestions.Model.Post;
import com.clayons.interviewquestions.Model.StaticPersons;
import com.clayons.interviewquestions.Utility.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostRetrofit {
	private static PostRetrofit postRetrofit;
	private Retrofit retrofit;

	private PostRetrofit () {
	}

	public static PostRetrofit getPostRetrofit () {
		if (postRetrofit == null) {
			postRetrofit = new PostRetrofit();
		}
		return postRetrofit;
	}

	private PostAPI connect () {
		if (retrofit == null) {
			retrofit = new Retrofit.Builder()
				  .baseUrl(Constants.Network.BASE_URL)
				  .addConverterFactory(GsonConverterFactory.create())
				  .build();
		}
		PostAPI postAPICall = retrofit.create(PostAPI.class);
		return postAPICall;
	}

	public void getPosts () {
		PostAPI postAPI = connect();
		Call <Post[]> getResponse = postAPI.getResponsePost();
		getResponse.enqueue(new Callback <Post[]>() {
			@Override
			public void onResponse (Call <Post[]> call, Response <Post[]> response) {
				StaticPersons.getPersonStatic()
					  .addPosts(response.body());
			}

			@Override
			public void onFailure (Call <Post[]> call, Throwable t) {
				Log.d("onFailure: ", t.getMessage());
			}
		});
	}

}
