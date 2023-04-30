package db;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {

	public static SqlSessionFactory getFactory() {
		String config = "mybatis-config.xml";
		InputStream inputStream = MybatisUtil.class.getClassLoader().getResourceAsStream(config);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		return factory;

	}
}