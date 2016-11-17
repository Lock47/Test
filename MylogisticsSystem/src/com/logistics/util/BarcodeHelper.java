package com.logistics.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.jbarcode.JBarcode;
import org.jbarcode.JBarcodeFactory;
import org.jbarcode.encode.BarcodeEncoder;
import org.jbarcode.encode.EAN13Encoder;
import org.jbarcode.encode.EAN8Encoder;
import org.jbarcode.paint.EAN13TextPainter;
import org.jbarcode.paint.EAN8TextPainter;
import org.jbarcode.paint.TextPainter;
import org.jbarcode.paint.WidthCodedPainter;
import org.jbarcode.util.ImageUtil;

public class BarcodeHelper {
	/**
	 * ���ɶ���������
	 * 
	 * @param filePath
	 *            ��Ʒ������ͼƬ���·����C://barcode//images//
	 * 
	 * @param barCode
	 *            ��Ʒ�����룺13λ
	 * @param imgFormat
	 *            ͼƬ��ʽ
	 * 
	 * @return ͼƬ���·��+ͼƬ����+ͼƬ�ļ�����
	 */
	// ������EAN13����
	public static String createBarCode(String savePath, String jbarCode,
			String imgFormat) {

		// У��ȫ��ʡ�ԡ���
		// if(StringUtils.isNotEmpty(savePath)){
		//

		// return null;
		// }
		// if(StringUtils.isNotEmpty(jbarCode)){
		// return null;
		// }
		// if(StringUtils.isNotEmpty

		// (imgFormat)){
		// return null;
		// }
		// if( jbarCode.length()!=13){
		// return null;
		// }

		try {

			BufferedImage bi = null;

			int len = jbarCode.length();

			// ʵ����JBarcode
			// ����������������Ҫ��д
			JBarcode jbarcode13 = new JBarcode(EAN13Encoder.getInstance(),
					WidthCodedPainter.getInstance(),
					EAN13TextPainter.getInstance());

			// ��ȡ��ǰ12λ
			String barCode = jbarCode.substring(0, len - 1);

			// ��ȡ��У��λ
			String code = jbarCode.substring(len - 1, len);
			String checkCode = jbarcode13.calcCheckSum(barCode);

			if (!code.equals(checkCode)) {
				return "EN-13 ���������һλУ���� ���ԣ�Ӧ���ǣ� " + checkCode;
			}

			/*
			 * ����Ҫ������������ã������������������þ�û������ �����Ĭ�����ã� ��ô���þ�������һ��������� �������Ĭ��
			 * ���ã���ô�Ϳ��Ը����Լ���Ҫ����
			 */

			// �ߴ磬�������С
			jbarcode13.setXDimension(Double.valueOf(0.8).doubleValue());
			// ������߶�
			jbarcode13.setBarHeight(Double.valueOf(30).doubleValue());
			// �����
			jbarcode13.setWideRatio(Double.valueOf(20).doubleValue());
			// �Ƿ�У�����һλ��Ĭ����false
			jbarcode13.setShowCheckDigit(false);

			// ���ɶ�ά��
			bi = jbarcode13.createBarcode(barCode);

			// ����ͼƬ����
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
			String imgName = sdf.format(new Date()) + "_" + jbarCode;

			// �����ά��ͼƬ

			FileOutputStream fileOutputStream = null;
			String imgPath = savePath + imgName + "." + imgFormat;

			fileOutputStream = new FileOutputStream(imgPath);
			ImageUtil.encodeAndWrite(bi, imgFormat, fileOutputStream, 96, 96);
			fileOutputStream.close();

			// ����·��
			return imgPath;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// ������EAN8����
	public static String createBarCode8(String savePath, String jbarCode,
			String imgFormat) {

		try {

			BufferedImage bi = null;

			JBarcode localJBarcode = new JBarcode(EAN8Encoder.getInstance(),
					WidthCodedPainter.getInstance(),
					EAN8TextPainter.getInstance());
			// ���ɶ�ά��
			bi = localJBarcode.createBarcode(jbarCode);

			// ����ͼƬ����
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
			String imgName = sdf.format(new Date()) + "_" + jbarCode;

			// �����ά��ͼƬ

			FileOutputStream fileOutputStream = null;
			String imgPath = savePath + imgName + "." + imgFormat;

			fileOutputStream = new FileOutputStream(imgPath);
			ImageUtil.encodeAndWrite(bi, imgFormat, fileOutputStream, 96, 96);
			fileOutputStream.close();

			// ����·��
			return imgPath;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	private static final int BARCODE_HEIGHT = 15;
	private static final String FONT_FAMILY = "consola";
    private static final int FONT_SIZE = 14;
	public static JBarcode getJBarcode() {
		JBarcode jbc = null;
		if (jbc == null) {
			jbc = JBarcodeFactory.getInstance().createCode128();
			jbc.setTextPainter(CustomTextPainter.getInstance());
			jbc.setBarHeight(BARCODE_HEIGHT);
		}
		return jbc;
	}
	
	 /**
     * �Զ���� TextPainter�� ���������壬��С�ȵȡ�
     */
	public static class CustomTextPainter implements TextPainter {
        public static CustomTextPainter instance = new CustomTextPainter();

        public static CustomTextPainter getInstance() {
            return instance;
        }

        @Override
        public void paintText(BufferedImage barCodeImage, String text, int width) {
            Graphics g2d = barCodeImage.getGraphics();

            Font font = new Font(FONT_FAMILY, Font.PLAIN, FONT_SIZE * width);
            g2d.setFont(font);
            FontMetrics fm = g2d.getFontMetrics();
            int height = fm.getHeight();
            int center = (barCodeImage.getWidth() - fm.stringWidth(text)) / 2;

            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, barCodeImage.getWidth(), barCodeImage.getHeight() * 1 / 20);
            g2d.fillRect(0, barCodeImage.getHeight() - (height * 9 / 10), barCodeImage.getWidth(), (height * 9 / 10));
            g2d.setColor(Color.BLACK);
            g2d.drawString(text, center, barCodeImage.getHeight() - (height / 10) - 2);
        }
    }

	// ����15λ�����뷽��
	public static String createBarCode15(String savePath, String jbarCode,
			String imgFormat) {

		try {

			BufferedImage bi = null;

			JBarcode localJBarcode = getJBarcode();
			// ���ɶ�ά��
			bi = localJBarcode.createBarcode(jbarCode);

			// ����ͼƬ����
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
			String imgName = sdf.format(new Date()) + "_" + jbarCode;

			// �����ά��ͼƬ

			FileOutputStream fileOutputStream = null;
			String imgPath = savePath + imgName + "." + imgFormat;

			fileOutputStream = new FileOutputStream(imgPath);
			ImageUtil.encodeAndWrite(bi, imgFormat, fileOutputStream, 96, 96);
			fileOutputStream.close();

			// ����·��
			return imgPath;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String createBarCode15(HttpServletRequest request,
			String path, String jbarCode) throws IOException {
		// �Զ�����·������
		// ���������utf-8����
		request.setCharacterEncoding("UTF-8");
		// ͨ����ǰ�������ɶ�Ӧ���ļ��б���������ͼƬ
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String uploadSaveFolder = format.format(new Date());
		// ��ȡ������·��
		// ���·����Ե�ǰӦ�õ�Ŀ¼
		String uploadPath = setrootPath(request, path + "\\" + uploadSaveFolder);
		// ��ӡ���·��
		System.out.println(uploadPath);

		// �������ݿ���ļ�·��
		String uploadFile2Database = path + "\\" + uploadSaveFolder + "\\";

		return createBarCode15(uploadPath, jbarCode, ImageUtil.JPEG);
	}

	// �Զ����ɴ���Ŀ¼�������뷽��
	/**
	 * ���ɶ���������
	 * 
	 * @param request
	 *            ǰ��������ҪΪ��ȡ�������ĸ�Ŀ¼
	 * 
	 * @param path
	 *            �Զ��������뱣���ڷ�������Ŀ¼���ĸ��ļ�����
	 * @param jbarCode
	 *            ���������룺13λ
	 * 
	 * @return ͼƬ���·��+ͼƬ����+ͼƬ�ļ�����
	 * @throws IOException
	 */
	// ����ͼƬ·�� �������ݿ�
	public static String createBarCode13(HttpServletRequest request,
			String path, String jbarCode) throws IOException {
		// �Զ�����·������
		// ���������utf-8����
		request.setCharacterEncoding("UTF-8");
		// ͨ����ǰ�������ɶ�Ӧ���ļ��б���������ͼƬ
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String uploadSaveFolder = format.format(new Date());
		// ��ȡ������·��
		// ���·����Ե�ǰӦ�õ�Ŀ¼
		String uploadPath = setrootPath(request, path + "\\" + uploadSaveFolder);
		// ��ӡ���·��
		System.out.println(uploadPath);

		// �������ݿ���ļ�·��
		String uploadFile2Database = path + "\\" + uploadSaveFolder + "\\";

		return createBarCode(uploadPath, jbarCode, ImageUtil.JPEG);
	}

	/**
	 * ���ɶ���������
	 * 
	 * @param request
	 *            ǰ��������ҪΪ��ȡ�������ĸ�Ŀ¼
	 * 
	 * @param path
	 *            �Զ��������뱣���ڷ�������Ŀ¼���ĸ��ļ�����
	 * @param jbarCode
	 *            ���������룺8λ
	 * 
	 * @return ͼƬ���·��+ͼƬ����+ͼƬ�ļ�����
	 * @throws IOException
	 */
	public static String createBarCode8(HttpServletRequest request,
			String path, String jbarCode) throws IOException {
		// �Զ�����·������
		// ���������utf-8����
		request.setCharacterEncoding("UTF-8");
		// ͨ����ǰ�������ɶ�Ӧ���ļ��б���������ͼƬ
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String uploadSaveFolder = format.format(new Date());
		// ��ȡ������·��
		// ���·����Ե�ǰӦ�õ�Ŀ¼
		String uploadPath = setrootPath(request, path + "\\" + uploadSaveFolder);
		// ��ӡ���·��
		System.out.println(uploadPath);

		// �������ݿ���ļ�·��
		String uploadFile2Database = path + "\\" + uploadSaveFolder + "\\";

		return createBarCode8(uploadPath, jbarCode, ImageUtil.JPEG);
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

}
