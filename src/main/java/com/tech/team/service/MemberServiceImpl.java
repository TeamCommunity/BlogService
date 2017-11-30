package com.tech.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tech.team.model.MemberClient;

/**
 * Build a sentence by assembling randomly generated subjects, verbs, articles,
 * adjectives, and nouns. The individual parts of speech will be obtained by
 * calling the various DAOs.
 */
@Service
public class MemberServiceImpl implements MemberService {

	MemberClient memberClient;

	/**
	 * Assemble a sentence by gathering random words of each part of speech:
	 */
	@Override
	@HystrixCommand(fallbackMethod = "getFallbackMember")
	public String buildSentence() {
		String sentence = "There was a problem assembling the sentence!";
		sentence = String.format("%s", memberClient.getWord().getString());
		return sentence;
	}

	@Autowired
	public void setMemberService(MemberClient memberClient) {
		this.memberClient = memberClient;
	}

	public String getFallbackMember() {
		return "Fallback-Someone";
	}
}
