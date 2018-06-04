package com.feecalculator.service.fee;

import com.feecalculator.common.Utils;
import com.feecalculator.dto.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FeeServiceImplTest {

    List<Transaction> transactions;

    private FeeServiceImpl feeService;

    @Before
    public void setUp() {
        feeService = new FeeServiceImpl();
        transactions = new ArrayList<>();

        Transaction highPriorityTxn = new Transaction();
        highPriorityTxn.setExternalTxnId("SAPEXTXN1");
        highPriorityTxn.setClientId("GS");
        highPriorityTxn.setSecurityId("REL");
        highPriorityTxn.setTxnType("BUY".trim().toUpperCase());
        highPriorityTxn.setTxnDate(Utils.parseDate("11/23/2013"));
        highPriorityTxn.setMarketValue(Double.parseDouble("101.9"));
        highPriorityTxn.setPriorityFlag("Y".trim());

        Transaction withdrawTxn = new Transaction();
        withdrawTxn.setExternalTxnId("SAPEXTXN2");
        withdrawTxn.setClientId("GS");
        withdrawTxn.setSecurityId("ICICI");
        withdrawTxn.setTxnType("WITHDRAW".trim().toUpperCase());
        withdrawTxn.setTxnDate(Utils.parseDate("11/23/2013"));
        withdrawTxn.setMarketValue(Double.parseDouble("101.9"));
        withdrawTxn.setPriorityFlag("N".trim());

        Transaction depositTxn = new Transaction();
        depositTxn.setExternalTxnId("SAPEXTXN3");
        depositTxn.setClientId("GS");
        depositTxn.setSecurityId("ICICI");
        depositTxn.setTxnType("DEPOSIT".trim().toUpperCase());
        depositTxn.setTxnDate(Utils.parseDate("11/23/2013"));
        depositTxn.setMarketValue(Double.parseDouble("101.9"));
        depositTxn.setPriorityFlag("N".trim());


        Transaction intraBuyTxn = new Transaction();
        intraBuyTxn.setExternalTxnId("SAPEXTXN4");
        intraBuyTxn.setClientId("GS");
        intraBuyTxn.setSecurityId("HINDALCO");
        intraBuyTxn.setTxnType("BUY".trim().toUpperCase());
        intraBuyTxn.setTxnDate(Utils.parseDate("11/23/2013"));
        intraBuyTxn.setMarketValue(Double.parseDouble("101.9"));
        intraBuyTxn.setPriorityFlag("N".trim());

        Transaction intraSellTxn = new Transaction();
        intraSellTxn.setExternalTxnId("SAPEXTXN5");
        intraSellTxn.setClientId("GS");
        intraSellTxn.setSecurityId("HINDALCO");
        intraSellTxn.setTxnType("SELL".trim().toUpperCase());
        intraSellTxn.setTxnDate(Utils.parseDate("11/23/2013"));
        intraSellTxn.setMarketValue(Double.parseDouble("101.9"));
        intraSellTxn.setPriorityFlag("N".trim());

        transactions.add(highPriorityTxn);
        transactions.add(withdrawTxn);
        transactions.add(depositTxn);
        transactions.add(intraBuyTxn);
        transactions.add(intraSellTxn);
    }

    @Test
    public void updateTxnFee() {

        transactions.forEach(tx -> assertNull(tx.getProcessingFees()));
        feeService.updateTxnFee(transactions);
        transactions.forEach(tx -> assertNotNull(tx.getProcessingFees()));
    }
}