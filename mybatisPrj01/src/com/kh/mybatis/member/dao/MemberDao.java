package com.kh.mybatis.member.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.vo.MemberVo;

public class MemberDao {

	/**
	 * 회원가입
	 */
	public int join(SqlSession ss, MemberVo vo) {
		
		return ss.insert("memberMapper.join", vo);
		
	}

	/**
	 * 로그인
	 */
	public MemberVo login(SqlSession ss, MemberVo vo) {
		
		return ss.selectOne("memberMapper.login", vo);
		
	}

}
