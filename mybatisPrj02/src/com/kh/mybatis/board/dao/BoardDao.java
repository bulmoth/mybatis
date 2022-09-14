package com.kh.mybatis.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.vo.BoardVo;
import com.kh.mybatis.common.PageVo;

public class BoardDao {

	/**
	 * 게시글 작성
	 * @param ss
	 * @param vo
	 * @return
	 */
	public int write(SqlSession ss, BoardVo vo) {
		
		return ss.insert("boardMapper.write", vo);
		
	}

	/**
	 * 게시글 목록 조회
	 * @param pvo 
	 * @param 커넥션
	 * @return 게시글 리스트
	 */
	public List<BoardVo> selectList(SqlSession ss, PageVo pvo, Map map) {
		//offset : 몇 개 건너뛸지
		//limit : 몇 개 조회할지
		
		  /*
	       * ex ) boardLimit : 5
	       *                            offset(건너뛸숫자)      limit(조회할숫자)          
	       * currentPage : 1         1~5            0                5
	       * currentPage : 2         6~10           5                5
	       * currentPage : 3         11~15         10                5
	       * 
	       * offset = (현재페이지 - 1) * 리밋;
	       */
		
		int offset = (pvo.getCurrentPage()-1)*pvo.getBoardLimit();
		int limit = pvo.getBoardLimit();
		
		RowBounds rb = new RowBounds(offset, limit);
		
		return ss.selectList("boardMapper.selectList", map, rb);
		
	}

	/**
	 * 게시글 갯수 조회
	 * @param ss
	 * @param map 
	 * @return 게시글 갯수
	 */
	public int selectListCount(SqlSession ss, Map<String, String> map) {
		
		return ss.selectOne("boardMapper.selectListCount");
		
	}

}
