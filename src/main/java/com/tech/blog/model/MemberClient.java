package com.tech.blog.model;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.tech.blog.domain.Member;

@FeignClient("Member")
public interface MemberClient {

	@GetMapping("/")
	public Member getWord();
	
}
