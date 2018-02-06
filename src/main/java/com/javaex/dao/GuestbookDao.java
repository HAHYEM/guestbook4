package com.javaex.dao;				//DAO는 시키는 용도로 사용하는 것이다.
									//controller와 DAO를 연결해주는 @service를 만들어줘야 함.
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	
	@Autowired		//연결을 해주는 역할
	private SqlSession sqlSession;	//DAO에서 만들고 sqlSession으로 활용하는 것. --> 두개를 다 DAO라고 봐도 됨. DB에 넣어주는 역할이기 때문이다.
	
	public List<GuestbookVo> getList(){
		
		List<GuestbookVo> list = sqlSession.selectList("guestbook.getList");
		return list;
	}

	public void insert(GuestbookVo guestbookVo) {
		
		int count = sqlSession.insert("guestbook.insert", guestbookVo);
		System.out.println(count+"건 성공하였음!!!!!");
	}
	
	public void delete(int no) {
		
		int count = sqlSession.delete("guestbook.delete", no);
		System.out.println(count+"건 성공하였음!!!!!");
	}
	
	public GuestbookVo select(int no) {
		
		GuestbookVo gusetbookVo = sqlSession.selectOne("guestbook.select", no);
		return gusetbookVo;

	}

}
