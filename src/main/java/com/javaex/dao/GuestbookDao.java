package com.javaex.dao;				//DAO�� ��Ű�� �뵵�� ����ϴ� ���̴�.
									//controller�� DAO�� �������ִ� @service�� �������� ��.
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	
	@Autowired		//������ ���ִ� ����
	private SqlSession sqlSession;	//DAO���� ����� sqlSession���� Ȱ���ϴ� ��. --> �ΰ��� �� DAO��� ���� ��. DB�� �־��ִ� �����̱� �����̴�.
	
	public List<GuestbookVo> getList(){
		
		List<GuestbookVo> list = sqlSession.selectList("guestbook.getList");
		return list;
	}

	public void insert(GuestbookVo guestbookVo) {
		
		int count = sqlSession.insert("guestbook.insert", guestbookVo);
		System.out.println(count+"�� �����Ͽ���!!!!!");
	}
	
	public void delete(int no) {
		
		int count = sqlSession.delete("guestbook.delete", no);
		System.out.println(count+"�� �����Ͽ���!!!!!");
	}
	
	public GuestbookVo select(int no) {
		
		GuestbookVo gusetbookVo = sqlSession.selectOne("guestbook.select", no);
		return gusetbookVo;

	}

}
