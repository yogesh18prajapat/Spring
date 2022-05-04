package springmvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import springmvc.model.User;

@Repository("userDao")
public class UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplet;
	
	public HibernateTemplate getHibernateTemplet() {
		return hibernateTemplet;
	}

	public void setHibernateTemplet(HibernateTemplate hibernateTemplet) {
		this.hibernateTemplet = hibernateTemplet;
	}

	public int saveUser(User user) {
		int result = (Integer)this.hibernateTemplet.save(user);
		return result;
	}
}
