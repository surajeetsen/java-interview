package com.feecalculator.reader;


import com.feecalculator.config.FeeCalculatorAppConfig;
import com.feecalculator.dto.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {FeeCalculatorAppConfig.class})
public class CsvTxnFileReaderTest {

    File file;

    File invalidFile;

    @Autowired
    private CsvTxnFileReader csvTxnFileReader;

    @Before
    public void setUp() {
        file = new File("resources/sampleData.csv");
        invalidFile = new File("resources/invalidFile.csv");
    }

    @Test
    public void readFile() {
        List<Transaction> transactions = csvTxnFileReader.readFile(file);
        assertEquals(10, transactions.size());
    }


}