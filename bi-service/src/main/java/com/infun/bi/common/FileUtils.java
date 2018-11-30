package com.infun.bi.common;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static org.springframework.util.StreamUtils.BUFFER_SIZE;

/**
 * @author VinJay Yeh
 * @create 2018/7/28
 */
public class FileUtils {

    /**
     * 上传临时文件
     *
     * @param file
     * @return C:\Users\ywj\AppData\Local\Temp\test无后缀的则为文件夹
     * C:\Users\ywj\AppData\Local\Temp\abc.xls有后缀的则为文件
     * @throws Exception
     */
    public static String uploadTempFile(MultipartFile file) throws Exception {
        // 建立临时文件夹
        String tempPath = System.getProperty("java.io.tmpdir");
        File dir = new File(tempPath);
        if (!dir.exists()) {
            // 如不存在则创建
            dir.mkdir();
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 保存文件
        File serverFile = new File(tempPath + fileName);
        file.transferTo(serverFile);
        // 如果是压缩文件
        if (fileName.contains(".zip")) {
            // 解压zip源文件
            String unZipPath = unZip(serverFile, tempPath);
            // 删掉zip源文件
            serverFile.delete();
            // 返回解压后的文件夹路径
            return unZipPath;
        }
        // 返回文件路径
        return tempPath + fileName;
    }

    /**
     * zip解压
     *
     * @param srcFile     zip源文件
     * @param destDirPath 解压路径
     * @return 解压文件路径
     * @throws Exception
     */
    public static String unZip(File srcFile, String destDirPath) throws Exception {
        // 判断zip源文件是否存在
        if (!srcFile.exists()) {
            throw new RuntimeException("zip源文件不存在！");
        }
        // 开始解压zip源文件
        ZipFile zipFile = new ZipFile(srcFile, Charset.forName("GBK"));
        Enumeration<?> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry entry = (ZipEntry) entries.nextElement();
            if (entry.isDirectory()) {
                // 如果是文件夹，则创建文件夹
                String dirPath = destDirPath + "/" + entry.getName();
                File dir = new File(dirPath);
                dir.mkdirs();
            } else {
                // 如果是文件，则创建一个文件，然后用io流把内容copy过去
                File targetFile = new File(destDirPath + "/" + entry.getName());
                // 保证这个文件的父文件夹必须要存在
                if (!targetFile.getParentFile().exists()) {
                    targetFile.getParentFile().mkdirs();
                }
                targetFile.createNewFile();
                // 将压缩文件内容写入到这个文件中
                InputStream is = zipFile.getInputStream(entry);
                FileOutputStream fos = new FileOutputStream(targetFile);
                int len;
                byte[] buf = new byte[BUFFER_SIZE];
                while ((len = is.read(buf)) != -1) {
                    fos.write(buf, 0, len);
                }
                // 关流顺序，先打开的后关闭
                fos.close();
                is.close();
            }
        }
        zipFile.close();
        // 取zip源文件的路径去掉后缀则为解压后的文件夹路径
        return srcFile.getPath().split("\\.")[0];
    }

    /**
     * 获得指定文件的byte数组
     */
    public static byte[] getBytes(File file) {
        byte[] buffer = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

}
