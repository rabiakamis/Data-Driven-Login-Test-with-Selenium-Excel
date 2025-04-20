
package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {
    public static List<String[]> readCredentials(String filePath) {
        List<String[]> credentials = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                // Başlık satırını atla ve boş hücreleri kontrol et
                if (row.getRowNum() == 0 || row.getCell(0) == null || row.getCell(1) == null) continue;

                // Kullanıcı adı ve şifreyi al
                String username = row.getCell(0) != null ? row.getCell(0).toString() : "";
                String password = row.getCell(1) != null ? row.getCell(1).toString() : "";

                // Verileri konsola yazdırarak kontrol et
                System.out.println("Username: " + username + ", Password: " + password);

                credentials.add(new String[]{username, password});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return credentials;
    }
}
