package com.bboss.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Subscription;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bboss.dao.vertica.SubscriptionDao;



@Transactional 
@Service
public class SubscriptionService {
	/*
	@Autowired
	private SubscriptionDao subscriptionDao;

	*//**
	 * 查询EC订购
	 * @param custId
	 * @return
	 *//*
	public List<Subscription> findCustSubscriptions(String custId) {
		return subscriptionDao.findCustSubscriptions(custId);
	}
	*/
	

	
}

