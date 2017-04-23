package com.bboss.util;



import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

public class ObjectUtil {
	public static boolean isEmpty(Object obj){
		if (obj == null) return true;

	    if ((obj instanceof String)) {
	      if (((String)obj).length() == 0)
	        return true;
	    }
	    else if ((obj instanceof Collection)) {
	      if (((Collection)obj).isEmpty())
	        return true;
	    }
	    else if (obj.getClass().isArray()) {
	      if (Array.getLength(obj) == 0)
	        return true;
	    }
	    else if ((obj instanceof Map)) {
	      if (((Map)obj).isEmpty())
	        return true;
	    }
	    else {
	      return false;
	    }

	    return false;
	}
	
	public static boolean isNotEmpty(Object obj){
		return !isEmpty(obj);
	}
	
	
	public static boolean existStrArr(String str,String []strArr){
		for(int i=0;i<strArr.length;i++){
			if(strArr[i].equals(str)){
				return true;
			}
		}
		return false;
	}
	
	//分离数字和字母的字符串
	//得到数字部分
	public static String separateNumber(String str){
		String[] strs=str.split("\\d",2);
		int i = strs[0].length();
		//ch.substring(i);
		return str.substring(i);
	} 
	//得到字母部分
	public static String separateAlphabet(String str){
		String[] strs=str.split("\\d",2);
		int i = strs[0].length();
		//ch.substring(i);
		return str.substring(0,i);
	} 
	
	/*public static void main(String[] args) {
		System.out.println(ObjectUtil.separateNumber("EEE444444"));
		System.out.println(ObjectUtil.separateAlphabet("EEE444444"));
	}*/
}
