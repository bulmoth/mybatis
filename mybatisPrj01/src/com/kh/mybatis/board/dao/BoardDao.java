package com.kh.mybatis.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.vo.BoardVo;

public class BoardDao {

	/**
	 * 게시글 작성
	 */
	public int insert(SqlSession ss, BoardVo vo) {
		
		return ss.insert("boardMapper.write", vo);
		
	}

	/**
	 * 게시글 전체 조회
	 */
	public List<BoardVo> selectList(SqlSession ss) {
		
		return ss.selectList("boardMapper.boardList");
		
	}

}
