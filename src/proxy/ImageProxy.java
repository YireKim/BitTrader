package proxy;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import domain.ImageDTO;
import enums.Props;
import lombok.Data;

@Data
public class ImageProxy implements Proxy {
	ImageDTO img;
	
	@Override
	public void carryOut(Object o) {
		
		System.out.println("=-=- [ Image proxy --1--]");
		
		
		HttpServletRequest request = (HttpServletRequest) o;

		
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			System.out.println("@@@ File comm = No file exist/No Multipart request");
			return;
		}
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		fileUpload.setFileSizeMax(1024 * 1024 * 40);	//40MB
		fileUpload.setSizeMax(1024 * 1024 * 50);	//50MB
		
		List<FileItem> items = null;
		
		try {
			File file = null;
			items = fileUpload.parseRequest(new ServletRequestContext(request));

			Iterator<FileItem> iter = items.iterator();
			
			while(iter.hasNext()) {
				FileItem item = iter.next();
				if(!item.isFormField()) {
					String fileName = item.getName();
					System.out.println("====* FILE NAME ::: "+fileName);
				    file = new File(Props.IMAGE.getValue()+fileName);
					item.write(file);
					
					img = new ImageDTO();
					img.setImgName(fileName.substring(0, fileName.indexOf(".")));
					System.out.println("File Name : "+fileName.substring(0,fileName.indexOf(".")));
					
					img.setImgExtention(fileName.substring(fileName.indexOf(".")+1));
					System.out.println("File Extention : "+fileName.substring(fileName.indexOf(".")+1));
					
					img.setImgOwner(request.getParameter("customer_id"));
					//Easiest insert DB code....he said..
				}	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
