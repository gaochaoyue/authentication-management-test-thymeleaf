package com.bboss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bboss.dao.mysql.ClientInfoDao;
import com.bboss.dao.mysql.MessageDao;
import com.bboss.model.message.MessageQuery;
import com.bboss.model.message.SysMessage;

@Service
public class MessageService {
	
	@Autowired
	private MessageDao messageDao;

	public List<SysMessage> selectMsgByCondition(MessageQuery query) {
		// TODO Auto-generated method stub
		return messageDao.selectMsgByCondition(query);
	}

}
