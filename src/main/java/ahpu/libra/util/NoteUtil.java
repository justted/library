package ahpu.libra.util;

import java.security.MessageDigest;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

public class NoteUtil {	
	/**
	 * 采用MD5摘要算法处理信息
	 * @param msg
	 * @return
	 */
	public static String md5(String msg){
		try{
			//将msg字符串加密处理
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] input = msg.getBytes();
			byte[] output = md.digest(input);
			//将加密后的output结果转成字符串
			//采用Base64算法将字节数组转成字符串
			String base64_msg = Base64.encodeBase64String(output);
			return base64_msg;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	//通过UUID，设置ID
	public static String createId(){
		UUID uid = UUID.randomUUID();
		return uid.toString().replaceAll("-", "");
	}
	
	//通过UUID，设置令牌号
	public static String createToken(){
		return createId();
	}
	
	public static void main(String[] args) {
		System.out.println(md5("123456"));
		System.out.println(md5("666666"));
		System.out.println(createId());
		System.out.println(createId());
		
	}
	
}
