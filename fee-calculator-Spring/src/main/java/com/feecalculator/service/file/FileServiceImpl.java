package com.feecalculator.service.file;

import com.feecalculator.exception.FileTypeNotSupportedException;
import com.feecalculator.reader.TxnFileReader;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService, ApplicationContextAware {

    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }

    public TxnFileReader getFileReader(String fileName) throws FileTypeNotSupportedException {
        TxnFileReader fileReader = null;

        if(fileName.endsWith("xlsx") || fileName.endsWith("xls")) {
            fileReader = ctx.getBean("excelTxnFileReader", TxnFileReader.class);
            return fileReader;
        } else if(fileName.endsWith("csv")) {
            fileReader = ctx.getBean("csvTxnFileReader", TxnFileReader.class);
            return fileReader;
        } else if(fileName.endsWith("txt")) {
            fileReader = ctx.getBean("txtTxnFileReader", TxnFileReader.class);
            return fileReader;
        } else if(fileName.endsWith("xml")) {
            fileReader = ctx.getBean("xmlTxnFileReader", TxnFileReader.class);
            return fileReader;
        }

        throw new FileTypeNotSupportedException("File type \"" + fileName +"\" not yet supported");
    }

}
