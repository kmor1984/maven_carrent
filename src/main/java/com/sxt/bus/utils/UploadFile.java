package com.sxt.bus.utils;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

public class UploadFile {
	public static  String upload(MultipartFile mf,HttpServletRequest request){
		//1、得到上传路径
		String path2=request.getServletContext().getRealPath("/upload");
		//2、得到文件名
			String name =mf.getOriginalFilename();
			/*得到生成的文件夹的名字*/
			String dirName =RandomUtils.createDirNewName();
			File dir = new File (path2,dirName);
			if(!dir.exists()){
				dir.mkdirs();
			}
			/*改名文件名字*/
			String filename= RandomUtils.createFileNewNameTime(name);
			//3、组装文件，参数1，表示上传路径   参数2，表示名件名
			 File file = new File(dir,filename);
			//4、上传文件
			try {
				mf.transferTo(file);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return "../upload/"+dirName+"/"+filename; 
	}
}
