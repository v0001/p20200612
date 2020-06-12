package com.example.vo;

import java.util.Arrays;

import org.springframework.stereotype.Controller;

@Controller

public class BoardVO {
	
	private long brd_no = 0L;
	private String brd_title = null;
	private String brd_content = null;
	private byte[] brd_img = null;
	private String brd_id = null;
	private String brd_date = null;
	private long brd_hit = 0L;
	
	public long getBrd_no() {
		return brd_no;
	}
	public void setBrd_no(long brd_no) {
		this.brd_no = brd_no;
	}
	public String getBrd_title() {
		return brd_title;
	}
	public void setBrd_title(String brd_title) {
		this.brd_title = brd_title;
	}
	public String getBrd_content() {
		return brd_content;
	}
	public void setBrd_content(String brd_content) {
		this.brd_content = brd_content;
	}
	public byte[] getBrd_img() {
		return brd_img;
	}
	public void setBrd_img(byte[] brd_img) {
		this.brd_img = brd_img;
	}
	public String getBrd_id() {
		return brd_id;
	}
	public void setBrd_id(String brd_id) {
		this.brd_id = brd_id;
	}
	public String getBrd_date() {
		return brd_date;
	}
	public void setBrd_date(String brd_date) {
		this.brd_date = brd_date;
	}
	
	public long getBrd_hit() {
		return brd_hit;
	}
	public void setBrd_hit(long brd_hit) {
		this.brd_hit = brd_hit;
	}
	
	
	@Override
	public String toString() {
		return "BoardVO [brd_no=" + brd_no + ", brd_title=" + brd_title + ", brd_content=" + brd_content + ", brd_img="
				+ Arrays.toString(brd_img) + ", brd_id=" + brd_id + ", brd_date=" + brd_date + ", brd_hit=" + brd_hit
				+ "]";
	}
	
	
}
