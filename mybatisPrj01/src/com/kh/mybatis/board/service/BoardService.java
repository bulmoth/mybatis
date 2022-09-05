package com.kh.mybatis.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.dao.BoardDao;
import com.kh.mybatis.board.vo.BoardVo;
import com.kh.mybatis.common.SqlTemplate;

public class BoardService {

	/**
	 * 게시글 작성
	 */
	public int insert(BoardVo vo) {
		
		//커넥션 준비
		SqlSession ss= SqlTemplate.getSqlSessioin();
		
		//DAO 호출
		int result = new BoardDao().insert(ss, vo);
		
		//트랜잭션 처리
		if(result == 1) {
			ss.commit();
		}
		
		//자원반납
		ss.close();
		
		//결과 리턴
		return result;
	}

	/**
	 * 게시글 전체 조회
	 */
	public List<BoardVo> selectList() {
		//커넥션 준비
		SqlSession ss = SqlTemplate.getSqlSessioin();
		
		//DAO 호출
		List<BoardVo> list = new BoardDao().selectList(ss);
		
		//트랜잭션(select라서 안함)
		
		//자원 반납
		ss.close();
		
		//결과 반납
		return list;
		
	}

}//class
