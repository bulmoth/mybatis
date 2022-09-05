package com.kh.mybatis.member.service;

import org.apache.ibatis.session.SqlSession;

import static com.kh.mybatis.common.SqlTemplate.*;

import com.kh.mybatis.common.EncryptorInter;
import com.kh.mybatis.common.MyEncryptor;
import com.kh.mybatis.common.SecondEncryptor;
import com.kh.mybatis.member.dao.MemberDao;
import com.kh.mybatis.member.vo.MemberVo;

public class MemberService {
	
	private MemberDao dao = new MemberDao();
	private EncryptorInter myEnc = new MyEncryptor();
//	private EncryptorInter myEnc = new SecondEncryptor();

	/**
	 * 회원가입
	 * @param 회원객체
	 * @return 성공여부
	 */
	public int join(MemberVo vo) {
		
		String newPwd = myEnc.enc(vo.getPwd());
		vo.setPwd(newPwd);
		
		//커넥션 준비
		SqlSession ss = getSqlSession();
		
		//DAO 호출
		int result = dao.join(ss, vo);
		
		//트랜잭션 처리
		if(result == 1) {
			ss.commit();
		}
		
		//커넥션 정리
		ss.close();
		
		//실행결과 리턴
		return result;
	}

	/**
	 * 로그인
	 * @param 아이디, 패스워드
	 * @return 로그인 멤버 객체
	 */
	public MemberVo login(MemberVo vo) {
		
		//암호화
		String newPwd = myEnc.enc(vo.getPwd());
		vo.setPwd(newPwd);
		
		//커넥션 준비
		SqlSession ss = getSqlSession();
		
		//DAO 호출
		MemberVo loginMember = dao.login(ss, vo);
		
		//트랜잭션
		//자원 반납
		ss.close();
		
		//결과 리턴
		return loginMember;
	}

}
