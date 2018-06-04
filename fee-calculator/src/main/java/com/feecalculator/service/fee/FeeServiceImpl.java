package com.feecalculator.service.fee;

import com.feecalculator.common.StaticConstants;
import com.feecalculator.dto.Transaction;
import com.feecalculator.service.txn.TxnService;
import com.feecalculator.service.txn.TxnServiceImpl;

import java.util.List;

public class FeeServiceImpl implements FeeService {

    private TxnService txnService = new TxnServiceImpl();

    @Override
    public void updateTxnFee(List<Transaction> transactions) {
        for(Transaction txn : transactions) {
            if(txnService.isIntradayTxn(transactions, txn)) {
                txn.setProcessingFees(StaticConstants.INTRADAY_FEES);
            } else {
                if(txn.getPriorityFlag().trim().equalsIgnoreCase("Y")) {
                    txn.setProcessingFees(StaticConstants.HIGH_PRIORITY_FEES);
                } else {
                    if(txn.getTxnType().trim().equalsIgnoreCase(StaticConstants.TRANSACTION_TYPE_SELL) || txn.getTxnType().trim().equalsIgnoreCase(StaticConstants.TRANSACTION_TYPE_WITHDRAW)) {
                        txn.setProcessingFees(StaticConstants.NORMAL_PRIORITY_SELL_OR_WITHDRAW_FEES);
                    } else if(txn.getTxnType().trim().equalsIgnoreCase(StaticConstants.TRANSACTION_TYPE_BUY) || txn.getTxnType().trim().equalsIgnoreCase(StaticConstants.TRANSACTION_TYPE_DEPOSIT)) {
                        txn.setProcessingFees(StaticConstants.NORMAL_PRIORITY_BUY_OR_DEPOSIT_FEES);
                    }
                }
            }
        }
    }

}