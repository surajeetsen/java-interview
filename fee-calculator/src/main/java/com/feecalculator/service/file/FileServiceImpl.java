package com.feecalculator.service.file;

import com.feecalculator.exception.FileTypeNotSupportedException;
import com.feecalculator.reader.*;

public class FileServiceImpl implements FileService {

    public TxnFileReader getFileReader(String fileName) throws FileTypeNotSupportedException {
        TxnFileReader fileReader = null;

        if(fileName.endsWith("xlsx") || fileName.endsWith("xls")) {
            fileReader = new ExcelTxnFileReader();
            return fileReader;
        } else if(fileName.endsWith("csv")) {
            fileReader = new CsvTxnFileReader();
            return fileReader;
        } else if(fileName.endsWith("txt")) {
            fileReader = new TxtTxnFileReader();
            return fileReader;
        } else if(fileName.endsWith("xml")) {
            fileReader = new XmlTxnFileReader();
            return fileReader;
        }

        throw new FileTypeNotSupportedException("File type \"" + fileName +"\" not yet supported");
    }

}
