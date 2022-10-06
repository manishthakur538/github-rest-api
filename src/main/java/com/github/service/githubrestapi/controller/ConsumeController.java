package com.github.service.githubrestapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.github.service.githubrestapi.model.GithubDetail;
import com.github.service.githubrestapi.service.ConsumeService;

@RestController
public class ConsumeController {

	@Autowired
	private ConsumeService consumeService;
	
	@GetMapping("/getProject/{language}/{perPageRecord}/{pageNo}")
	public List<GithubDetail> getProjectDetailByLanguage(@PathVariable String language,@PathVariable Integer perPageRecord,@PathVariable Integer pageNo) {
		return consumeService.getProjectDetailByLanguage(language,perPageRecord,pageNo);		
	}
	
}
