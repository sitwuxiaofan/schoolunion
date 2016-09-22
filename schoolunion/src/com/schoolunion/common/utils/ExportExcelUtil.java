package com.schoolunion.common.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.schoolunion.common.contants.Constants;

public class ExportExcelUtil {


	/**
	  * generateExcelFile:(生成Excel文件)
	  * @Title: generateExcelFile
	  * @param resultSet
	  * @param dataList
	  * @return
	  * String
	 */
	public static String generateExcelFile(String resultSet, List<Map> dataList) {

		String filePath = getFilePath(resultSet);

		generateHeaders(dataList, filePath);

		return filePath;
	}
	
	/**
	  * generateHeaders:(获取 excel Header)
	  * @Title: generateHeaders
	  * @param dataList
	  * @param filePath
	  * void
	 */
	private static void generateHeaders(List<Map> dataList, String filePath) {

		for (Map rowMap : dataList) {
			String[] headers = new String[rowMap.size()];
			int index = 0;
			for (Object key : rowMap.keySet()) {
				headers[index] = String.valueOf(key);
				index++;
			}

			generateExcel(headers, dataList, filePath);
			break;

		}

	}



	/**
	  * generateExcel:(生成 Excel)
	  * @Title: generateExcel
	  * @param headers
	  * @param dataList
	  * @param filePath
	  * void
	 */
	private static void generateExcel(String[] headers, List<Map> dataList,
			String filePath) {

		// path是指欲下载的文件的路径。
		File file = new File(filePath);
		createFile(file);
		// 取得文件名。
		String filename = file.getName();

		// 创建一个webbook，对应一个Excel文件
		HSSFWorkbook workbook = new HSSFWorkbook();

		// 在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = workbook.createSheet(filename);
		
		// 生成一个样式
		HSSFCellStyle headerStyle = setHSSFCellHeaderStyle(workbook);
        HSSFCellStyle cellStyle = setHSSFCellStyle(workbook);  

		// 产生表格标题行
		HSSFRow row = sheet.createRow(0);
		for (short i = 0; i < headers.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(headerStyle);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}

		// 写入数据
		int index = 0;
		for (Map dataMap : dataList) {
			index++;
			row = sheet.createRow(index);
			for (int i = 0; i < headers.length; i++) {
				HSSFCell cell = row.createCell(i);
				cell.setCellStyle(cellStyle);
				String value = String.valueOf(dataMap.get(headers[i]));
				if(!value.equals("null")){
					HSSFRichTextString text = new HSSFRichTextString(value);
					cell.setCellValue(text);
				}else{
					cell.setCellValue("");
				}
			}

		}

		for (int i = 0; i < headers.length; i++) {
			sheet.autoSizeColumn(i);// 单元格宽度自适应 参数是列号
		}
		writeFile(workbook, filePath);

	}
	
	/**
	  * setHSSFCellHeaderStyle:(生成 表头 样式)
	  * @Title: setHSSFCellHeaderStyle
	  * @param workbook
	  * @return
	  * HSSFCellStyle
	 */
	private static HSSFCellStyle setHSSFCellHeaderStyle(HSSFWorkbook workbook){
		
		HSSFCellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);  
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);  
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
        
        return style;
	}
	
	/**
	  * setHSSFCellStyle:(内容样式)
	  * @Title: setHSSFCellStyle
	  * @param workbook
	  * @return
	  * HSSFCellStyle
	 */
	private static HSSFCellStyle setHSSFCellStyle(HSSFWorkbook workbook){
		
        HSSFCellStyle style = workbook.createCellStyle();  
        style.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);  
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);  
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); 
		
		return style;
	}
	

	/**
	  * createFile:(判断 文件 目录 是否存在)
	  * @Title: createFile
	  * @param file
	  * void
	 */
	private static void createFile(File file) {

		// 判断文件目录的存在
		if (!file.exists()) {
			File file2 = new File(file.getParent());
			if (!file2.exists() && !file2.isDirectory()) {
				file2.mkdirs();
				if (!file.exists()) {
					try {
						file.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else if (!file.exists()) {

				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}


	}

	/**
	 * writeFile:(写入 文件 )
	 * 
	 * @Title: writeFile
	 * @param workbook
	 * @param filePath
	 *            void
	 */
	private static void writeFile(HSSFWorkbook workbook, String filePath) {

		OutputStream out = null;
		try {
			out = new FileOutputStream(filePath);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			workbook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * getFilePath:(文件路径)
	 * 
	 * @Title: getFilePath
	 * @return String
	 */
	private static String getFilePath(String resultSet) {

		
		PropertiesUtil prop = new PropertiesUtil();
		String filePath = prop.getKeyValue(Constants.THIRD_FILE_DOWNLOAD_DIRECTORY);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String currentDate = sdf.format(new Date());

		return filePath + "\\" + currentDate + "\\" + resultSet + ".xls";
	}

}
