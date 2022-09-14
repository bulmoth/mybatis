package com.kh.mybatis.board.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.dao.BoardDao;
import com.kh.mybatis.board.vo.BoardVo;
import com.kh.mybatis.common.PageVo;

import static com.kh.mybatis.common.SqlTemplate.*;

public class BoardService {
	
	private BoardDao dao = new BoardDao();

	/**
	 * 게시글 작성
	 * @param 제목, 내용
	 * @return 성공여부
	 */
	public int write(BoardVo vo) {
		//디비 연결 정보(커넥션 준비)
		SqlSession ss = getSqlSession();
		
		//DAO 호출
		int result = dao.write(ss, vo);
		
		//트랜잭션 처리
		if(result == 1) {
			ss.commit();
		}
		
		//자원 반납
		ss.close();
		
		//결과 리턴
		return result;
	}

	/**
	 * 게시글 목록 조회
	 * @param pvo 
	 * @return
	 */
	public List<BoardVo> selectList(PageVo pvo, Map map) {
		//커넥션 준비
		SqlSession ss = getSqlSession();

		//DAO 호출
		List<BoardVo> list = dao.selectList(ss, pvo, map);
		
		//자원 반납
		ss.close();
		
		//결과 리턴
		return list;
	}

	/**
	 * 게시글 목록 갯수 조회
	 * @param map 
	 * @return 게시글 갯수
	 */
	public int selectListCount(Map<String, String> map) {
		
		//커넥션 준비
		SqlSession ss = getSqlSession();
		
		//DAO 호출
		int result = dao.selectListCount(ss, map);
		
		//자원 반납
		ss.close();
		
		//결과리턴
		return result;
	}

}
