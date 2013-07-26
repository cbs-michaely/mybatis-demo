package mybatis.study;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class App 
{
	
	public static void main( String[] args ) throws IOException{
    	org.apache.ibatis.logging.LogFactory.useLog4JLogging();
    	String resource = "mybatis/study/mybatis-config.xml";
    	InputStream inputStream = Resources.getResourceAsStream(resource);
    	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    	SqlSession session = sqlSessionFactory.openSession();

    	try {
        	EventMapper eventMapper = session.getMapper(EventMapper.class);
        	Event event = new Event();
    	    event.setUser("kermit");
    	    event.setProcess_id("55555333");
    	    event.setContent("new contnet");
    	    eventMapper.insertEvent(event);
        	System.out.println(eventMapper.findAll().size());
    	} finally {
    		session.commit();
    		session.close();
    	}
    }
}
