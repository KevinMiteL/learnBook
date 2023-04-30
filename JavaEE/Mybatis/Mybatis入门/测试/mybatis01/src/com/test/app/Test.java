package com.test.app;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

//import com.test.domain.Student;
public class Test {

	//private static Logger logger = Logger.getLogger(Test.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		tesMthod();

	}

	private static void tesMthod() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			List<Map> list = sqlSession.selectList("com.test.mapper.StudentMapper.selectStudent");
			for (Map map : list) {
				//System.out.println(map);
				//logger.error(map);
				
				//Set<String> keys= map.keySet();
				//for (String i:keys) {
				//	System.out.println(i+"="+map.get(i));
				//}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			sqlSession.close();
		}

	}

}
