package com.example.arafat.recyclerviewpluscardview;

import android.os.Parcel;
import android.os.Parcelable;

public class ExampleItem implements Parcelable {
    private String mImageResource;
    private String mText1;
    private String mText2;
    private String name;
    private String who;

    public ExampleItem(String mImageResource, String mText1, String mText2, String name, String who) {
        this.mImageResource = mImageResource;
        this.mText1 = mText1;
        this.mText2 = mText2;
        this.name = name;
        this.who = who;
    }



    protected ExampleItem(Parcel in) {
        mImageResource = in.readString();
        mText1 = in.readString();
        mText2 = in.readString();
        name = in.readString();
        who = in.readString();
    }

    public static final Creator<ExampleItem> CREATOR = new Creator<ExampleItem>() {
        @Override
        public ExampleItem createFromParcel(Parcel in) {
            return new ExampleItem(in);
        }

        @Override
        public ExampleItem[] newArray(int size) {
            return new ExampleItem[size];
        }
    };

   /* public void changeText1(String text) {
        mText1 = text;
    }*/

    public String getmImageResource() {
        return mImageResource;
    }

    public String getmText1() {
        return mText1;
    }

    public String getmText2() {
        return mText2;
    }

    public String getName() {
        return name;
    }

    public String getWho() {
        return who;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mImageResource);
        parcel.writeString(mText1);
        parcel.writeString(mText2);
        parcel.writeString(name);
        parcel.writeString(who);

    }
}
