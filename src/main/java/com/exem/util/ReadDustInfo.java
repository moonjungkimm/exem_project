package com.exem.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDustInfo {
	public List<JSONObject> dustInfo() {
		System.out.println("-------------------------------moon");
		
		JSONParser parser = new JSONParser();
		List<JSONObject> dataList = new ArrayList<>();
		
		
		try {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config/dustInfo.json");
			InputStreamReader isr = new InputStreamReader(inputStream);
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
//				System.out.println(jsonObject);				
			}
			
			
			br.close();
			isr.close();
			inputStream.close();
			
			
			
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

