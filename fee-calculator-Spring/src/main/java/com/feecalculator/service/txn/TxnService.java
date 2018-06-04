package com.feecalculator.service.txn;

import com.feecalculator.dto.Transaction;

import java.util.List;
import java.util.Map;

public interface TxnService {
    public Boolean isIntradayTxn(List<Transaction> transactions, Transaction txn);
}
