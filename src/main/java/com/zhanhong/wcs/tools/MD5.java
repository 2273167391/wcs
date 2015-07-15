package com.zhanhong.wcs.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密
 * 	加密根据用户名与密码加密
 * @author Arvin_Li
 *
 */
public class MD5 {
	private MD5(){}
	// 全局数组
    private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
	
	/**
	 * 获取加密码后的字符串
	 * @param userName 用户名
	 * @param password 密码
	 * @return
	 */
	public static String getPwdCode(String userName,String password){
		String resultString=userName+password;
		try {
			MessageDigest md=MessageDigest.getInstance("MD5");
			resultString=byteToString(md.digest(resultString.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return resultString;
	}
	
	/**
	 * 将二进制数组转为字符串
	 * @param bytes
	 * @return
	 */
	private static String byteToString(byte[] bytes){
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<bytes.length;i++){
			sb.append(byteToArrayString(bytes[i]));
		}
		return sb.toString();
	}
	
	/**
	 * 将字节转为十六进制字符串
	 * @param bByte
	 * @return
	 */
	private static String byteToArrayString(byte bByte){
		int iRet = bByte;
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
	}
	
	/**
	 * 检验用户输入的秘密是否正确
	 * @param userName 用户名
	 * @param password 密码
	 * @param encyPwd 加密后的密码
	 * @return
	 */
	public static boolean checkPassword(String userName,String password,String encyPwd){
		//获取加密后的密码
		String newEncyPwd=getPwdCode(userName, password);
		//判断是否一致
		return newEncyPwd.equals(encyPwd);
	}
	
	public static void main(String[] args) {
		String pwd=getPwdCode("admin1", "admin");
		System.out.println(pwd);
		System.out.println(checkPassword("admin1","admin",pwd));
	}
}
