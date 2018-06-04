package com.feecalculator.service.txn;

import com.feecalculator.dto.Transaction;
import com.feecalculator.reader.ExcelTxnFileReader;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

public class TxnServiceImplTest {

    File file;

    ExcelTxnFileReader excelTxnFileReader;

    private TxnService txnService;

    @Before
    public void setUp() {
        excelTxnFileReader = new ExcelTxnFileReader();
        txnService = new TxnServiceImpl();
        file = new File("resources/sampleData.xlsx");
    }

    @Test
    public void isIntradayTxn() {
        List<Transaction> txnList = excelTxnFileReader.readFile(file);
        assertEquals(2, txnList.stream().filter(txn -> txnService.isIntradayTxn(txnList, txn)).count());
    }
}