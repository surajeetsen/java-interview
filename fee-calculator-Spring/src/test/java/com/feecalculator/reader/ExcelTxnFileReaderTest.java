package com.feecalculator.reader;

import com.feecalculator.config.FeeCalculatorAppConfig;
import com.feecalculator.dto.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {FeeCalculatorAppConfig.class})
public class ExcelTxnFileReaderTest {

    File file;

    @Autowired
    ExcelTxnFileReader excelTxnFileReader;

    @Before
    public void setUp() {
        file = new File("resources/sampleData.xlsx");
    }

    @Test
    public void readFile() {
        List<Transaction> txnList = excelTxnFileReader.readFile(file);
        assertEquals(21, txnList.size());
    }

}