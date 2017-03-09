package org.zerock.domain;

import java.sql.Date;
import java.util.*;

public class FoodStore {
	private int num;
	private int number;
	private String username;
	private int pwd;
	private String title;
	private String content;
	private Date read_date;
	private int hit;

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
