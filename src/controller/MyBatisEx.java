package controller;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dao.face.DeptDao;
import dto.Dept;
import mybatis.MyBatisConnectionFactory;

public class MyBatisEx {
	
	public static void main(String[] args) {

		//마이바티스 실행 객체
		SqlSession sqlSession =null;
		
		//SqlSession 객체를 생성하는 팩토리 객체 
		SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		
		//DB 접속 및 SQL수행 객체 생성하기
		sqlSession = sqlSessionFactory.openSession(true); // 성공하면 자동 commit
		
		//DB 접속 및 SQL수행객체 생성하기
//		sqlSession = sqlSessionFactory.openSession();
		
		//-----------------------------------------------------
		
		//마이바티스의 매퍼와 자바프로그램의 DAO인터페이스가 매핑된다(연결된다)
		DeptDao deptDao = sqlSession.getMapper(DeptDao.class);
		
		System.out.println("마이바티스 로드 완료");

		
		//-----------------------------------------------------
	
		Dept dept = deptDao.selectByDeptno(30);
		System.out.println( dept );
		
		//-----------------------------------------------------
		//전체 부서정보 조회
		List<Dept> list = deptDao.selectAll();
		
		
		System.out.println("\n--- 전체 목록 ---");
		for(Dept d : list) {
			System.out.println(d);
		}
		
		//-----------------------------------------------------

//		String str = "ACCOUNTING";
//		String str = "SALES";
		String str = "OPERATIONS";
		Dept result1 = deptDao.selectByDname(str);
		
		System.out.println("\n--- 부서명을 이용한 조회 ---");
		System.out.println( result1 );
		
	
		//-----------------------------------------------------

		Dept data = new Dept();
		data.setDname("RESEARCH");
		Dept result2 = deptDao.selectByDnameDept( data );
		
		System.out.println("\n--- 부서명을 이용한 조회 ---");
		System.out.println( result2 );
		
		//-----------------------------------------------------

		System.out.println("\n--- 새로운 부서 정보 삽입 ---");
		Dept input = new Dept();
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("부서번호 ? ");
		input.setDeptno(sc.nextInt());

		sc.nextLine();
		System.out.println("부서이름 ? ");
		input.setDname(sc.nextLine());
		
		System.out.println("위치 ? ");
		input.setLoc(sc.nextLine());
		
		//중복 확인
		Dept res = deptDao.selectByDeptno(input.getDeptno());
//		System.out.println(res);
		
		
		if (res == null) { // 중복 데이터 없음
			//부서 정보 삽입
			int rows = deptDao.insert(input);
			System.out.println("rows : " + rows);
			
			//DB Commit
//			sqlSession.commit();
			
			//삽입결과 확인
			Dept insertResult = deptDao.selectByDeptno(input.getDeptno());
			
			System.out.println("\n--- 삽입 결과 ---");
			System.out.println(insertResult);
		}else {
			System.out.println("이미 존재하는 부서 번호 입니다.");
		}
	}
}


