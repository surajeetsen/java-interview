package com.feecalculator.reader;

import com.feecalculator.common.Utils;
import com.feecalculator.dto.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlTxnFileReader implements TxnFileReader {

    private final Logger logger = LoggerFactory.getLogger(XmlTxnFileReader.class);

    @Override
    public List<Transaction> readFile(File file) {
        List<Transaction> transactions = new ArrayList<>();

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("transaction");

            for(int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nNode;

                    String[] strArr = new String[7];
                    strArr[0] = element.getElementsByTagName("externalTxnId").item(0).getTextContent();
                    strArr[1] = element.getElementsByTagName("clientID").item(0).getTextContent();
                    strArr[2] = element.getElementsByTagName("securityID").item(0).getTextContent();
                    strArr[3] = element.getElementsByTagName("transactionType").item(0).getTextContent();
                    strArr[4] = element.getElementsByTagName("transactionDate").item(0).getTextContent();
                    strArr[5] = element.getElementsByTagName("marketValue").item(0).getTextContent();
                    strArr[6] = element.getElementsByTagName("priorityFlag").item(0).getTextContent();

                    transactions.add(Utils.mapStrArrToTxn(strArr));
                }
            }

        } catch(ParserConfigurationException e) {
            logger.error("ParserConfigurationException -> " + e.getMessage(), XmlTxnFileReader.class);
        } catch(SAXException e) {
            logger.error("SAXException -> " + e.getMessage(), XmlTxnFileReader.class);
        } catch(IOException e) {
            logger.error("IOException -> " + e.getMessage(), XmlTxnFileReader.class);
        }

        return transactions;
    }
}
