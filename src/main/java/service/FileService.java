package service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import dto.FileInfo;

@Service
public class FileService {
	
	private final String PATH = "/files/upload";
	
	public List<FileInfo> findAllFileInfo(HttpServletRequest request) {
		List<FileInfo> list = new ArrayList<FileInfo>();
		File baseDir = new File(request.getServletContext().getRealPath(PATH));
		File[] files = baseDir.listFiles();
		int number = 1;
		for(File file : files) {
			if (file.isDirectory()) {
				continue;
			}
			FileInfo info = new FileInfo(file, number++);
			list.add(info);
		}
		return list;
	}
	
	public void saveOne(CommonsMultipartFile file, HttpServletRequest request) {
		String fileName = file.getOriginalFilename();
		String path = request.getServletContext().getRealPath(PATH);
		String fpath = path + "\\" + fileName;
		System.out.println("파일경로!!");
		System.out.println(fpath);
		
		if (!fileName.equals("")) {
			FileOutputStream fs = null;
			try {
				fs = new FileOutputStream(fpath);
				fs.write(file.getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					fs.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
	public File findOne(String name, HttpServletRequest request) {
		File baseDir = new File(request.getServletContext().getRealPath(PATH));
		File[] files = baseDir.listFiles();
		for(File file : files) {
			if (file.isDirectory()) {
				continue;
			}
			if (file.getName().contains(name)) {
				return file;
			}
		}
		return null;
	}
}
