package com.use.zy.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * 具体的主题对象 
 * 这里就不实现线程安全的功能了，
 * 有兴趣的话可以参考java.util报下的Observable
 * @author xujun
 *
 */

public class ConcreteSubject implements Subject {

	List<Observer> mList = new ArrayList<>();

	@Override
	public void addObserver(Observer observer) {
		// 确保相同的观察者只含有一个
		if (observer == null) {
			throw new NullPointerException("observer == null");
		}

		if (!mList.contains(observer)) {
			mList.add(observer);
		}
		

	}

	@Override
	public void removeObserver(Observer observer) {
		mList.remove(observer);

	}

	@Override
	public void removeAll() {
       mList.clear();
	}

	

	@Override
	public void notifyAllObserver(Object data) {
		for (Observer observer : mList) {
			observer.update(this,data);
		}
		
	}

	@Override
	public void notify(Observer observer, Object data) {
		if(observer!=null){
			observer.update(this, data);
		}
		
	}

}
