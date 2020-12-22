package com.itb.gestitb.Models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Calendar;
import java.util.Date;

public class StudentMissingModel implements Parcelable {
    private String name,subject;
    private boolean justified;
    Date date = Calendar.getInstance().getTime();

    public StudentMissingModel(String name, String subject, boolean justified) {
        this.name = name;
        this.subject = subject;
        this.justified = justified;
    }

    protected StudentMissingModel(Parcel in) {
        name = in.readString();
        subject = in.readString();
        justified = in.readByte() != 0;
    }

    public static final Creator<StudentMissingModel> CREATOR = new Creator<StudentMissingModel>() {
        @Override
        public StudentMissingModel createFromParcel(Parcel in) {
            return new StudentMissingModel(in);
        }

        @Override
        public StudentMissingModel[] newArray(int size) {
            return new StudentMissingModel[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public boolean isJustified() {
        return justified;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(subject);
        dest.writeByte((byte) (justified ? 1 : 0));
    }
}
