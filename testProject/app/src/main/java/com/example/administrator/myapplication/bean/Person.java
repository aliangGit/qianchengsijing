package com.example.administrator.myapplication.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Kaiser on 2018-07-31.
 */

public class Person implements Parcelable {

    private String name;

    public Person() {

    }

    public Person(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 要将Person对象作为HashMap的key，就必须重写equals方法和hashCode方法
    @Override
    public boolean equals(Object o) {
        if(o==this)
            return true;
        if(o==null)
            return false;
        if(getClass()!=o.getClass())
            return false;

        Person other=(Person)o;
        if(name==null)
        {
            if(other.name!=null)
            {
                return false;
            }
            else
                return true;
        }
        else
        {
            if(other.name==null)
                return false;
            else
            {
                if(name.equals(other.name))
                    return true;
            }
        }
        return false;
    }
    @Override
    public int hashCode() {
        final int prime=31;
        int result=1;
        result=prime*result+((name==null)?0:name.hashCode());
        return result;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }
    public static final Parcelable.Creator<Person> CREATOR = new Creator<Person>() {

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }

        @Override
        public Person createFromParcel(Parcel source) {
            Person p=new Person(source.readString());
            return p;
        }
    };
}
