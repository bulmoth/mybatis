package com.kh.mybatis.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.board.service.BoardService;
import com.kh.mybatis.board.vo.BoardVo;
import com.kh.mybatis.common.PageVo;
import com.kh.mybatis.common.Pagination;

@WebServlet(urlPatterns = "/board/list")
public class BoardListController extends HttpServlet{

	/**
	 * 게시글 목록 조회
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//데이터 꺼내기
		String keyword = req.getParameter("keyword");
		String condition = req.getParameter("condition");
		
		//데이터 뭉치기
		Map<String, String> map = new HashMap<String, String>();
		map.put("keyword", keyword);
		map.put("condition", condition);
		
		//---------페이징 처리---------------
		//TODO 현재 페이지 가져오는 작업 추가하기
		int listCount = new BoardService().selectListCount();		
		int currentPage = Integer.parseInt(req.getParameter("p"));		
		int pageLimit = 5;			
		int boardLimit = 5;		

		PageVo pvo = Pagination.getPageVo(listCount, currentPage, pageLimit, boardLimit);
		
		System.out.println(pvo);
		
		//서비스 호출
		List<BoardVo> list = new BoardService().selectList(pvo, map);
		
		//화면 선택
		req.setAttribute("list", list);
		req.setAttribute("pvo", pvo);
		req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
	}
}
