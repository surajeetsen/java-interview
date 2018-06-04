package com.feecalculator.service.file;

import com.feecalculator.config.FeeCalculatorAppConfig;
import com.feecalculator.exception.FileTypeNotSupportedException;
import com.feecalculator.reader.CsvTxnFileReader;
import com.feecalculator.reader.ExcelTxnFileReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {FeeCalculatorAppConfig.class})
public class FileServiceImplTest {

    @Autowired
    private FileService fileService;

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