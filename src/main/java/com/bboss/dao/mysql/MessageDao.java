package com.bboss.dao.mysql;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bboss.model.message.MessageQuery;
import com.bboss.model.message.SysMessage;

@Mapper
public interface MessageDao {

	List<SysMessage> selectMsgByCondition(MessageQuery query);

}
