package com.koalaIT.common.util;


import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by shenyf on 2018-08-27.
 */
public class FileUploadingUtil {

    /**
     * 服务器上的保存路径，在使用到上传功能的Controller中对其进行赋值
     */
    public static  String FILEDIR = "H:\\temp";

//    public static String FILEDIR = "C:\\temp";

    public static String CURRENT_FULL_FILE_PATH = "";

    public static Logger logger = Logger.getLogger(FileUploadingUtil.class);

    /**
     * 上传多个文件，返回文件名称和服务器存储路径列表
     *
     * @param files
     * @return
     * @throws IOException
     */
    public static synchronized Map<String, String> upload(Map<String, MultipartFile> files) throws IOException {
        File file = new File(FILEDIR);
        if (!file.exists() && file.isDirectory()) {
            file.mkdirs();
        }

        Map<String, String> result = new HashMap<String, String>();
        Iterator<Map.Entry<String, MultipartFile>> iter = files.entrySet().iterator();
        while (iter.hasNext()) {
            MultipartFile aFile = iter.next().getValue();
            if (aFile.getSize() != 0 && !"".equals(aFile.getName())) {
                result.put(aFile.getOriginalFilename(), uploadFile(aFile));
            }
        }
        return result;
    }

    /**
     * 上传单个文件，并返回其在服务器中的存储路径
     *
     * @param aFile
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static synchronized String uploadFile(MultipartFile aFile) throws IOException {
        String filePath = initFilePath(aFile.getOriginalFilename());
        try {
            write(aFile.getInputStream(), new FileOutputStream(filePath));
        } catch (FileNotFoundException e) {
            logger.error("上传的文件: " + aFile.getName() + " 不存在！！");
            e.printStackTrace();
        }
        return filePath;
    }

    /**
     * 写入数据
     *
     * @param in
     * @param out
     * @throws IOException
     */
    private static synchronized void write(InputStream in, OutputStream out) throws IOException {
        try {
            byte[] buffer = new byte[1024];
            int bytesRead = -1;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            out.flush();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * 遍历服务器目录，列举出目录中的所有文件（含子目录）
     * @return
     */
    public static synchronized Map<String, String> getFileMap() {
        logger.info(FileUploadingUtil.FILEDIR);
        Map<String, String> map = new HashMap<String, String>();
        File[] files = new File(FileUploadingUtil.FILEDIR).listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    File[] files2 = file.listFiles();
                    if (files2 != null) {
                        for (File file2 : files2) {
                            String name = file2.getName();
                            logger.info(file2.getParentFile().getAbsolutePath());
                            logger.info(file2.getAbsolutePath());
                            map.put(file2.getParentFile().getName() + "/" + name,
                                    name.substring(name.lastIndexOf("_") + 1));
                        }
                    }
                }
            }
        }
        return map;
    }

    /**
     * 返回文件存储路径，为防止重名文件被覆盖，在文件名称中增加了随机数
     * @param name
     * @return
     */
    private static synchronized String initFilePath(String name) {
        File file = new File(FILEDIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        Long num = new Date().getTime();
        Double d = Math.random() * num;
        String filePath = (file.getPath() + "/" + num + d.longValue() + "_" + name).replaceAll(" ", "-");
        CURRENT_FULL_FILE_PATH = filePath;
        return filePath;
    }

    /**
     *
     * @param name
     * @return
     */
    private static synchronized int getFileDir(String name) {
        return name.hashCode() & 0xf;
    }
}

