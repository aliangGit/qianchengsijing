// ICar.aidl
package com.example.administrator.myapplication;

// Declare any non-default types here with import statements
import com.example.administrator.myapplication.bean.Car;
import com.example.administrator.myapplication.bean.Person;
interface ICar
{
    List<Car> getCars(in Person owner);
}