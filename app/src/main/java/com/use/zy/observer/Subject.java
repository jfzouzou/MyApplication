package com.use.zy.observer;



public interface Subject {
	
	/**
	 * 添加观察者
	 * @param observer
	 */
	void addObserver(Observer observer);
	/**
	 * 移除指定的观察者
	 * @param observer
	 */
	void removeObserver(Observer observer);
	/**
	 * 移除所有的观察者
	 */
	void removeAll();
	
	/**
	 * data 是要通知给观察者的数据
	 * 因为Object是所有类的父类，可以使用多态，当然 你也可以使用 泛型
	 * @param data
	 */
	void notifyAllObserver(Object data);
	
    /**
     * 单独 通知某一个观察者
     * @param observer
     * @param data
     *  data 是要通知给观察者的数据
	 * 因为Object是所有类的父类，可以使用多态，当然 你也可以使用 泛型
     */
	void notify(Observer observer, Object data);

}
