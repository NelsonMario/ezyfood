package com.example.ezyfood.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Stuff implements Parcelable {

    private String type;
    private String name;
    private Integer price;
    private String description;

    public Stuff(String name, String type, String desc, Integer price) {
        this.type = type;
        this.description = desc;
        this.name = name;
        this.price = price;
    }

    protected Stuff(Parcel in) {
        type = in.readString();
        name = in.readString();
        if (in.readByte() == 0) {
            price = null;
        } else {
            price = in.readInt();
        }
        description = in.readString();
    }

    public static final Creator<Stuff> CREATOR = new Creator<Stuff>() {
        @Override
        public Stuff createFromParcel(Parcel in) {
            return new Stuff(in);
        }

        @Override
        public Stuff[] newArray(int size) {
            return new Stuff[size];
        }
    };

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(type);
        parcel.writeString(name);
        if (price == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(price);
        }
        parcel.writeString(description);
    }
}
