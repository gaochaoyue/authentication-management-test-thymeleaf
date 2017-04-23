package com.bboss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bboss.dao.mysql.ClientInfoDao;
import com.bboss.model.ClientInfo;

@Service
public class ClientInfoService {
	
	@Autowired
	private ClientInfoDao clientInfoDao;

	public ClientInfo getInfoByClientId(String clientId) {
		return clientInfoDao.getInfoByClientId(clientId);
	}

}
