package ahpu.libra.dao;

import java.util.Map;

import ahpu.libra.entity.Admin;
import org.springframework.stereotype.Component;

@Component
public interface AdminDao {
	Admin findByName(String ad_name);
	int updateToken(Map<String, Object> map);
}
