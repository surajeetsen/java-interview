package com.feecalculator.reader;

import com.feecalculator.dto.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

public class ExcelTxnFileReaderTest {

    File file;

    ExcelTxnFileReader excelTxnFileReader;

    @Before
    public void setUp() {
        excelTxnFileReader = new ExcelTxnFileReader();
        file = new File("resources/sampleData.xlsx");
    }

    @Test
    public void readFile() {
        List<Transaction> txnList = excelTxnFileReader.readFile(file);
        assertEquals(21, txnList.size());
    }

}