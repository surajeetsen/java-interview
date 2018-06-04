package com.feecalculator.service.fee;

import com.feecalculator.dto.Transaction;

import java.util.List;

public interface FeeService {
    public void updateTxnFee(List<Transaction> transactions);
}
