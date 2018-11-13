package com.sxt.bus.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class RandomUtils {
private static SimpleDateFormat time1 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
private static SimpleDateFormat time2 = new SimpleDateFormat("yyyy-MM-dd");
private static SimpleDateFormat time3 = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");
private static Random num = new Random();
//使用时间加四位随机数
/*一个文件想要给它改名字，那么首先要得到这个文件的名字，再保留这个文件后缀名，再根据规则改名。*/
public static String createFileNewNameTime(String oldName){
	/*取出后缀名：*/
	String suffix = oldName.substring(oldName.lastIndexOf("."),oldName.length());
   /*取出当前系统时间*/ 
	String date=time1.format(new Date());
     /*取出四位随机数*/
	Integer number = (num.nextInt(9000)+1000);
	/*返回新的文件名*/
	return date+number+suffix;
	
}
public static String createFileNewNameUUID(String oldName){
	/*取出后缀名：*/
	String suffix= oldName.substring(oldName.lastIndexOf("."), oldName.length());
	/*由UUID自动生成名字*/
	String name=UUID.randomUUID().toString().replace("-", "");
	/*返回新的文件名*/
	return name+suffix;

}
public static String createDirNewName(){
	/*取出当前系统时间*/ 
	String date=time2.format(new Date());
	return date;
	
}

/*出租车单据与check单据的生成*/
public static String createBill(String prefix){
	return prefix+"_"+time3.format(new Date())+ (num.nextInt(90000)+10000);
}


}
