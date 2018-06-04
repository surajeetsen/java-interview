package com.feecalculator.service.file;

import com.feecalculator.exception.FileTypeNotSupportedException;
import com.feecalculator.reader.CsvTxnFileReader;
import com.feecalculator.reader.ExcelTxnFileReader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class FileServiceImplTest {

    private FileService fileService;

    @Before
    public void setUp() {
        fileService = new FileServiceImpl();
    }

    @Test
    public void getFileReaderTest() throws Exception {
        String fileName = "sampleData.xlsx";
        assertTrue(fileService.getFileReader(fileName) instanceof ExcelTxnFileReader);

        fileName = "sampleData.xls";
        assertTrue(fileService.getFileReader(fileName) instanceof ExcelTxnFileReader);

        fileName = "sampleData.csv";
        assertTrue(fileService.getFileReader(fileName) instanceof CsvTxnFileReader);
        assertFalse(fileService.getFileReader(fileName) instanceof ExcelTxnFileReader);
    }

    @Test(expected = FileTypeNotSupportedException.class)
    public void getFileReaderNotSupported() throws Exception {
        String fileName = "sampleData.xyz";
        fileService.getFileReader(fileName);
    }

}