package com.infun.bi.common;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Excel工具类（基于jxl）
 *
 * @author VinJay Yeh
 * @create 2018/7/27
 */
public class ExcelUtils {

    /**
     * 读取excel表数据
     * 第一行默认作为key，除第一行外，以下每一行作为value，每列为一个键值对，组成一个LinkedHashMap
     * 所有行组成一个ArrayList
     *
     * @param excelPath  excel服务器上的全路径
     * @param whichSheet 第几个工作表，从0开始
     * @return
     * @throws Exception
     */
    public static ArrayList<LinkedHashMap<String, Object>> getExcelList(String excelPath, Integer whichSheet) throws Exception {
        ArrayList<LinkedHashMap<String, Object>> returnList = new ArrayList<>();
        // 读取excelPath路径的excel
        Workbook workbook = Workbook.getWorkbook(new File(excelPath));
        // 选取第whichSheet个工作表
        Sheet sheet = workbook.getSheet(whichSheet);
        // 从第二行开始读取（第一行为字段名）
        for (int i = 1; i < sheet.getRows(); i++) {
            // 每一行的Map
            LinkedHashMap<String, Object> rowMap = new LinkedHashMap<>();
            for (int j = 0; j < sheet.getColumns(); j++) {
                // 当前遍历行的每一列
                Cell cell = sheet.getCell(j, i);
                // 当前遍历行的每一列对应字段名
                Cell firstCell = sheet.getCell(j, 0);
                // （字段名，对应的值）
                rowMap.put(firstCell.getContents(), cell.getContents());
            }
            // 将每一行的Map存入List中
            returnList.add(rowMap);
        }
        return returnList;
    }

    /**
     * 创建Excel表
     *
     * @param firstRow 首行的列名
     * @param list     要导入的数据，key为firstRow里的列名，value为要导入的值
     * @param fileName    生成Excel的文件名
     * @return
     * @throws Exception
     */
    public static File createExcel(String[] firstRow, ArrayList<LinkedHashMap<String, Object>> list, String fileName) throws Exception {
        String tempPath = System.getProperty("java.io.tmpdir");
        File file = new File(tempPath + "/"+"fileName"+".xls");
        WritableWorkbook workbook = Workbook.createWorkbook(file);
        WritableSheet sheet = workbook.createSheet("fileName"+"list", 0);
        Label label = null;
        for (int i = 0; i < firstRow.length; i++) {
            label = new Label(i, 0, firstRow[i]);
            sheet.addCell(label);
        }
        int listSize = list.size();
        for (int i = 1; i <= listSize; i++) {
            LinkedHashMap<String, Object> map = list.get(i - 1);
            for (Map.Entry<String, Object> kav : map.entrySet()) {
                String key = kav.getKey();
                Object value = kav.getValue();
                Cell cell = sheet.findCell(key);
                if (cell != null) {
                    label = new Label(cell.getColumn(), i, (String) value);
                    sheet.addCell(label);
                }
            }
        }
        workbook.write();
        workbook.close();
        return file;
    }

//    public static void main(String[] args) {
//        try {
//            String excelPath = "E:\\IdeaWorkSpace\\infun_mall_supply\\supply-service\\src\\main\\resources\\品牌库2018.7.24.xls";
//            Integer whichSheet = 0;
//            ArrayList<LinkedHashMap<String, Object>> list = ExcelUtils.getExcelList(excelPath, whichSheet);
//            System.out.println(list);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
