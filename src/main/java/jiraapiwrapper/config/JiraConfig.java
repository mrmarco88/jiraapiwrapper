package jiraapiwrapper.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JiraConfig {

	private InputStream input = JiraConfig.class.getClassLoader().getResourceAsStream("config.properties");

	private Properties prop;

	public JiraConfig() {

		try {

			prop = new Properties();

			if (input == null) {
				System.out.println("Sorry, unable to find config.properties");
				return;
			}

			// load a properties file from class path, inside static method
			prop.load(input);

			// get the property value and print it out
			System.out.println(prop.getProperty("jira.url"));
			System.out.println(prop.getProperty("jira.project"));
			System.out.println(prop.getProperty("jira.username"));
			System.out.println(prop.getProperty("jira.password"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	
	public String getPropertiesByName(String propName) {
		return prop.getProperty(propName);		
	}
}
