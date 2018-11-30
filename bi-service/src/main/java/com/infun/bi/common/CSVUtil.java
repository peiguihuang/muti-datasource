package com.infun.bi.common;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;

/**
 * 文件操作
 */
public class CSVUtil {
 
  /**
   * 生成为CVS文件 
   * @param exportData
   *       源数据List
   * @param map
   *       csv文件的列表头map
   * @param outPutPath
   *       文件路径
   * @param fileName
   *       文件名称
   * @return
   */
  @SuppressWarnings("rawtypes")
  public static File createCSVFile(List exportData, LinkedHashMap map, String outPutPath,
                   String fileName) {
    File csvFile = null;
    BufferedWriter csvFileOutputStream = null;
    try {
      File file = new File(outPutPath);
      if (!file.exists()) {
        file.mkdirs();
      }
      fileName=UUID.randomUUID().toString().replace("-", "")+"_"+fileName;
      //定义文件名格式并创建
      //csvFile = File.createTempFile(fileName, ".csv", new File(outPutPath));
      csvFile = new File(outPutPath+File.separator+fileName+".csv");
//      System.out.println("csvFile：" + csvFile);
      // UTF-8使正确读取分隔符"," 
      csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
        csvFile,true), "GBK"), 1024);
//      System.out.println("csvFileOutputStream：" + csvFileOutputStream);
      // 写入文件头部 
      for (Iterator propertyIterator = map.entrySet().iterator(); propertyIterator.hasNext();) {
        Map.Entry propertyEntry = (Map.Entry) propertyIterator.next();
        csvFileOutputStream.write("" + (String) propertyEntry.getValue() != null ? (String) propertyEntry
            .getValue() : "" + "");
        if (propertyIterator.hasNext()) {
          csvFileOutputStream.write(",");
        }
      }
      csvFileOutputStream.newLine();
      // 写入文件内容
      for (Iterator iterator = exportData.iterator(); iterator.hasNext();) {
        Object row = (Object) iterator.next();

        for (Iterator propertyIterator = map.entrySet().iterator(); propertyIterator
          .hasNext();) {
          Map.Entry propertyEntry = (Map.Entry) propertyIterator
            .next();
          String res=BeanUtils.getProperty(row,(String) propertyEntry.getKey());
          if(res==null){
        	  res="";
          }
          csvFileOutputStream.write(res);
          if (propertyIterator.hasNext()) {
            csvFileOutputStream.write(",");
          }
        }
        if (iterator.hasNext()) {
          csvFileOutputStream.newLine();
        }
      }
      csvFileOutputStream.flush();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        csvFileOutputStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return csvFile;
  }

  @SuppressWarnings("rawtypes")
  public static File createCSVFile(List exportData, LinkedHashMap map, String outPutPath,
                   String fileName,boolean isHead) {
    File csvFile = null;
    BufferedWriter csvFileOutputStream = null;
    try {
      File file = new File(outPutPath);
      if (!file.exists()) {
        file.mkdirs();
      }
      //定义文件名格式并创建
      //csvFile = File.createTempFile(fileName, ".csv", new File(outPutPath));
      csvFile = new File(outPutPath+File.separator+fileName+".csv");
//      System.out.println("csvFile：" + csvFile);
      // UTF-8使正确读取分隔符","
      csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
        csvFile,true), "GBK"), 1024);
//      System.out.println("csvFileOutputStream：" + csvFileOutputStream);
      // 写入文件头部
      if(isHead){
          for (Iterator propertyIterator = map.entrySet().iterator(); propertyIterator.hasNext();) {
              Map.Entry propertyEntry = (Map.Entry) propertyIterator.next();
              csvFileOutputStream.write("" + (String) propertyEntry.getValue() != null ? (String) propertyEntry
                  .getValue() : "" + "");
              if (propertyIterator.hasNext()) {
                csvFileOutputStream.write(",");
              }
            }
      }
      csvFileOutputStream.newLine();

      // 写入文件内容
      for (Iterator iterator = exportData.iterator(); iterator.hasNext();) {
        Object row = (Object) iterator.next();

        for (Iterator propertyIterator = map.entrySet().iterator(); propertyIterator
          .hasNext();) {
          Map.Entry propertyEntry = (Map.Entry) propertyIterator
            .next();
          String res=BeanUtils.getProperty(row,(String) propertyEntry.getKey());
          if(res==null){
        	  res="";
          }
          csvFileOutputStream.write(res);
          if (propertyIterator.hasNext()) {
            csvFileOutputStream.write(",");
          }
        }
        if (iterator.hasNext()) {
          csvFileOutputStream.newLine();
        }
      }
      csvFileOutputStream.flush();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        csvFileOutputStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return csvFile;
  }

  @SuppressWarnings("rawtypes")
  public static File createCSVFileMerger(List exportData,List exportData1 ,LinkedHashMap map,LinkedHashMap map1, String outPutPath,
                   String fileName) {
    File csvFile = null;
    BufferedWriter csvFileOutputStream = null;
    try {
      File file = new File(outPutPath);
      if (!file.exists()) {
        file.mkdirs();
      }
      //定义文件名格式并创建
      //csvFile = File.createTempFile(fileName, ".csv", new File(outPutPath));
      csvFile = new File(outPutPath+File.separator+fileName+".csv");
      System.out.println("csvFile：" + csvFile);
      // UTF-8使正确读取分隔符","
      csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
        csvFile), "GBK"), 1024);
      System.out.println("csvFileOutputStream：" + csvFileOutputStream);
      // 写入文件头部
      for (Iterator propertyIterator = map.entrySet().iterator(); propertyIterator.hasNext();) {
        Map.Entry propertyEntry = (Map.Entry) propertyIterator.next();
        csvFileOutputStream.write("" + (String) propertyEntry.getValue() != null ? (String) propertyEntry
            .getValue() : "" + "");
        if (propertyIterator.hasNext()) {
          csvFileOutputStream.write(",");
        }
      }
      csvFileOutputStream.newLine();
      // 写入文件内容
      for (Iterator iterator = exportData.iterator(); iterator.hasNext();) {
        Object row = (Object) iterator.next();

        for (Iterator propertyIterator = map.entrySet().iterator(); propertyIterator
          .hasNext();) {
          Map.Entry propertyEntry = (Map.Entry) propertyIterator
            .next();
          String res=BeanUtils.getProperty(row,(String) propertyEntry.getKey());
          if(res==null){
        	  res="";
          }
          csvFileOutputStream.write(res);
          if (propertyIterator.hasNext()) {
            csvFileOutputStream.write(",");
          }
        }
        if (iterator.hasNext()) {
          csvFileOutputStream.newLine();
        }
      }
      for(int i =0;i<5;i++){
    	  csvFileOutputStream.newLine();
      }
      csvFileOutputStream.newLine();
      // 写入文件头部1
      for (Iterator propertyIterator = map1.entrySet().iterator(); propertyIterator.hasNext();) {
        Map.Entry propertyEntry = (Map.Entry) propertyIterator.next();
        csvFileOutputStream.write("" + (String) propertyEntry.getValue() != null ? (String) propertyEntry
            .getValue() : "" + "");
        if (propertyIterator.hasNext()) {
          csvFileOutputStream.write(",");
        }
      }
      csvFileOutputStream.newLine();
      // 写入文件内容 1
      for (Iterator iterator = exportData1.iterator(); iterator.hasNext();) {
        Object row = (Object) iterator.next();

        for (Iterator propertyIterator = map1.entrySet().iterator(); propertyIterator
          .hasNext();) {
          Map.Entry propertyEntry = (Map.Entry) propertyIterator
            .next();
          String res=BeanUtils.getProperty(row,(String) propertyEntry.getKey());
          if(res==null){
        	  res="";
          }
          csvFileOutputStream.write(res);
          if (propertyIterator.hasNext()) {
            csvFileOutputStream.write(",");
          }
        }
        if (iterator.hasNext()) {
          csvFileOutputStream.newLine();
        }
      }
      csvFileOutputStream.flush();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        csvFileOutputStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return csvFile;
  }
 
  /**
   * 下载文件
   * @param response
   * @param csvFilePath
   *       文件路径
   * @param fileName
   *       文件名称
   * @throws IOException
   */
  public static void exportFile(HttpServletResponse response, String csvFilePath, String fileName)
                                                  throws IOException {
    response.setContentType("application/csv;charset=UTF-8");
    response.setHeader("Content-Disposition",
      "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
 
    InputStream in = null;
    try {
      in = new FileInputStream(csvFilePath);
      int len = 0;
      byte[] buffer = new byte[1024];
      response.setCharacterEncoding("UTF-8");
      OutputStream out = response.getOutputStream();
      while ((len = in.read(buffer)) > 0) {
        out.write(new byte[] { (byte) 0xEF, (byte) 0xBB, (byte) 0xBF });
        out.write(buffer, 0, len);
      }
    } catch (FileNotFoundException e) {
      System.out.println(e);
    } finally {
      if (in != null) {
        try {
          in.close();
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    }
  }
 
  /**
   * 删除该目录filePath下的所有文件
   * @param filePath
   *      文件目录路径
   */
  public static void deleteFiles(String filePath) {
    File file = new File(filePath);
    if (file.exists()) {
      File[] files = file.listFiles();
      for (int i = 0; i < files.length; i++) {
        if (files[i].isFile()) {
          files[i].delete();
        }
      }
    }
  }
 
  /**
   * 删除单个文件
   * @param filePath
   *     文件目录路径
   * @param fileName
   *     文件名称
   */
  public static void deleteFile(String filePath, String fileName) {
    File file = new File(filePath);
    if (file.exists()) {
      File[] files = file.listFiles();
      for (int i = 0; i < files.length; i++) {
        if (files[i].isFile()) {
          if (files[i].getName().equals(fileName)) {
            files[i].delete();
            return;
          }
        }
      }
    }
  }
 
  /**
   * 测试数据
   * @param args
   */
//  @SuppressWarnings({ "rawtypes", "unchecked" })
//  public static void main(String[] args) {
//    List exportData = new ArrayList<Map>();
//    Map row1 = new LinkedHashMap<String, String>();
//    row1.put("name", "11");
//    row1.put("sex", "12");
//    row1.put("3", "13");
//    row1.put("4", "14");
//    exportData.add(row1);
//    row1 = new LinkedHashMap<String, String>();
//    row1.put("name", "21");
//    row1.put("sex", "22");
//    row1.put("3", "23");
//    row1.put("4", "24");
//    exportData.add(row1);
//    LinkedHashMap map = new LinkedHashMap();
//    map.put("name", "第一列");
//    map.put("sex", "第二列");
//    map.put("3", "第三列");
//    map.put("4", "第四列");
// 
//    String path = "c:/export/tt/";
//    String fileName = "文件导出";
//    File file = CSVUtil.createCSVFile(exportData, map, path, fileName);
//    String fileName2 = file.getName();
//    System.out.println("文件名称：" + fileName2);
//  }
}
