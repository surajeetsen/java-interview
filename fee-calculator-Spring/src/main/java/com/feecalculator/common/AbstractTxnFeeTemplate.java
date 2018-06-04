package com.feecalculator.common;

import com.feecalculator.dto.Transaction;
import com.feecalculator.reader.TxnFileReader;

import java.io.File;
import java.util.List;

public abstract class AbstractTxnFeeTemplate {

    public abstract TxnFileReader getTxnFileReader(String fileName);

    public abstract List<Transaction> getAllTransactions(TxnFileReader fileReader, File file);

    public abstract void updateTxnFees(List<Transaction> transactions);

    public abstract void sortTxns(List<Transaction> transactions);

    public abstract void displayReport(List<Transaction> transactions);

    public void feeCalculatorTemplate(File file) {
        TxnFileReader fileReader = getTxnFileReader(file.getName());

        List<Transaction> transactions = getAllTransactions(fileReader, file);

        updateTxnFees(transactions);

        sortTxns(transactions);

        displayReport(transactions);
    }

}
