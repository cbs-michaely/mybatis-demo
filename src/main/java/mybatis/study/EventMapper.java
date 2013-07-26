package mybatis.study;

import java.util.List;

public interface EventMapper {
	
	public List<Event> findAll();
	
	public void insertEvent(Event event);

}