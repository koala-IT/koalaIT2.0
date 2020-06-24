package com.koalaIT.common.util;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
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
    private static final int DATA_SIZE = 65000;

    public void exportExcel(HSSFWorkbook workbook, int sheetNum, String fileName, List<String> headers, Collection<T> dataset, OutputStream out, List<Integer> excelConfigs, String title) {
        exportExcel(workbook, sheetNum, fileName, headers, dataset, out, "yyyy-MM-dd HH:mm:ss",excelConfigs,title);
    }

    /**
     * @param pattern 如果有时间数据，设定输出格式。默认为"yyy-MM-dd"
     */

    @SuppressWarnings("deprecation")
    public void exportExcel(HSSFWorkbook workbook, int sheetNum, String title, List<String> headers, Collection<T> dataset, OutputStream out, String pattern, List<Integer> excelConfigs, String titleT) {
        try {
            int totalSize = dataset.size();
            int sheetSize = totalSize / DATA_SIZE;
            if (totalSize % DATA_SIZE != 0) {
                sheetSize += 1;
            }
            Iterator<T> it = dataset.iterator();
            for (int j = 0; j < sheetSize; j++) {
                if (j > 0) {
                    title += "" + j;
                }

                // 生成一个表格
                HSSFSheet sheet = workbook.createSheet(title);

                // 设置表格默认列宽度为15个字节
                sheet.setDefaultColumnWidth((short) 25);
                // 生成一个样式
                HSSFCellStyle style = workbook.createCellStyle();

                //生成第一行即标题行
                HSSFFont font = workbook.createFont();
                font.setFontHeightInPoints((short) 30);
                font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
                style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
                style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
                style.setBorderRight(HSSFCellStyle.BORDER_THIN);
                style.setBorderTop(HSSFCellStyle.BORDER_THIN);
                style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                style.setFont(font);
                HSSFRow row = sheet.createRow(0);
                HSSFCell cellTitle = row.createCell(0);
                cellTitle.setCellStyle(style);
//                String titleT = "遥感数据综合查询结果";
                sheet.addMergedRegion(new CellRangeAddress(0,0,0,headers.size() - 1));
                HSSFRichTextString textTitle = new HSSFRichTextString(titleT);
                cellTitle.setCellValue(textTitle);

                // 设置这些样式
                style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
                style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
                style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
                style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
                style.setBorderRight(HSSFCellStyle.BORDER_THIN);
                style.setBorderTop(HSSFCellStyle.BORDER_THIN);
                style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                // 生成一个字体
                font = workbook.createFont();
                font.setColor(HSSFColor.VIOLET.index);
                font.setFontHeightInPoints((short) 12);
                font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
                // 把字体应用到当前的样式
                style.setFont(font);
                // 产生表格标题行
                row = sheet.createRow(1);
                for (short i = 0; i < headers.size(); i++) {
                    HSSFCell cell = row.createCell(i);
                    cell.setCellStyle(style);
                    HSSFRichTextString text = new HSSFRichTextString(headers.get(i));
                    cell.setCellValue(text);
                }

                style = workbook.createCellStyle();

                int index = 1;
                int dataCount = 0;
                while (it.hasNext()) {
                    index++;
                    row = sheet.createRow(index);
                    T t = (T) it.next();
                    // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
                    Field[] fields = t.getClass().getDeclaredFields();

                    for (short i = 0; i < 13; i++) {
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
                            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                            cell.setCellStyle(style);
                            cell.setCellValue(textValue);
                        }
                    }

                    short col = 13;
                    if (excelConfigs != null) {
                        short i = 13;
                        aa:for (Integer n = 0; n < excelConfigs.size(); n++) {
                            if (excelConfigs.get(n) != null) {
                                for (; i < 23; i++) {
                                    if (i == excelConfigs.get(n)) {
                                        HSSFCell cell = row.createCell(col);
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
                                            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                                            cell.setCellStyle(style);
                                            cell.setCellValue(textValue);
                                        }
                                        col++;
                                        continue aa;
                                    }
                                }
                            }
                        }
                    }

                    for (short i = 23; i < 35; i++,col++) {
                        HSSFCell cell = row.createCell(col);
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
                            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                            cell.setCellStyle(style);
                            cell.setCellValue(textValue);
                        }
                    }
                    dataCount++;
                    if (dataCount == DATA_SIZE) {
                        break;
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

        try {
            workbook.write(out);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("deprecation")
    public void exportExcelForCommon(HSSFWorkbook workbook, int sheetNum, String title, List<String> headers, Collection<T> dataset, OutputStream out, String pattern, List<Integer> excelConfigs, String titleT) {
        pattern = "yyyy-MM-dd HH:mm:ss";

        try {
            int totalSize = dataset.size();
            int sheetSize = totalSize / DATA_SIZE;
            if (totalSize % DATA_SIZE != 0) {
                sheetSize += 1;
            }

            // 遍历集合数据，产生数据行
            Iterator<T> it = dataset.iterator();
            for (int j = 0; j < sheetSize; j++) {
                if (j > 0) {
                    title += "" + j;
                }
                // 生成一个表格
                HSSFSheet sheet = workbook.createSheet();

                workbook.setSheetName(sheetSize - 1, title);
                // 设置表格默认列宽度为15个字节
                sheet.setDefaultColumnWidth((short) 25);
                // 生成一个样式
                HSSFCellStyle style = workbook.createCellStyle();

                //生成第一行即标题行
                HSSFFont font = workbook.createFont();
                font.setFontHeightInPoints((short) 30);
                font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
                style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
                style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
                style.setBorderRight(HSSFCellStyle.BORDER_THIN);
                style.setBorderTop(HSSFCellStyle.BORDER_THIN);
                style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                style.setFont(font);
                HSSFRow row = sheet.createRow(0);
                HSSFCell cellTitle = row.createCell(0);
                cellTitle.setCellStyle(style);
                sheet.addMergedRegion(new CellRangeAddress(0,0,0,headers.size() - 1));
                HSSFRichTextString textTitle = new HSSFRichTextString(titleT);
                cellTitle.setCellValue(textTitle);

                // 设置这些样式
                style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
                style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
                style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
                style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
                style.setBorderRight(HSSFCellStyle.BORDER_THIN);
                style.setBorderTop(HSSFCellStyle.BORDER_THIN);
                style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                // 生成一个字体
                font = workbook.createFont();
                font.setColor(HSSFColor.VIOLET.index);
                font.setFontHeightInPoints((short) 16);

                font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
                // 把字体应用到当前的样式
                style.setFont(font);
                // 产生表格标题行
                row = sheet.createRow(1);
                for (short i = 0; i < headers.size(); i++) {
                    HSSFCell cell = row.createCell(i);
                    cell.setCellStyle(style);
                    HSSFRichTextString text = new HSSFRichTextString(headers.get(i));
                    cell.setCellValue(text);
                }

                style = workbook.createCellStyle();

                int index = 1;
                int dataCount = 0;
                while (it.hasNext()) {
                    index++;
                    row = sheet.createRow(index);
                    if (StringUtils.isBlank(pattern)) {
                        row.setHeightInPoints((short) 18);
                    } else if (pattern.equals("H")) {
                        row.setHeightInPoints((short) 250);
                    }
                    T t = (T) it.next();
                    // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
                    Field[] fields = t.getClass().getDeclaredFields();

                    for (short i = 0; i < headers.size(); i++) {
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
                                if ("imagePath".equals(fieldName) && i == 18) {
                                    sheet.addMergedRegion(new CellRangeAddress(index,index,18,20));

                                    ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
                                    BufferedImage bufferImg = null;
                                    try {
                                        bufferImg = ImageIO.read(new File((String) value));
//                                        bufferImg = ImageIO.read(new File("C:\\excel_tpl\\ludashi.jpg"));

                                        ImageIO.write(bufferImg, "jpg", byteArrayOut);

                                        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
                                        //anchor主要用于设置图片的属性
                                        HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 355, 200,(short) 18, index, (short) 20, index);
                                        anchor.setAnchorType(0);
                                        //插入图片
                                        patriarch.createPicture(anchor, workbook.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    textValue = value.toString();
                                }
                            }
                        }

                        if (textValue != null) {
                            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                            cell.setCellStyle(style);
                            cell.setCellValue(textValue);
                        }
                    }
                    dataCount++;
                    if (dataCount == DATA_SIZE) {
                        break;
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

        try {
            workbook.write(out);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
