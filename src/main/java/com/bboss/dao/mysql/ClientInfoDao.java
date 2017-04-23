package com.bboss.dao.mysql;

import org.apache.ibatis.annotations.Mapper;

import com.bboss.model.ClientInfo;

@Mapper
public interface ClientInfoDao {

	ClientInfo getInfoByClientId(String clientId);

}
