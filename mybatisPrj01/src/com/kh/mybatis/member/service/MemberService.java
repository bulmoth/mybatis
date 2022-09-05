package com.kh.mybatis.member.service;

import org.apache.ibatis.session.SqlSession;

import static com.kh.mybatis.common.SqlTemplate.*;

import java.util.HashMap;

import com.kh.mybatis.member.dao.MemberDao;
import com.kh.mybatis.member.vo.MemberVo;

public class MemberService {
	
	private MemberDao dao = new MemberDao();

	/**
	 * 회원가입
	 */
	public int join(MemberVo vo) {
		//커넥션
		SqlSession ss = getSqlSessioin();
		
		//DAO 호출
		int result = dao.join(ss, vo);
		
		//트랜잭션 처리
		ss.commit();
		
		//커넥션 반납
		ss.close();
		
		//결과 리턴
		return result;
		
	}

	/**
	 * 로그인
	 */
	public MemberVo login(MemberVo vo) {
		//커넥션
		SqlSession ss = getSqlSessioin();
		
		//DAO 호출
		MemberVo loginMember = dao.login(ss, vo);
		
		//커넥션 정리(+트랜잭션 처리)
		ss.close();
		
		//결과 반환
		return loginMember;
	}

}
