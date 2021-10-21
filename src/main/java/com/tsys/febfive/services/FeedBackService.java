package com.tsys.febfive.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tsys.febfive.dao.FeedBackRepo;
import com.tsys.febfive.entities.FeedBack;

@Service
public class FeedBackService {
	
	@Autowired
	private FeedBackRepo feedBackRepo;

	public FeedBack addFeedBack(FeedBack feedBack) {
		return feedBackRepo.save(feedBack);
	}
}
