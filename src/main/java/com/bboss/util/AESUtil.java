package com.bboss.util;

import java.io.UnsupportedEncodingException;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class AESUtil {
	/**
	 * 加密
	 * @param content    加密内容
	 * @param encryptKey 密钥
	 * @return   用Base64转码后的字符串
	 * @throws Exception
	 */
	public static String encrypt(String content, String encryptKey) {
		try {
			/*KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(128, new SecureRandom(encryptKey.getBytes()));  
	        SecretKey secretKey = kgen.generateKey();  */
            Key secretKey =getKey(encryptKey);
	        byte[] enCodeFormat = secretKey.getEncoded();  
	        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");  
	  
	        Cipher cipher = Cipher.getInstance("AES");// 创建密码器   
	        byte[] byteContent = content.getBytes("utf-8");  
	        cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化   
	        byte[] result = cipher.doFinal(byteContent);  
	        
	        //return result;  
	        return new Base64().encodeToString(result);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
      return null;
    }  
	
	/**
	 * 解码  
	 * @param content   解码字符串
	 * @param password  密钥
	 * @return   解码后的字符串
	 * @throws UnsupportedEncodingException
	 */
	public static String decrypt(String content, String password){
        try {  
        	
        	byte[] encrypted1 = new Base64().decode(content);//先用base64解密

            /*KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();*/
            Key secretKey =getKey(password);
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(encrypted1);
            //return result; // 加密
            String originalString = new String(result,"utf-8");
            return originalString;

                
        } catch (NoSuchAlgorithmException e) {  
                e.printStackTrace();  
        } catch (NoSuchPaddingException e) {  
                e.printStackTrace();  
        } catch (InvalidKeyException e) {  
                e.printStackTrace();  
        } catch (IllegalBlockSizeException e) {  
                e.printStackTrace();  
        } catch (BadPaddingException e) {  
                e.printStackTrace();  
        } catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        return null;  
    }
	
	 /**
     * 解密
     * @param sSrc   解密字符串
     * @param sKey	 解密密钥
     * @return
     * @throws Exception
     */
    public static String decryptAppoint(String sSrc, String sKey) {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = new Base64().decode(sSrc);//先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original,"utf-8");
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
 


    public static Key getKey(String strKey) {
        try {
            if (strKey == null) {
                strKey = "";
            }
            KeyGenerator _generator = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(strKey.getBytes());
            _generator.init(128, secureRandom);
            return _generator.generateKey();
        } catch (Exception e) {
            throw new RuntimeException(" 初始化密钥出现异常 ");
        }
    }
    /*public static void main(String[] args) throws Exception {
        
        
       String cKey = "QtpLbepchuI3gEFlCZihbKOZ";
       // 需要加密的字串
       String cSrc = "a=1&d=2&dc=200";
     //加密   
       *//*System.out.println("加密前：" + cSrc);
       byte[] encryptResult = aesEncryptToBytes(cSrc, cKey);  
       //解密   
       byte[] decryptResult = decrypt(encryptResult,cKey);  
       System.out.println("解密后：" + new String(decryptResult));  *//*
       
      
       *//*String encryptResult = encrypt(cSrc, cKey);
       System.out.println("加密后：" + encryptResult);  
       //解密   
       String decryptResult = decrypt(encryptResult,cKey);
       System.out.println("解密后：" + decryptResult);*//*

        *//*String clientCodeEnc  = encrypt("6wNwJUCfpXKzyyGvVhGmzHeG",Constants.AesKey.CLIENT_CODE_KEY);
        System.out.println("clientCodeEnc：" + clientCodeEnc);
        String clientCode = decrypt(clientCodeEnc, Constants.AesKey.CLIENT_CODE_KEY);
        System.out.println("clientCode：" + clientCode);*//*
       *//* String clientCodeEnc  = encrypt("4CDTmw0LW6erlUJb223YSzsZ",Constants.AesKey.CLIENT_CODE_KEY);
        System.out.println("clientCodeEnc：" + clientCodeEnc);
        String clientCode = decrypt(clientCodeEnc, Constants.AesKey.CLIENT_CODE_KEY);
        System.out.println("clientCode：" + clientCode);*//*
        *//*
        clientCodeEnc：tsExjbHvKy+uX+VYq3IhqSUDRMP7MNXMRCzdN/UJgtE=
        clientCode：4CDTmw0LW6erlUJb223YSzsZ
        *//*

        String clientCodeEnc  = encrypt("Gao12306",Constants.AesKey.CLIENT_CODE_KEY);
        System.out.println("clientCodeEnc：" + clientCodeEnc);
        String clientCode = decrypt(clientCodeEnc, Constants.AesKey.CLIENT_CODE_KEY);
        System.out.println("clientCode：" + clientCode);
   }*/
   /* public static void main(String[] args) {
    	 String clientCodeEnc  = encrypt("123",ECPConstants.AesKey.AES_CODE);
         System.out.println("clientCodeEnc：" + clientCodeEnc);
         String clientCode = decrypt(clientCodeEnc, ECPConstants.AesKey.AES_CODE);
         System.out.println("clientCode：" + clientCode);
	}*/
   

}
