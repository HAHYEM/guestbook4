package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
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
