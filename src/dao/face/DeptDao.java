package dao.face;

import java.util.List;

import dto.Dept;

public interface DeptDao {

	/**
	 * 부서번호를 이용하여 특정 부서 정보를 조회한다
	 * 
	 * @param deptno - 조회할 부서의 부서 번호
	 * @return 조회된 부서의 모든 칼럼 정보
	 */
	public Dept selectByDeptno(int deptno);

	/**
	 * 부서 정보를 전체 조회한다
	 * 
	 * @return 조회된 전체 부서 정보의 목록
	 */
	public List<Dept> selectAll();

	
	/**
	 * 부서명을 이용한 부서정보 조회하기
	 * 
	 * @param dname - 조회할 부서 이름
	 * @return 조회된 부서 정보
	 */
	public Dept selectByDname(String dname);

	
	/**
	 * DTO 객체에 저장된 부서명을 이용한 부서 정보 조회
	 * 
	 * @param data - 조회할 부서이름을 포함한 DTO객체
	 * @return 조회된 부서 정보
	 */
	public Dept selectByDnameDept(Dept data);

	
	/**
	 * 신규 부서 정보 삽입하기
	 * 
	 * @param input - 새로운 부서 정보
	 * @return 
	 */
	public int insert(Dept input);
}
