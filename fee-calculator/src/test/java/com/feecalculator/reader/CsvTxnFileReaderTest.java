package com.feecalculator.reader;


import com.feecalculator.dto.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CsvTxnFileReaderTest {

    File file;

    File invalidFile;

    private CsvTxnFileReader csvTxnFileReader;

    @Before
    public void setUp() {
        csvTxnFileReader = new CsvTxnFileReader();
        file = new File("resources/sampleData.csv");
        invalidFile = new File("resources/invalidFile.csv");
    }

    @Test
    public void readFile() {
        List<Transaction> transactions = csvTxnFileReader.readFile(file);
        assertEquals(10, transactions.size());
    }


}