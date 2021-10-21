package dao.face;

import java.util.List;

import dto.Dept;

public interface DeptDao {

	/**
	 * �μ���ȣ�� �̿��Ͽ� Ư�� �μ� ������ ��ȸ�Ѵ�
	 * 
	 * @param deptno - ��ȸ�� �μ��� �μ� ��ȣ
	 * @return ��ȸ�� �μ��� ��� Į�� ����
	 */
	public Dept selectByDeptno(int deptno);

	/**
	 * �μ� ������ ��ü ��ȸ�Ѵ�
	 * 
	 * @return ��ȸ�� ��ü �μ� ������ ���
	 */
	public List<Dept> selectAll();

	
	/**
	 * �μ����� �̿��� �μ����� ��ȸ�ϱ�
	 * 
	 * @param dname - ��ȸ�� �μ� �̸�
	 * @return ��ȸ�� �μ� ����
	 */
	public Dept selectByDname(String dname);

	
	/**
	 * DTO ��ü�� ����� �μ����� �̿��� �μ� ���� ��ȸ
	 * 
	 * @param data - ��ȸ�� �μ��̸��� ������ DTO��ü
	 * @return ��ȸ�� �μ� ����
	 */
	public Dept selectByDnameDept(Dept data);

	
	/**
	 * �ű� �μ� ���� �����ϱ�
	 * 
	 * @param input - ���ο� �μ� ����
	 * @return 
	 */
	public int insert(Dept input);
}
