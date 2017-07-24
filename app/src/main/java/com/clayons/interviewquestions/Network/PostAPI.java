package com.clayons.interviewquestions.Network;

import com.clayons.interviewquestions.Model.Post;
import com.clayons.interviewquestions.Utility.Constants;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostAPI {

	@GET (Constants.Network.ENDPOINT)
	Call <Post[]> getResponsePost ();

}
