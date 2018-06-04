package com.feecalculator.common;

import com.feecalculator.dto.Transaction;
import com.feecalculator.reader.*;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

public class TxnFeeTemplateImplTest {
    File xlFile = null;
    File csvFile = null;
    File txtFile = null;
    File xmlFile = null;

    private AbstractTxnFeeTemplate txnFeeTemplate;

    @Before
    public void setUp() {
        txnFeeTemplate = new TxnFeeTemplateImpl();
        xlFile = new File("resources/sampleData.xlsx");
        csvFile = new File("resources/sampleData.csv");
        txtFile = new File("resources/sampleData.txt");
        xmlFile = new File("resources/sampleData.xml");
    }

    @Test
    public void testAllFileReader() {
        assertTrue(txnFeeTemplate.getTxnFileReader(xlFile.getName()) instanceof ExcelTxnFileReader);
        assertTrue(txnFeeTemplate.getTxnFileReader(csvFile.getName()) instanceof CsvTxnFileReader);
        assertTrue(txnFeeTemplate.getTxnFileReader(txtFile.getName()) instanceof TxtTxnFileReader);
        assertTrue(txnFeeTemplate.getTxnFileReader(xmlFile.getName()) instanceof XmlTxnFileReader);
    }

    @Test
    public void testGetAllTransactions() {
        File file = xlFile;
        TxnFileReader fileReader = txnFeeTemplate.getTxnFileReader(file.getName());
        assertEquals(21, txnFeeTemplate.getAllTransactions(fileReader, file).size());

        file = csvFile;
        fileReader = txnFeeTemplate.getTxnFileReader(file.getName());
        assertEquals(10, txnFeeTemplate.getAllTransactions(fileReader, file).size());

        file = txtFile;
        fileReader = txnFeeTemplate.getTxnFileReader(file.getName());
        assertEquals(10, txnFeeTemplate.getAllTransactions(fileReader, file).size());

        file = xmlFile;
        fileReader = txnFeeTemplate.getTxnFileReader(file.getName());
        assertEquals(2, txnFeeTemplate.getAllTransactions(fileReader, file).size());
    }

    @Test
    public void updateTxnFees() {
        File file = xlFile;
        TxnFileReader fileReader = txnFeeTemplate.getTxnFileReader(file.getName());
        List<Transaction> transactions = txnFeeTemplate.getAllTransactions(fileReader, file);

        transactions.forEach(tx -> assertNull(tx.getProcessingFees()));
        txnFeeTemplate.updateTxnFees(transactions);
        transactions.forEach(tx -> assertNotNull(tx.getProcessingFees()));
    }

    @Test
    public void sortTxnTest() {
        File file = xmlFile;
        TxnFileReader fileReader = txnFeeTemplate.getTxnFileReader(file.getName());
        List<Transaction> transactions = txnFeeTemplate.getAllTransactions(fileReader, file);

        assertEquals("SAPEXTXN1", transactions.get(0).getExternalTxnId());
        txnFeeTemplate.sortTxns(transactions);
        assertEquals("SAPEXTXN2", transactions.get(0).getExternalTxnId());
    }
}