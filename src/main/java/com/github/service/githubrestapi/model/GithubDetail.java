package com.github.service.githubrestapi.model;

public class GithubDetail {

	public GithubDetail(Long projectId, String name, String url, String ownerLogin) {
		super();
		this.projectId = projectId;
		this.name = name;
		this.url = url;
		this.ownerLogin = ownerLogin;
	}
	private Long projectId;
	private String name;
	private String url;
	private String ownerLogin;
	
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getOwnerLogin() {
		return ownerLogin;
	}
	public void setOwnerLogin(String ownerLogin) {
		this.ownerLogin = ownerLogin;
	}
	
}
