package com.exem.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DustInfo {
	public List<JSONObject> dustInfo() {
		System.out.println("-------------------------------moon");
		
		JSONParser parser = new JSONParser();
		List<JSONObject> dataList = new ArrayList<>();
		
		
		try {
			
			FileInputStream reader = new FileInputStream("src/main/resources/config/dustInfo.json");
			InputStreamReader isr = new InputStreamReader(reader);
			BufferedReader br = new BufferedReader(isr);
			
			StringBuilder sb = new StringBuilder();
						
			String line;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			
			JSONArray jsonArray = (JSONArray) parser.parse(sb.toString());
			for(Object object : jsonArray) {
				JSONObject jsonObject = (JSONObject)object;
				dataList.add(jsonObject);
				System.out.println(jsonObject);				
			}
			
			
			br.close();
			isr.close();
			reader.close();
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dataList;
		
	}	//end dustInfo
	
	
}

