package com.feecalculator.service.file;

import com.feecalculator.exception.FileTypeNotSupportedException;
import com.feecalculator.reader.TxnFileReader;
import org.springframework.context.ApplicationContextAware;

public interface FileService extends ApplicationContextAware {
    public TxnFileReader getFileReader(String fileName) throws FileTypeNotSupportedException;
}
