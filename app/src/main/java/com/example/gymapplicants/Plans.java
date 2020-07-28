package com.example.gymapplicants;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Embedded;
import androidx.room.Entity;

@Entity(tableName = "plans")
public class Plans implements Parcelable {
    public static final Creator<Plans> CREATOR = new Creator<Plans>() {
        @Override
        public Plans createFromParcel(Parcel in) {
            return new Plans(in);
        }

        @Override
        public Plans[] newArray(int size) {
            return new Plans[size];
        }
    };
    @Embedded
    private Training training;
    private int minutes;
    private String day;
    private boolean isacomplished;

    public Plans(Training training, int minutes, String day, boolean isacomplished) {
        this.training = training;
        this.minutes = minutes;
        this.day = day;
        this.isacomplished = isacomplished;
    }

    protected Plans(Parcel in) {
        training = in.readParcelable(Training.class.getClassLoader());
        minutes = in.readInt();
        day = in.readString();
        isacomplished = in.readByte() != 0;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public boolean isIsacomplished() {
        return isacomplished;
    }

    public void setIsacomplished(boolean isacomplished) {
        this.isacomplished = isacomplished;
    }

    @Override
    public String toString() {
        return "plans{" +
                "training=" + training +
                ", minutes=" + minutes +
                ", day='" + day + '\'' +
                ", isacomplished=" + isacomplished +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(training, flags);
        dest.writeInt(minutes);
        dest.writeString(day);
        dest.writeByte((byte) (isacomplished ? 1 : 0));
    }
}
