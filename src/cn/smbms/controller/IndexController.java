package cn.smbms.controller;

import java.sql.Connection;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.smbms.dao.BaseDao;
import cn.smbms.dao.user.UserDao;
import cn.smbms.dao.user.UserDaoImpl;
import cn.smbms.pojo.User;

@Controller
public class IndexController {
	
	private UserDao userDao;
	
	@RequestMapping("/index")
	public String index(Model model){
		userDao = new UserDaoImpl();
		Connection connection = BaseDao.getConnection();
		try {
			List<User> userList = userDao.getUserList(connection, null, 0, 1, 5);
			model.addAttribute(userList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.closeResource(connection, null, null);
		}
		
		return "index";
	}
	
}
