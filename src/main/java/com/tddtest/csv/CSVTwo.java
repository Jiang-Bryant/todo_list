package com.tddtest.csv;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tddtest.entity.SipgReport;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Frank Yu
 * @date 11/11/2019
 */
public class CSVTwo {
    public static void main(String[] args) {
        // Step 1: Read JSON File to List Objects
//        String jsonStr = "[{\"id\":\"1\",\"name\":\"Jack Smith\",\"address\":\"Massachusetts\",\"age\":23},{\"id\":\"2\",\"name\":\"Adam Johnson\",\"address\":\"New York\",\"age\":27},{\"id\":\"3\",\"name\":\"Katherin Carter\",\"address\":\"Washington DC\",\"age\":26},{\"id\":\"4\",\"name\":\"Jack London\",\"address\":\"Nevada\",\"age\":33},{\"id\":\"5\",\"name\":\"Jason Bourne\",\"address\":\"California\",\"age\":36}]";
        String jsonStr = "[\n" +
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
        List<SipgReport> sipgReports = convertJsonString2Objects(jsonStr);

        // Step 2: Write List Objects to CSV File
        writeListObjects2CsvFile(sipgReports, "sipgReport.csv");
    }

    /**
     *
     * Convert JSON String to List Java Objects
     *
     * @param
     * @return
     */
    private static List<SipgReport> convertJsonString2Objects(String jsonString){
        List<SipgReport> sipgReports = null;

        try {
            sipgReports = new ObjectMapper().readValue(jsonString, new TypeReference<List<SipgReport>>(){});
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sipgReports;
    }

    /**
     * Write List Objects to CSV File
     *
     * @param sipgReports
     */
    private static void writeListObjects2CsvFile(List<SipgReport> sipgReports, String pathFile) {
        final String[] CSV_HEADER = { "id", "transactionId", "blNumber", "eventDateTime",
                "incomingDateTime" ,"callSipgDateTime", "sipgApiResponse", "status", "createdDate", "updatedDate" };

        FileWriter fileWriter = null;
        CSVPrinter csvPrinter = null;

        try {
            fileWriter = new FileWriter(pathFile);
            csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT.withHeader(CSV_HEADER));

            for (SipgReport sipgReport : sipgReports) {
                List<String> data = Arrays.asList(
                        sipgReport.getId(),
                        sipgReport.getTransactionId(),
                        sipgReport.getBlNumber(),
                        sipgReport.getEventDateTime(),
                        sipgReport.getIncomingDateTime()
                                .toString(),
                        String.valueOf(sipgReport.getCallSipgDateTime()),
                        String.valueOf(sipgReport.getSipgApiResponse()),
                        sipgReport.getStatus(),
                        String.valueOf(sipgReport.getCreatedDate()),
                        String.valueOf(sipgReport.getUpdatedDate()));

                csvPrinter.printRecord(data);
            }
        } catch (Exception e) {
            System.out.println("Writing CSV error!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
                csvPrinter.close();
            } catch (IOException e) {
                System.out.println("Flushing/closing error!");
                e.printStackTrace();
            }
        }
    }
}
