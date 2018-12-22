package com.sh;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ReadExcelTest {
    public static void main(String[] args) throws IOException {
        Map<String, String> map = new HashMap<>();
        FileInputStream fis = new FileInputStream(new File("/Users/songhuan/Downloads/生日名单.xls"));
        HSSFWorkbook workbook = new HSSFWorkbook(fis);
        HSSFSheet sheet = workbook.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();
        for (int i = 1; i < lastRowNum; i++) {
            Row row = sheet.getRow(i);
            map.put(row.getCell(0).getStringCellValue().trim(), DateFormatUtils.format(row.getCell(1).getDateCellValue(), "MM-dd"));
        }
        Map<String, String> collect = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        // write
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet sheet1 = hssfWorkbook.createSheet();
        HSSFRow headerRow = sheet1.createRow(0);
        headerRow.createCell(0).setCellValue("姓名");
        headerRow.createCell(1).setCellValue("生日");
        int rowNum = 1;
        for (Map.Entry<String, String> m : collect.entrySet()) {
            HSSFRow row = sheet1.createRow(rowNum++);
            writeCell(m, row);
            FileOutputStream fos = new FileOutputStream(new File("/Users/songhuan/Downloads/生日名单-sort.xls"));
            hssfWorkbook.write(fos);
            fos.close();
//            String[] split = value.split("-");
//            Integer integer = removeZone(split[0]);
//            if (integer < 4) {
//                writeCell(m, row);
//            } else if (integer < 7) {
//                writeCell(m, row);
//            }
        }
    }

    private static void writeCell(Map.Entry<String, String> m, HSSFRow row) {
        row.createCell(0).setCellValue(m.getKey());
        row.createCell(1).setCellValue(m.getValue());
    }

    private static Integer removeZone(String str) {
        DecimalFormat df = new DecimalFormat("0");
        return Integer.parseInt(df.format(str));
    }

}
