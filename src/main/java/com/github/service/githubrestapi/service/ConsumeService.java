package com.github.service.githubrestapi.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.github.service.githubrestapi.model.GithubDetail;


@Service
public class ConsumeService {
	
	 @Value("${github.auth.token}")
	 private String token;

    public List<GithubDetail> getProjectDetailByLanguage(String language, Integer perPageRecord, Integer pageNo){
    	
    	List<GithubDetail> listGitHubDetail = new ArrayList<>();
    	
    	try (RestTemplate template = new RestTemplate()) {
			String url = "https://api.github.com/search/repositories?q="+ language+"&per_page="+perPageRecord+"&page="+pageNo;
			
			HttpHeaders requestHeaders = new HttpHeaders();
			requestHeaders.add("Accept", "application/vnd.github+json");
			requestHeaders.add("Authorization", "Bearer "+token);			
			
			HttpEntity<Object> requestEntity = new HttpEntity<>(requestHeaders);
			
			ResponseEntity<String> responseEntity = template.exchange(UriComponentsBuilder.fromHttpUrl(url).toUriString(), HttpMethod.GET, requestEntity, String.class);
			
			JSONObject jsonObject = new JSONObject(responseEntity.getBody().toString());
			JSONArray  jsonArray = jsonObject.getJSONArray("items");
			
			jsonArray.forEach(arrVal -> {
				JSONObject aKey = (JSONObject) arrVal;
				listGitHubDetail.add(new GithubDetail(aKey.getLong("id"), aKey.getString("name"),aKey.getString("html_url"),
						aKey.getJSONObject("owner").getString("login")));			
			});

    	} catch (RestClientException | IOException e) {
			e.printStackTrace();
		}
    	return listGitHubDetail;    	
    }
    
}
