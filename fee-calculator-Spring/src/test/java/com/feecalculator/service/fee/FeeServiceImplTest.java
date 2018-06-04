package com.feecalculator.service.fee;

import com.feecalculator.common.Utils;
import com.feecalculator.config.FeeCalculatorAppConfig;
import com.feecalculator.dto.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {FeeCalculatorAppConfig.class})
public class FeeServiceImplTest {

    List<Transaction> transactions;

    @Autowired
    private FeeServiceImpl feeService;

    @Before
    public void setUp() {
        transactions = new ArrayList<>();
        Transaction txn = new Transaction();

        txn.setExternalTxnId("SAPEXTXN1");
        txn.setClientId("GS");
        txn.setSecurityId("ICICI");
        txn.setTxnType("BUY".trim().toUpperCase());
        txn.setTxnDate(Utils.parseDate("11/23/2013"));
        txn.setMarketValue(Double.parseDouble("101.9"));
        txn.setPriorityFlag("Y".trim());

        transactions.add(txn);
    }

    @Test
    public void updateTxnFee() {
        assertNull(transactions.get(0).getProcessingFees());
        feeService.updateTxnFee(transactions);
        assertNotNull(transactions.get(0).getProcessingFees());
    }
}