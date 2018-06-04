package com.feecalculator;

import com.feecalculator.common.TxnFeeTemplateImpl;
import com.feecalculator.config.FeeCalculatorAppConfig;
import com.feecalculator.reader.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {FeeCalculatorAppConfig.class})
public class AllTest {

    File xlFile = null;
    File csvFile = null;
    File txtFile = null;
    File xmlFile = null;

    @Autowired
    private TxnFeeTemplateImpl txnFeeTemplate;

    @Before
    public void setUp() {
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

}