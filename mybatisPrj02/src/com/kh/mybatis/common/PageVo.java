package com.kh.mybatis.common;

public class PageVo {
	
	public PageVo() {
		
	}
	
	public PageVo(int listCount, int currentPage, int pageLimit, int boardLimit, int maxPage, int startPage,
			int endPage) {
		super();
		this.listCount = listCount;			
		this.currentPage = currentPage;		
		this.pageLimit = pageLimit;			
		this.boardLimit = boardLimit;		
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	private int listCount;		//총 게시글 개수
	private int currentPage;	//현재 페이지
	private int pageLimit;		//하단 페이지 목록 최대 개수
	private int boardLimit;		//게시글 최대 개수
	
	private int maxPage;
	private int startPage;
	private int endPage;
	
	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}

	public int getBoardLimit() {
		return boardLimit;
	}

	public void setBoardLimit(int boardLimit) {
		this.boardLimit = boardLimit;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	@Override
	public String toString() {
		return "PageVo [listCount=" + listCount + ", currentPage=" + currentPage + ", pageLimit=" + pageLimit
				+ ", boardLimit=" + boardLimit + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage="
				+ endPage + "]";
	}

}
