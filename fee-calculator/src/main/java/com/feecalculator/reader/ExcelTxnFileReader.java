package com.feecalculator.reader;

import com.feecalculator.common.Utils;
import com.feecalculator.dto.Transaction;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelTxnFileReader implements TxnFileReader {

    private final Logger logger = LoggerFactory.getLogger(ExcelTxnFileReader.class);

    @Override
    public List<Transaction> readFile(File file) {

        List<Transaction> transactions = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet txnSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = txnSheet.iterator();

            while(iterator.hasNext()) {
                Row currentRow = iterator.next();
                if(currentRow.getRowNum() == 0) {
                    continue;
                }
                transactions.add(Utils.mapIterToTxn(currentRow.cellIterator()));
            }
        } catch(FileNotFoundException e) {
            logger.error("FileNotFoundException -> "+ e.getMessage(), ExcelTxnFileReader.class);
        } catch (IOException e) {
            logger.error("IOException -> " +e, ExcelTxnFileReader.class);
        }

        return transactions;
    }

}