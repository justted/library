package ahpu.libra.service.impl;


import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ahpu.libra.dao.AdminDao;
import ahpu.libra.entity.Admin;
import ahpu.libra.entity.NoteResult;
import ahpu.libra.service.AdminService;
import ahpu.libra.util.NoteException;
import ahpu.libra.util.NoteUtil;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;
		
	public NoteResult checkLogin(String name, String password) {
		NoteResult result = new NoteResult();
		
		Admin admin = adminDao.findByName(name);
		if(admin == null){
			result.setStatus(1);
			result.setMsg("用户名不存在");
		} else {//加密
			String md5_pwd = NoteUtil.md5(password);
			if(admin.getAd_password().equals(md5_pwd)){
				result.setStatus(0);
				result.setMsg("用户名和密码正确");
				//传出adminName和管理员token令牌
				String token = NoteUtil.createToken();
				Map<String,Object> data = new HashMap<>();
				data.put("adminToken", token);
				data.put("adminName", admin.getAd_name());
				result.setData(data);
				//将令牌号更新到数据表admin
				adminDao.updateToken(data);
			} else {
				result.setStatus(2);
				result.setMsg("密码错误");
			}
		}
		
		return result;
	}

	public NoteResult checkLogin(String admin) {
		try{
			//解析身份信息，获取“Basic 加密消息” 部分的消息
			String base64_msg = admin.split(" ")[1];
			System.out.println("密文:"+base64_msg);
			//将“加密消息”还原成明文“用户名：密码”
			byte[] output = Base64.decodeBase64(base64_msg);
			String msg = new String(output,"UTF-8");
			System.out.println("明文："+msg);
			//切割“用户名：密码”获取用户名和密码信息
			String name = msg.split(":")[0];
			String password = msg.split(":")[1];
			System.out.println("用户名："+name);
			System.out.println("密码："+password);
			//检查用户名密码的正确性
			NoteResult result = checkLogin(name, password);
			return result;
		}catch(Exception e){
			throw new NoteException("身份验证错误");
		}
	}

	

}
