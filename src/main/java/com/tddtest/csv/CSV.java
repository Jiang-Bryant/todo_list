package com.tddtest.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.json.JSONArray;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * @author Frank Yu
 * @date 11/11/2019
 */
public class CSV {

    String json = "[\n" +
            "  {\n" +
            "    \"id\": \"5dc504f77fe74b64b04ff0dc\",\n" +
            "    \"transactionId\": \"baa2ab98f776747158917c89305e73555e4e406465244fb0665d531ee2344d76\",\n" +
            "    \"blNumber\": \"5150749520\",\n" +
            "    \"eventDateTime\": \"2019-11-01T07:27:00Z\",\n" +
            "    \"incomingDateTime\": \"2019-11-08T14:01:21\",\n" +
            "    \"callSipgDateTime\": \"2019-11-08T14:02:35.06\",\n" +
            "    \"sipgApiResponse\": \"{\\\"chain_status\\\":\\\"1\\\",\\\"code\\\":\\\"1\\\",\\\"success\\\":true,\\\"message\\\":\\\"进口提单数据上链成功\\\",\\\"timestamp\\\":1573192954856}\",\n" +
            "    \"status\": \"SUCCESS\",\n" +
            "    \"createdDate\": \"2019-11-08T14:02:31.41\",\n" +
            "    \"updatedDate\": \"2019-11-08T14:02:35.062\"\n" +
            "  }\n" +
            "]";


    /**读取csv文件
     * @param filePath 文件路径
     * @param headers csv列头
     * @return CSVRecord 列表
     * @throws IOException **/
    public static List<CSVRecord> readCSV(String filePath, String[] headers) throws IOException {

        //创建CSVFormat
        CSVFormat formator = CSVFormat.DEFAULT.withHeader(headers);

        FileReader fileReader=new FileReader(filePath);

        //创建CSVParser对象
        CSVParser parser=new CSVParser(fileReader,formator);

        List<CSVRecord> records=parser.getRecords();

        parser.close();
        fileReader.close();

        return records;
    }
}
