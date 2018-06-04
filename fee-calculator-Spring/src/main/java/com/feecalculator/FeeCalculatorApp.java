package com.feecalculator;

import com.feecalculator.common.TxnFeeTemplateImpl;
import com.feecalculator.config.FeeCalculatorAppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;

public class FeeCalculatorApp {

    public static void main( String[] args ) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(FeeCalculatorAppConfig.class);
        File file = new File("resources/sampleData.xlsx");

        TxnFeeTemplateImpl template = ctx.getBean("txnFeeTemplateImpl", TxnFeeTemplateImpl.class);
        template.feeCalculatorTemplate(file);
    }

}