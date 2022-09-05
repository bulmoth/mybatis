package com.kh.mybatis.member.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.vo.MemberVo;

public class MemberDao {

	/**
	 * 회원가입
	 * @param 커넥션
	 * @param 회원정보
	 * @return 성공여부
	 */
	public int join(SqlSession ss, MemberVo vo) {
		return ss.insert("memberMapper.join",vo);
	}

	/**
	 * 로그인
	 * @param 커넥션
	 * @param 아이디, 패스워드
	 * @return 로그인 멤버 객체
	 */
	public MemberVo login(SqlSession ss, MemberVo vo) {
		return ss.selectOne("memberMapper.login", vo);
	}

}
