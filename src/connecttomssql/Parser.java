/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connecttomssql;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public class Parser {

    private static Map<String,String> type_map = new HashMap();
    private static Map<String,String> table_map = new HashMap();
    
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("dentrix-table-columns.csv"));
        String line;
        while ((line = in.readLine())!= null){
            //System.out.println(line);
            String col[] = line.split(",");
            if(col.length == 7){
                String table = col[1];
                String colname = col[3];
                String type = col[4];
                //System.out.println(type);
                table_map.put(table, table);
                type_map.put(type,type);
            }
        }        
        in.close();
        
        for(String k:type_map.keySet()){
            System.out.println(k);
        }
    }

}
