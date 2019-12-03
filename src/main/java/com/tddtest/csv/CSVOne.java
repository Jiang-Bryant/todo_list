package com.tddtest.csv;


import java.io.File;
import java.io.IOException;

import com.microsoft.applicationinsights.core.dependencies.apachecommons.io.FileUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Frank Yu
 * @date 11/11/2019
 */
public class CSVOne {
    public static void main(String myHelpers[]) {
//        String jsonString = "{\"infile\": [{\"field1\": 11,\"field2\": 12,\"field3\": 13},{\"field1\": 21,\"field2\": 22,\"field3\": 23},{\"field1\": 31,\"field2\": 32,\"field3\": 33}]}";
        String jsonString = "[{\"field1\": 11,\"field2\": 12,\"field3\": 13},{\"field1\": 21,\"field2\": 22,\"field3\": 23},{\"field1\": 31,\"field2\": 32,\"field3\": 33}]";
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
        try {
            JSONArray jsonArray = new JSONArray(json);
            String csv = CDL.toString(jsonArray);
//            File file = new File("/tmp2/fromJSON.csv");

            System.out.println(csv);
//            FileUtils.writeStringToFile(file, csv);
            FileUtils.writeStringToFile(new File("/tmp2/fromJSON.csv"), csv, "UTF-8",true);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

//    public static String toStringgg(JSONArray var0) throws JSONException {
//        JSONObject var1 = var0.optJSONObject(0);
//        if (var1 != null) {
//            JSONArray var2 = var1.names();
//            if (var2 != null) {
//                return rowToString(var2) + toStringgGGGG(var2, var0);
//            }
//        }
//
//        return null;
//    }
//
//    public static String toStringgGGGG(JSONArray var0, JSONArray var1) throws JSONException {
//        if (var0 != null && var0.length() != 0) {
//            StringBuffer var2 = new StringBuffer();
//
//            for(int var3 = 0; var3 < var1.length(); ++var3) {
//                JSONObject var4 = var1.optJSONObject(var3);
//                if (var4 != null) {
//                    var2.append(rowToString(var4.toJSONArray(var0)));
//                }
//            }
//
//            return var2.toString();
//        } else {
//            return null;
//        }
//    }
//
//    public static String rowToString(JSONArray var0) {
//        StringBuffer var1 = new StringBuffer();
//
//        for(int var2 = 0; var2 < var0.length(); ++var2) {
//            if (var2 > 0) {
//                var1.append(',');
//            }
//
//            Object var3 = var0.opt(var2);
//            if (var3 != null) {
//                String var4 = var3.toString();
//                if (var4.indexOf(44) >= 0) {
//                    if (var4.indexOf(34) >= 0) {
//                        var1.append('\'');
//                        var1.append(var4);
//                        var1.append('\'');
//                    } else {
//                        var1.append('"');
//                        var1.append(var4);
//                        var1.append('"');
//                    }
//                } else {
//                    var1.append(var4);
//                }
//            }
//        }

}
