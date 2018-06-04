package com.feecalculator.common;

import com.feecalculator.dto.Transaction;
import org.apache.poi.ss.usermodel.Cell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.StringJoiner;

public class Utils {

    private static final Logger logger = LoggerFactory.getLogger(Utils.class);

    public static Date parseDate(String dateStr) {
        Date date = null;
        try {
            date = new SimpleDateFormat("MM/dd/yyyy").parse(dateStr);
        } catch(ParseException e) {
            logger.error("ParseException -> "+ e.getMessage(), Utils.class);
            System.exit(1);
        }
        return date;
    }

    public static Transaction mapStrArrToTxn(String[] txnItemArr) {
        Transaction txn = new Transaction();

        txn.setExternalTxnId(txnItemArr[0]);
        txn.setClientId(txnItemArr[1]);
        txn.setSecurityId(txnItemArr[2]);
        txn.setTxnType(txnItemArr[3].trim().toUpperCase());
        txn.setTxnDate(Utils.parseDate(txnItemArr[4]));
        txn.setMarketValue(Double.parseDouble(txnItemArr[5]));
        txn.setPriorityFlag(txnItemArr[6].trim());

        return txn;
    }

    public static Transaction mapIterToTxn(Iterator<Cell> cellIterator) {
        Transaction txn = new Transaction();

        while(cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            if(cell.getColumnIndex() == 0) {
                txn.setExternalTxnId(cell.getStringCellValue());
            }
            if(cell.getColumnIndex() == 1) {
                txn.setClientId(cell.getStringCellValue());
            }
            if(cell.getColumnIndex() == 2) {
                txn.setSecurityId(cell.getStringCellValue());
            }
            if(cell.getColumnIndex() == 3) {
                txn.setTxnType(cell.getStringCellValue().trim().toUpperCase());
            }
            if(cell.getColumnIndex() == 4) {
                txn.setTxnDate(cell.getDateCellValue());
            }
            if(cell.getColumnIndex() == 5) {
                txn.setMarketValue(cell.getNumericCellValue());
            }
            if(cell.getColumnIndex() == 6) {
                txn.setPriorityFlag(cell.getStringCellValue().trim());
            }
        }
        return txn;
    }

    public static String getHash(String[] keys) {
        StringJoiner sj = new StringJoiner("#");
        Arrays.stream(keys).forEach(item -> sj.add(item));
        return sj.toString();
    }

}