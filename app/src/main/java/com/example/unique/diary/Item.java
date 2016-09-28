package com.example.unique.diary;

public class Item {
	private String name;
   private String week;
	private int num;
	//private int imageId;

	public Item(String name,String week,int num) {
		this.name = name;
		this.week = week;
		this.num = num;

	}

	public String getName() {
		return name;
	}

	public String getWeek() {return week;}
	public int getNum() {return num;}
	public void setname(String name)
	{
		this.name=name;
	}

}
