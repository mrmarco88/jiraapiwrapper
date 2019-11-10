package jiraapiwrapper.services;
import java.util.Base64;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import jiraapiwrapper.config.JiraConfig;

public class JiraApi {
	
	private JiraConfig jiraConfig = new JiraConfig();
	
	
	public HttpResponse<JsonNode> getJiraProjects() {
		try {
			return Unirest.get(jiraConfig.getPropertiesByName("jira.url")+"project/")
					.header("accept", "application/json")
					.header("Authorization", "Basic "+ Base64.getEncoder().encodeToString(
							String.format(jiraConfig.getPropertiesByName("jira.username")+":"+jiraConfig.getPropertiesByName("jira.password"))
							.getBytes()))
					//.queryString("apiKey", "123")
					.asJson();
			
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void getJiraByProject(String projectName) {

	}

	public HttpResponse<JsonNode> getJiraInfoByJiraProjectAndName(String jiraName) {
		try {
			return Unirest.get(jiraName).header("accept", "application/json").queryString("apiKey", "123").asJson();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return null;
	}

}
