package com.feecalculator.service.txn;

import com.feecalculator.common.Utils;
import com.feecalculator.config.FeeCalculatorAppConfig;
import com.feecalculator.dto.Transaction;
import com.feecalculator.reader.ExcelTxnFileReader;
import com.feecalculator.reader.TxnFileReader;
import com.feecalculator.reader.XmlTxnFileReader;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {FeeCalculatorAppConfig.class})
public class TxnServiceImplTest {

    File file;

    @Autowired
    ExcelTxnFileReader excelTxnFileReader;

    @Autowired
    private TxnService txnService;

    @Before
    public void setUp() {
        file = new File("resources/sampleData.xlsx");
    }

    @Test
    public void isIntradayTxn() {
        List<Transaction> txnList = excelTxnFileReader.readFile(file);
        assertEquals(2, txnList.stream().filter(txn -> txnService.isIntradayTxn(txnList, txn)).count());
    }
}