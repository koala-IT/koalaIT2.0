package com.koalaIT.common.util;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;

import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ExportExcelUtil<T> {

    private static Logger logger = Logger.getLogger(ExportExcelUtil.class);

    public void exportExcel(HSSFWorkbook workbook, int sheetNum, String fileName, List<String> headers, Collection<T> dataset, OutputStream out) {
        exportExcel(workbook, sheetNum, fileName, headers, dataset, out, "yyyy-MM-dd");
    }

    /**
     * @param pattern 如果有时间数据，设定输出格式。默认为"yyy-MM-dd"
     */

    @SuppressWarnings("deprecation")
    public void exportExcel(HSSFWorkbook workbook, int sheetNum, String title, List<String> headers, Collection<T> dataset, OutputStream out, String pattern) {
        try {
            // 生成一个表格

            HSSFSheet sheet = workbook.createSheet();
            workbook.setSheetName(sheetNum, title);
            // 设置表格默认列宽度为15个字节
            sheet.setDefaultColumnWidth((short) 25);
            // 生成一个样式
            HSSFCellStyle style = workbook.createCellStyle();
            // 设置这些样式
            style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
            style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            style.setBorderRight(HSSFCellStyle.BORDER_THIN);
            style.setBorderTop(HSSFCellStyle.BORDER_THIN);
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            // 生成一个字体
            HSSFFont font = workbook.createFont();
            font.setColor(HSSFColor.VIOLET.index);
            font.setFontHeightInPoints((short) 12);
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            // 把字体应用到当前的样式
            style.setFont(font);
            // 产生表格标题行
            HSSFRow row = sheet.createRow(0);
            for (short i = 0; i < headers.size(); i++) {
                HSSFCell cell = row.createCell(i);
                cell.setCellStyle(style);
                HSSFRichTextString text = new HSSFRichTextString(headers.get(i));
                cell.setCellValue(text);
            }

            // 遍历集合数据，产生数据行

            Iterator<T> it = dataset.iterator();
            int index = 0;
            while (it.hasNext()) {
                index++;
                row = sheet.createRow(index);
                T t = (T) it.next();
                // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
                Field[] fields = t.getClass().getDeclaredFields();
                for (short i = 0; i < fields.length; i++) {
                    HSSFCell cell = row.createCell(i);
                    Field field = fields[i];
                    String fieldName = field.getName();
                    String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    Class<? extends Object> tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName, new Class[]{});
                    Object value = getMethod.invoke(t, new Object[]{});
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                    if (null == value) {
                        textValue = null;
                    } else {
                        if (value instanceof Date) {
                            Date date = (Date) value;
                            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                            textValue = sdf.format(date);
                        } else {
                            textValue = value.toString();
                        }
                    }

                    if (textValue != null) {
                        cell.setCellValue(textValue);
                    }
                }
            }

        } catch (IllegalAccessException e) {
            logger.error("导出:" + title + "报表出错！", e);
        } catch (InvocationTargetException e) {
            logger.error("导出:" + title + "报表出错！", e);
        } catch (SecurityException e) {
            logger.error("导出:" + title + "报表出错！", e);
        } catch (NoSuchMethodException e) {
            logger.error("导出:" + title + "报表出错！", e);
        }
    }
}
