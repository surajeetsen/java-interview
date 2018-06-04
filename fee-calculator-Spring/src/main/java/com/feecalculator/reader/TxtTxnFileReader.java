package com.feecalculator.reader;

import com.feecalculator.common.Utils;
import com.feecalculator.dto.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class TxtTxnFileReader implements TxnFileReader {

    private final Logger logger = LoggerFactory.getLogger(TxtTxnFileReader.class);

    @Override
    public List<Transaction> readFile(File file) {
        List<Transaction> transactions = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(file);
             BufferedReader br = new BufferedReader(new InputStreamReader(fis))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] txnItemArr = line.split("\\|");
                transactions.add(Utils.mapStrArrToTxn(txnItemArr));
            }
        } catch (FileNotFoundException e) {
            logger.error("FileNotFoundException -> " + e.getMessage(), TxtTxnFileReader.class);
        } catch (IOException e) {
            logger.error("IOException -> " + e.getMessage(), TxtTxnFileReader.class);
        }

        return transactions;
    }

}
