package org.zerock.domain;

import java.sql.Date;
import java.util.*;

public class FoodStore {

//	private String sname, sname2;		// 이름
//	private double lat, lng;	// 위도, 경도
//	private String menu;		// 메뉴
//	private Date read_date;
//	private int  num;
//	
//	
//	// getter & setter
//	public String getSname() {
//		return sname;
//	}
//
//
//	public void setSname(String sname) {
//		this.sname = sname;
//	}
//
//
//	public String getSname2() {
//		return sname2;
//	}
//
//
//	public void setSname2(String sname2) {
//		this.sname2 = sname2;
//	}
//
//
//	public double getLat() {
//		return lat;
//	}
//
//
//	public void setLat(double lat) {
//		this.lat = lat;
//	}
//
//
//	public double getLng() {
//		return lng;
//	}
//
//
//	public void setLng(double lng) {
//		this.lng = lng;
//	}
//
//
//	public String getMenu() {
//		return menu;
//	}
//
//
//	public void setMenu(String menu) {
//		this.menu = menu;
//	}
//
//
//	public Date getRead_date() {
//		return read_date;
//	}
//
//
//	public void setRead_date(Date read_date) {
//		this.read_date = read_date;
//	}
//
//
//	public int getNum() {
//		return num;
//	}
//
//
//	public void setNum(int num) {
//		this.num = num;
//	}
//	
//	@Override
//	public String toString() {
//		return "FoodStore [num= " + num + ",\t sname=" + sname + ",\t lat=" + lat + ",\t lng=" + lng + ",\t menu=" + menu +  ",\t read_date=" + read_date + " ,\t sname2=" + sname2 + " ]";
//	}
	
	private int num;
	private int number;
	private String username;
	private int pwd;
	private String title;
	private String content;
	private Date read_date;
	private int hit;
	
	
	

	
	// 비밀번호 겟! 생성자
//    public FoodStore(int num, int pwd) {
//        super();
//        this.num = num;
//        this.pwd = pwd;
//    }

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public int getPwd() {
		return pwd;
	}

	public void setPwd(int pwd) {
		this.pwd = pwd;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRead_date() {
		return read_date;
	}

	public void setRead_date(Date read_date) {
		this.read_date = read_date;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "FoodStore [num= " + num + ",\t username=" + username + ",\t pwd=" + pwd + ",\t title=" + title + ",\t content=" + content +  ",\t read_date=" + read_date +  " ,\t hit=" + hit +  " ,\t number=" + number +  "  ]";
	}
	
	
}
