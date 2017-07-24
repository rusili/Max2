package com.clayons.interviewquestions.Network;

import com.clayons.interviewquestions.Model.Post;
import com.clayons.interviewquestions.Utility.Constants;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface PostAPIRX {

	@GET (Constants.Network.ENDPOINT)
	Observable<Post[]> getResponsePost ();

}
