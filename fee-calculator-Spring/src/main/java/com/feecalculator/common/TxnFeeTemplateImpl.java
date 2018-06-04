package com.feecalculator.common;

import com.feecalculator.dto.Transaction;
import com.feecalculator.exception.FileTypeNotSupportedException;
import com.feecalculator.reader.TxnFileReader;
import com.feecalculator.service.fee.FeeService;
import com.feecalculator.service.file.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
public class TxnFeeTemplateImpl extends AbstractTxnFeeTemplate {

    private final Logger logger = LoggerFactory.getLogger(TxnFeeTemplateImpl.class);

    @Autowired
    private FileService fileService;

    @Autowired
    private FeeService feeService;

    @Override
    public TxnFileReader getTxnFileReader(String fileName) {
        TxnFileReader fileReader = null;
        try {
            fileReader = fileService.getFileReader(fileName);
        } catch(FileTypeNotSupportedException e) {
            logger.error("FileTypeNotSupportedException -> "+ e.getMessage(), TxnFeeTemplateImpl.class);
            System.exit(1);
        }

        return fileReader;
    }

    @Override
    public List<Transaction> getAllTransactions(TxnFileReader fileReader, File file) {
        List<Transaction> transactions = fileReader.readFile(file);
        return transactions;
    }

    @Override
    public void updateTxnFees(List<Transaction> transactions) {
        feeService.updateTxnFee(transactions);
    }

    @Override
    public void sortTxns(List<Transaction> transactions) {
        transactions.sort(Comparator.comparing(Transaction::getClientId)
                .thenComparing(Transaction::getSecurityId)
                .thenComparing(Transaction::getTxnDate)
                .thenComparing(Comparator.comparing(Transaction::getPriorityFlag).reversed()));
    }

    @Override
    public void displayReport(List<Transaction> transactions) {
        System.out.println(String.join("", Collections.nCopies(110, "-")));
        System.out.println("CLIENT ID\t | TRANSACTION TYPE \t | TRANSACTION DATE \t\t\t\t\t | PRIORITY \t | PROCESSING FEE |");
        System.out.println(String.join("", Collections.nCopies(110, "-")));
        transactions.forEach(System.out::println);
    }

}
