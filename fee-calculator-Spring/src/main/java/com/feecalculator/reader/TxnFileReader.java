package com.feecalculator.reader;

import com.feecalculator.dto.Transaction;

import java.io.File;
import java.util.List;

public interface TxnFileReader {

    public List<Transaction> readFile(File file);

}
