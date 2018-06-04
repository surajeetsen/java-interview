package com.feecalculator.reader;

import com.feecalculator.dto.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

public class XmlTxnFileReaderTest {

    File file;

    private XmlTxnFileReader xmlTxnFileReader;

    @Before
    public void setUp() {
        xmlTxnFileReader = new XmlTxnFileReader();
        file = new File("resources/sampleData.xml");
    }

    @Test
    public void readFile() {
        List<Transaction> transactions = xmlTxnFileReader.readFile(file);
        assertEquals(2, transactions.size());
    }
}