package jiraapiwrapper.businesslogic;

import com.mashape.unirest.http.HttpResponse;

import jiraapiwrapper.services.JiraApi;

public class Main {

	public static void main(String[] args) {
		JiraApi jiraApi = new JiraApi();
		
		HttpResponse<com.mashape.unirest.http.JsonNode> response = jiraApi.getJiraProjects();
		System.out.println(response.getBody().toString());
	}

}
