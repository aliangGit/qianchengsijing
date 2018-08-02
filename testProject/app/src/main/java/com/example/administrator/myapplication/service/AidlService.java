package com.example.administrator.myapplication.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.example.administrator.myapplication.ICar;
import com.example.administrator.myapplication.bean.Car;
import com.example.administrator.myapplication.bean.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class AidlService extends Service {
    private static final String TAG="AidlService";
    private CarBinder carBinder;
    private static Map<Person,List<Car>> cars=new HashMap<Person,List<Car>>();
    public AidlService() {
    }
    // 初始化块，初始化一些数据
    static
    {
        List<Car> list1=new ArrayList<Car>();
        list1.add(new Car(80000, "现代"));
        list1.add(new Car(130000, "起亚"));
        cars.put(new Person("小张"),list1);

        List<Car> list2=new ArrayList<Car>();
        list2.add(new Car(200000, "奥迪"));
        list2.add(new Car(400000, "宝马"));
        cars.put(new Person("李总"),list2);
    }
    @Override
    public void onCreate() {
        Log.i(TAG,"AidlService vonCreate");
        super.onCreate();
        System.out.println("Service created...");
        // 此处创建一个CarBinder 的实例
        carBinder=new CarBinder();
    }
    // 客户端绑定到本Service的时候会调用此方法
    // 通过此方法将Binder的实例返回给客户端
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,"onBind");
        return carBinder;
    }
    @Override
    public void onDestroy() {
        Log.i(TAG,"onDestroy");
        super.onDestroy();
    }
    // 此处定义一个com.example.aidlservice.ICar.Stub类的子类
    // 该类的实例会返回给客户端，供客户端调用
    public class CarBinder extends ICar.Stub
    {
        // 回调方法，返回一个Person的车辆
        @Override
        public List<Car> getCars(Person owner) throws RemoteException {
            return cars.get(owner);
        }
    }
}
