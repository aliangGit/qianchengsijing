package com.example.administrator.myapplication.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Kaiser on 2018-07-31.
 */

public class Car implements Parcelable {

    private Integer price;
    private String brand;

    public Car() {
        super();
    }

    public Car(Integer price, String brand) {
        super();
        this.price = price;
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }


    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // TODO Auto-generated method stub
        dest.writeInt(price);
        dest.writeString(brand);
    }

    public static final Parcelable.Creator<Car> CREATOR = new Creator<Car>() {

        @Override
        public Car[] newArray(int size) {
            // TODO Auto-generated method stub
            return new Car[size];
        }

        @Override
        public Car createFromParcel(Parcel source) {
            // TODO Auto-generated method stub
            return new Car(source.readInt(), source.readString());
        }
    };
}