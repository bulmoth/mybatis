package com.kh.mybatis.board.vo;

public class BoardVo {
	
	public BoardVo() {
		
	}
	
	public BoardVo(String title, String content, String enrollDate, String deleteYn) {
		super();
		this.title = title;
		this.content = content;
		this.enrollDate = enrollDate;
		this.deleteYn = deleteYn;
	}

	private String title;
	private String content;
	private String enrollDate;
	private String deleteYn;
	
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

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getDeleteYn() {
		return deleteYn;
	}

	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}

	@Override
	public String toString() {
		return "BoardVo [title=" + title + ", content=" + content + ", enrollDate=" + enrollDate + ", deleteYn="
				+ deleteYn + "]";
	}

}
