package com.example.gymapplicants;

import android.os.Parcel;
import android.os.Parcelable;

public class Training implements Parcelable {
    public static final Creator<Training> CREATOR = new Creator<Training>() {
        @Override
        public Training createFromParcel(Parcel in) {
            return new Training(in);
        }

        @Override
        public Training[] newArray(int size) {
            return new Training[size];
        }
    };
    private int id;
    private String name, ShortDesc, LongDesc, ImageUrl;

    public Training(int id, String name, String shortDesc, String longDesc, String imageUrl) {
        this.id = id;
        this.name = name;
        this.ShortDesc = shortDesc;
        this.LongDesc = longDesc;
        this.ImageUrl = imageUrl;
    }

    protected Training(Parcel in) {
        id = in.readInt();
        name = in.readString();
        ShortDesc = in.readString();
        LongDesc = in.readString();
        ImageUrl = in.readString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDesc() {
        return ShortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.ShortDesc = shortDesc;
    }

    public String getLongDesc() {
        return LongDesc;
    }

    public void setLongDesc(String longDesc) {
        this.LongDesc = longDesc;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.ImageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ShortDesc='" + ShortDesc + '\'' +
                ", LongDesc='" + LongDesc + '\'' +
                ", ImageUrl='" + ImageUrl + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(ShortDesc);
        dest.writeString(LongDesc);
        dest.writeString(ImageUrl);
    }
}
