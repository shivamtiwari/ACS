/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.ACSAutomation.Utilities;

/**
 *
 * @author Jav
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.StringTokenizer;

import org.yaml.snakeyaml.Yaml;

public class Utilities {
	public static String yamlFilePath = "";

	// HSSFWorkbook workbook;
	public Utilities() {
	}

	public static String setYamlFilePath(String filePath) {
		yamlFilePath = filePath;
		return filePath;
	}

	@SuppressWarnings({ "unchecked" })
	public static String getYamlValue(String yamlToken) {
		Reader reader = null;
		int tokenCount = 0, i = 0;
		Map map = null;
		StringTokenizer st = new java.util.StringTokenizer(yamlToken, ".");
		try {
			reader = new FileReader(yamlFilePath);
			String val = null;
			Yaml yaml = new Yaml();
			map = (Map) yaml.load(reader);
			tokenCount = st.countTokens();
			for (i = 1; i < tokenCount; i++) {
				String token = st.nextToken();
				map = (Map) map.get(token);
			}
			val = map.get(st.nextToken()).toString();
			return val;
		} catch (Exception e) {
			System.out.println("Yaml file not found!!!\n" + e);
			return "";
		}
	}

	public static Map getYamlNodesArray(String yamlToken) {
		Reader reader = null;
		int tokenCount = 0, i = 0;
		Map map = null;
		StringTokenizer st = new java.util.StringTokenizer(yamlToken + ".x", ".");
		try {
			reader = new FileReader(yamlFilePath);
			Yaml yaml = new Yaml();
			map = (Map) yaml.load(reader);
			tokenCount = st.countTokens();
			for (i = 1; i < tokenCount; i++) {
				String token = st.nextToken();
				map = (Map) map.get(token);
			}
			return map;
		} catch (Exception e) {
			System.out.println("Either Yaml file not found or there is problem with token passed!!!\n" + e);
			return null;
		}
	}

	public static String getCurrentFormatedTime() {
		// TODO Auto-generated method stub
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public static String logOutputFile(String output) {
		File file = new File(Utilities.getYamlValue("logFilePath") + "/logs.txt");
		output = getCurrentFormatedTime() + " " + output + "\n";
		BufferedWriter output1 = null;
		try {
			output1 = new BufferedWriter(new FileWriter(file, true));
			output1.append(output);
			output1.newLine();
			output1.close();
		} catch (Exception e) {
			System.out.println("Exception in logOutputFile" + e.getStackTrace());
		}
		return output;
	}
}
