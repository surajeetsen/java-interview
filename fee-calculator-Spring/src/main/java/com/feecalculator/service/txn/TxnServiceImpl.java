package com.feecalculator.service.txn;

import com.feecalculator.common.StaticConstants;
import com.feecalculator.common.Utils;
import com.feecalculator.dto.Transaction;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Scope("prototype")
public class TxnServiceImpl implements TxnService {

    private Map<String, Transaction> intradayTxnMap = null;

    private void updateIntradayTxnMap(List<Transaction> transactions) {
        intradayTxnMap = new HashMap<>();

        List<Transaction> txnBought = transactions.stream().filter(txn -> (txn.getTxnType().equalsIgnoreCase(StaticConstants.TRANSACTION_TYPE_BUY))).collect(Collectors.toList());
        List<Transaction> txnSold = transactions.stream().filter(txn -> (txn.getTxnType().equalsIgnoreCase(StaticConstants.TRANSACTION_TYPE_SELL))).collect(Collectors.toList());

        Map<String, List<Transaction>> txnBoughtMap = new HashMap<>();

        for(Transaction tx : txnBought) {
            String key = Utils.getHash(new String[]{tx.getClientId(), tx.getSecurityId(), tx.getTxnDate().toString()});

            if(!txnBoughtMap.containsKey(key)) {
                List<Transaction> list = new ArrayList<>();
                txnBoughtMap.put(key, list);
            }
            txnBoughtMap.get(key).add(tx);
        }

        for(Transaction tx : txnSold) {
            String key = Utils.getHash(new String[]{tx.getClientId(), tx.getSecurityId(), tx.getTxnDate().toString()});

            if(txnBoughtMap.containsKey(key) && txnBoughtMap.get(key).size() != 0) {
                Transaction intradayTxn = txnBoughtMap.get(key).get(0);
                intradayTxnMap.put(intradayTxn.getExternalTxnId(), intradayTxn);
                intradayTxnMap.put(tx.getExternalTxnId(), tx);
                txnBoughtMap.get(key).remove(0);
            }
        }
    }

    @Override
    public Boolean isIntradayTxn(List<Transaction> transactions, Transaction txn) {
        if(intradayTxnMap == null) {
            synchronized(this) {
                if(intradayTxnMap == null) {
                    updateIntradayTxnMap(transactions);
                }
            }
        }

        return intradayTxnMap.containsKey(txn.getExternalTxnId());
    }
}
