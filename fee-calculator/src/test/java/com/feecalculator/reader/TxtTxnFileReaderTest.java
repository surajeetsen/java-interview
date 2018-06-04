package com.feecalculator.reader;

import com.feecalculator.dto.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

public class TxtTxnFileReaderTest {

    File file;

    private TxtTxnFileReader txtTxnFileReader;

    @Before
    public void setUp() {
        txtTxnFileReader = new TxtTxnFileReader();
        file = new File("resources/sampleData.txt");
    }

    @Test
    public void readFile() {
        List<Transaction> transactions = txtTxnFileReader.readFile(file);
        assertEquals(10, transactions.size());
    }

}