package com.logistics.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class MyUploadFile {
	// �ϴ��ļ��洢Ŀ¼
	// private static final String UPLOAD_DIRECTORY = "upload";

	// �ϴ�����
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	public static void upload(HttpServletRequest request, String path)
			throws IOException {
		IsFileUpload(request, path, null);
	}

	public static void upload(HttpServletRequest request, String path,
			String[] filetype) throws IOException {
		IsFileUpload(request, path, filetype);
	}

	public static boolean IsFileUpload(HttpServletRequest request, String path,
			String[] filetype) throws IOException {
		request.setCharacterEncoding("UTF-8");
		// ����Ƿ�Ϊ��ý���ϴ�
		if (!ServletFileUpload.isMultipartContent(request)) {
			// ���������ֹͣ

			request.setAttribute("message",
					"Error: ��������� enctype=multipart/form-data");
			return false;
		}

		/**
		 * �ϴ����ݼ������ļ�
		 */

		// �����ϴ�����
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// �����ڴ��ٽ�ֵ - �����󽫲�����ʱ�ļ����洢����ʱĿ¼��
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		// ������ʱ�洢Ŀ¼
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		ServletFileUpload upload = new ServletFileUpload(factory);

		// ��������ļ��ϴ�ֵ
		upload.setFileSizeMax(MAX_FILE_SIZE);

		// �����������ֵ (�����ļ��ͱ�����)
		upload.setSizeMax(MAX_REQUEST_SIZE);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String uploadSaveFolder = format.format(new Date());
		// ������ʱ·�����洢�ϴ����ļ�
		// ���·����Ե�ǰӦ�õ�Ŀ¼
		String uploadPath = setrootPath(request, path + "\\" + uploadSaveFolder);

		//�������ݿ���ļ�·��
		String uploadFile2Database=path+"\\"+uploadSaveFolder+"\\";
		
		System.out.println("uploadPath" + uploadPath);

		// ���Ŀ¼�������򴴽�
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		try {
			// ���������������ȡ�ļ�����
			// @SuppressWarnings("unchecked")
			List<FileItem> formItems = upload.parseRequest(request);

			if (formItems != null && formItems.size() > 0) {

				if (filetype != null) {
					// �����������ж��ϴ��ļ���չ��
					for (FileItem item : formItems) {
						if (!item.isFormField()) {
							// �����ڱ��е��ֶ�
							String fileName = new File(item.getName())
									.getName();
							// ��ȡ�ļ���չ��
							String pexfix = fileName.substring(
									fileName.lastIndexOf("."),
									fileName.length());
							// �ж���չ���Ƿ����Ҫ��
							// String[] filetype={".jpg",".png"};
							if (!IsAllowFile(filetype, pexfix)) {
								request.setAttribute("message", "�ϴ�ʧ�ܣ��ļ����Ͳ�����");
								return false;
							}
						}
					}
				}
				
				//List<String> list=new ArrayList<String>();
				
				// ����������
				for (FileItem item : formItems) {
					// �����ڱ��е��ֶ�
					if (!item.isFormField()) {
						String fileName = new File(item.getName()).getName();
						// ��ȡ�ļ���չ��
						String pexfix = fileName.substring(
								fileName.lastIndexOf("."), fileName.length())
								.toLowerCase();
						// �ļ�������ʱ���Զ���
						Date dNowDate = new Date();
						SimpleDateFormat ft = new SimpleDateFormat(
								"yyyyMMddhhmmss");
						String saveFileName = ft.format(dNowDate) + getUUID()
								+ pexfix;

						// System.out.println("fileName:" + fileName);

						String filePath = uploadPath + saveFileName;
						
						
						
						
						File storeFile = new File(filePath);
						// �ڿ���̨����ļ����ϴ�·��
						System.out.println(filePath);
						// ���ݿⱣ���ļ�·��
						String savefilepath=uploadFile2Database+saveFileName;
						
						System.out.println("���ݿⱣ��·��:"+savefilepath);
						// �����ļ���Ӳ��
						item.write(storeFile);
						request.setAttribute("message", "�ļ��ϴ��ɹ���");
						request.setAttribute("file", savefilepath);
					}
				}
			}
			return true;
		} catch (Exception ex) {
			request.setAttribute("message", "������Ϣ: " + ex.getMessage());
			return false;
		}
	}

	// �ļ���չ�����˷���
	private static boolean IsAllowFile(String[] mypexfix, String pexfix) {
		boolean flag = false;

		for (String s : mypexfix) {
			// ��չ��ȫ��תСдƥ��
			if (s.matches(pexfix.toLowerCase())) {
				flag = true;
			}
		}
		return flag;
	}

	// ��ʼ���ļ��ϴ�·��
	private static String setrootPath(HttpServletRequest req, String mypath) {
		// ��÷�����������
		String serverName = req.getServerName();
		// ȡ�û���������ľ��Ե�ַ
		String realPath = req.getRealPath(serverName);
		realPath = realPath.substring(0, realPath.lastIndexOf("\\"));
		String rootPath = realPath + "\\" + mypath + "\\";
		return rootPath;
	}

	public static synchronized String getUUID() {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		String uuidStr = str.replace("-", "");
		return uuidStr;
	}
	
	
	//����list����
	public static List<String> FileUpload(HttpServletRequest request, String path,
			String[] filetype) throws IOException {
		request.setCharacterEncoding("UTF-8");
		// ����Ƿ�Ϊ��ý���ϴ�
		if (!ServletFileUpload.isMultipartContent(request)) {
			// ���������ֹͣ

			request.setAttribute("message",
					"Error: ��������� enctype=multipart/form-data");
			return null;
		}

		/**
		 * �ϴ����ݼ������ļ�
		 */

		// �����ϴ�����
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// �����ڴ��ٽ�ֵ - �����󽫲�����ʱ�ļ����洢����ʱĿ¼��
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		// ������ʱ�洢Ŀ¼
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		ServletFileUpload upload = new ServletFileUpload(factory);

		// ��������ļ��ϴ�ֵ
		upload.setFileSizeMax(MAX_FILE_SIZE);

		// �����������ֵ (�����ļ��ͱ�����)
		upload.setSizeMax(MAX_REQUEST_SIZE);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String uploadSaveFolder = format.format(new Date());
		// ������ʱ·�����洢�ϴ����ļ�
		// ���·����Ե�ǰӦ�õ�Ŀ¼
		String uploadPath = setrootPath(request, path + "\\" + uploadSaveFolder);

		//�������ݿ���ļ�·��
		String uploadFile2Database=path+"\\"+uploadSaveFolder+"\\";
		
		System.out.println("uploadPath" + uploadPath);

		// ���Ŀ¼�������򴴽�
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		try {
			// ���������������ȡ�ļ�����
			// @SuppressWarnings("unchecked")
			List<FileItem> formItems = upload.parseRequest(request);

			List<String> list=new ArrayList<String>();
			
			if (formItems != null && formItems.size() > 0) {

				if (filetype != null) {
					// �����������ж��ϴ��ļ���չ��
					for (FileItem item : formItems) {
						if (!item.isFormField()) {
							// �����ڱ��е��ֶ�
							String fileName = new File(item.getName())
									.getName();
							// ��ȡ�ļ���չ��
							String pexfix = fileName.substring(
									fileName.lastIndexOf("."),
									fileName.length());
							// �ж���չ���Ƿ����Ҫ��
							// String[] filetype={".jpg",".png"};
							if (!IsAllowFile(filetype, pexfix)) {
								request.setAttribute("message", "�ϴ�ʧ�ܣ��ļ����Ͳ�����");
								return null;
							}
						}
					}
				}
				
				
				
				// ����������
				for (FileItem item : formItems) {
					// �����ڱ��е��ֶ�
					if (!item.isFormField()) {
						String fileName = new File(item.getName()).getName();
						// ��ȡ�ļ���չ��
						String pexfix = fileName.substring(
								fileName.lastIndexOf("."), fileName.length())
								.toLowerCase();
						// �ļ�������ʱ���Զ���
						Date dNowDate = new Date();
						SimpleDateFormat ft = new SimpleDateFormat(
								"yyyyMMddhhmmss");
						String saveFileName = ft.format(dNowDate) + getUUID()
								+ pexfix;

						// System.out.println("fileName:" + fileName);

						String filePath = uploadPath + saveFileName;
						
						
						
						
						File storeFile = new File(filePath);
						// �ڿ���̨����ļ����ϴ�·��
						System.out.println(filePath);
						// ���ݿⱣ���ļ�·��
						String savefilepath=uploadFile2Database+saveFileName;
						list.add(savefilepath);
						System.out.println("���ݿⱣ��·��:"+savefilepath);
						// �����ļ���Ӳ��
						item.write(storeFile);
						request.setAttribute("message", "�ļ��ϴ��ɹ���");
						request.setAttribute("file", savefilepath);
					}
				}
			}
			return list;
		} catch (Exception ex) {
			request.setAttribute("message", "������Ϣ: " + ex.getMessage());
			return null;
		}
	}

}
