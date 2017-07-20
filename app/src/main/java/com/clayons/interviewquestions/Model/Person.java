package com.clayons.interviewquestions.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable{
    private String firstName;
    private String lastName;
    private int age;
    private String phoneNum;
    private String photoUrl;
    private boolean isLiked;

	public Person(Parcel in){
		readFromParcel(in);
	}

	public Person(String firstName, String lastName, Integer age, String phoneNum, String photoUrl, boolean isLiked) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.age = age;
        this.photoUrl = photoUrl;
        this.isLiked = isLiked;
    }

    public String getFirstName () {
        return firstName;
    }

    public String getLastName () {
        return lastName;
    }

	public String getPhotoUrl () {
		return photoUrl;
	}

	public boolean getIsLiked(){
        return isLiked;
    }

	@Override
	public int describeContents () {
		return 0;
	}

	@Override
	public void writeToParcel (Parcel parcel, int i) {
		parcel.writeString(firstName);
		parcel.writeString(lastName);
		parcel.writeInt(age);
		parcel.writeString(phoneNum);
		parcel.writeString(photoUrl);
		parcel.writeByte((byte) (isLiked ? 1 : 0));
	}

	private void readFromParcel (Parcel in) {
		firstName = in.readString();
		lastName = in.readString();
		age = in.readInt();
		phoneNum = in.readString();
		photoUrl = in.readString();
		isLiked = in.readByte() != 0;
	}

	public static final Parcelable.Creator CREATOR =
		  new Parcelable.Creator() {
			  public Person createFromParcel(Parcel in) {
				  return new Person(in);
			  }

			  public Person[] newArray(int size) {
				  return new Person[size];
			  }
		  };
}
