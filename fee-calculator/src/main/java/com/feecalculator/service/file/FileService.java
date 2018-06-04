package com.feecalculator.service.file;

import com.feecalculator.exception.FileTypeNotSupportedException;
import com.feecalculator.reader.TxnFileReader;

public interface FileService {
    public TxnFileReader getFileReader(String fileName) throws FileTypeNotSupportedException;
}
