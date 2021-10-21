package mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnectionFactory {

	//SqlSession ��ü�� �����ϴ� ���丮 ��ü
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		
		//���̹�Ƽ�� Configuration XML ������ ���
		String res = "mybatis/mybatis-config.xml";
		
		try {
			//Configureation XML ������ �̿��� �Է� ��Ʈ�� ����
			Reader reader = Resources.getResourceAsReader(res);
			
			//�̱��� ���� �ڵ�
			if( sqlSessionFactory == null) {
				
				//�Է� ��Ʈ������ �о�帰 ���������� �̿��Ͽ� SqlSessionFactory ��ü ����
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//private ������
	private MyBatisConnectionFactory() {};
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
}
