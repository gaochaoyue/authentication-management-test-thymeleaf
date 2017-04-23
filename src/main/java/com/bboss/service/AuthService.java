package com.bboss.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bboss.VO.AuthDataVO;
import com.bboss.VO.AuthVO;
import com.bboss.dao.mysql.AuthDao;
import com.bboss.model.Auth;
import com.bboss.util.ObjectUtil;



@Service
public class AuthService {
	
	@Autowired
	private AuthDao authDao;

	public List<AuthVO> getAuthByParentId(int parentId,List<Integer> authIdList){
		//JSONArray jsonArray=new JSONArray();
		//String sql="select * from t_auth where parentId=? and authId in ("+authIds+")";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("parentId", parentId);
		//Integer[] authArray = (Integer[]) authIds.toArray();
		map.put("authIds", authIdList);
		List<Auth> auths = authDao.getAuthByParentId(map);
		List<AuthVO> authList = new ArrayList<AuthVO>();
		for (Auth authParam : auths) {
			AuthVO auth1 = new AuthVO();
			auth1.setId(authParam.getAuthId());
			auth1.setText(authParam.getAuthName());
			if(!hasChildren(authParam.getAuthId(), authIdList)){
				auth1.setState("open");
			}else{
				auth1.setState(authParam.getState());			
			}
			auth1.setIconCls(authParam.getIconCls());
			Map<String,Object> map1 = new HashMap<String,Object>();
			map1.put("authPath",authParam.getAuthPath());
			auth1.setAttributes(map1);
			
			authList.add(auth1);
		}
		return authList;
	}
	
	private boolean hasChildren(int parentId,List<Integer> authIdList){
		//String sql="select * from t_auth where parentId=? and authId in ("+authIds+")";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("parentId", parentId);
		//String[] authArray = authIds.split(",");
		map.put("authIds", authIdList);
		List<Auth> auths = authDao.getAuthByParentId(map);
		if(auths == null){
			return false;
		}
		return true;
		
	}
	
	public List<AuthVO> getAuthsByParentId(int parentId,List<Integer> authIds){

		List<AuthVO> auths = getAuthByParentId(parentId,authIds);
		//List<AuthVO> authList = new ArrayList<AuthVO>();
		for (AuthVO auth : auths) {
			/*AuthVO auth1 = new AuthVO();
			auth1.setId(auth.getAuthId());
			auth1.setText(auth.getAuthName());
			auth1.setIconCls(auth.getIconCls());*/
			if("open".equals(auth.getState())){
				continue;
			}else{
				List<AuthVO> authList1 = getAuthsByParentId(auth.getId(),authIds);
				auth.setChildren(authList1);
			}
			//authList.add(auth);
		}
		return auths;
	}
	
	public List<AuthVO> getCheckedAuthByParentId(int parentId,List<Integer> authIdList){
	
		List<Auth> auths = authDao.getCheckedAuthByParentId(parentId);
		List<AuthVO> authList = new ArrayList<AuthVO>();
		//String sql="select * from t_auth where parentId=? ";
		for (Auth auth : auths) {
			AuthVO auth1 = new AuthVO();
			auth1.setId(auth.getAuthId());
			auth1.setText(auth.getAuthName());
			auth1.setState(auth.getState());
			auth1.setIconCls(auth.getIconCls());
			/*if(ObjectUtil.existStrArr(auth.getAuthId()+"", authIds.split(","))){
				
				auth1.setChecked(true);
			}*/
			for (Integer authId : authIdList) {
				if(auth.getAuthId() == authId){
					auth1.setChecked(true);
				}
			}
			/*auth1.setAuthPath(auth.getAuthPath());
			authList.add(auth1);*/
			Map<String,Object> map1 = new HashMap<String,Object>();
			map1.put("authPath",auth.getAuthPath());
			auth1.setAttributes(map1);
			authList.add(auth1);
		}
		
		return authList;
	}
	
	public List<AuthVO> getCheckedAuthsByParentId(int parentId,List<Integer> authIdList){
		List<AuthVO> auths = this.getCheckedAuthByParentId(parentId,authIdList);
		//List<AuthVO> authList = new ArrayList<AuthVO>();
		for (AuthVO auth : auths) {
			
			/*auth1.setId(auth.getAuthId());
			auth1.setText(auth.getAuthName());
			auth1.setIconCls(auth.getIconCls());*/
			if("open".equals(auth.getState())){
				continue;
			}else{
				List<AuthVO> authList1 = getCheckedAuthsByParentId(auth.getId(),authIdList);
				auth.setChildren(authList1);
			}
		
		}
		return auths;
	}
	
	
	public List<AuthDataVO> getTreeGridAuthByParentId(int parentId){
		//String sql="select * from t_auth where parentId=? ";
		List<Auth> auths = authDao.getTreeGridAuthByParentId(parentId);
		List<AuthDataVO> authList = new ArrayList<AuthDataVO>();
		for (Auth auth : auths) {
			AuthDataVO auth1 = new AuthDataVO();
			auth1.setId(auth.getAuthId());
			auth1.setText(auth.getAuthName());
			auth1.setState(auth.getState());
			auth1.setIconCls(auth.getIconCls());
			auth1.setAuthPath(auth.getAuthPath());
			auth1.setAuthDescription(auth.getAuthDescription());
			//auth1.setAuthDescription();
			authList.add(auth1);
		}
		
		return authList;
	}
	
	public List<AuthDataVO> getListByParentId(int parentId){
		List<AuthDataVO> auths =this.getTreeGridAuthByParentId(parentId);
		for (AuthDataVO auth : auths) {
			if("open".equals(auth.getState())){
				continue;
			}else{
				auth.setChildren(getListByParentId(auth.getId()));
			}
		}
		return auths;
	}
	
	public int authAdd(Auth auth){
		//String sql="insert into t_auth values(null,?,?,?,?,'open',?)";
		return authDao.authAdd(auth);
	}
	
	public int authUpdate(Auth auth){
		//String sql="update t_auth set authName=?,authPath=?,authDescription=?,iconCls=? where authId=?";
		return authDao.authUpdate(auth);
	}
	
	public boolean isLeaf(String authId){
		//String sql="select * from t_auth where parentId=?";
		List<Auth> auths = authDao.isLeaf(authId);
		if(auths.size() == 0){
			return true;
		}
		return false;
		
	}
	
	public int updateStateByAuthId(String state,String authId){
		String sql="update t_auth set state=? where authId=?";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("state", state);
		map.put("authId", authId);
		int num = authDao.updateStateByAuthId(map);
		return num;
	}
	
	public int authDelete(String authId){
		//String sql="delete from t_auth where authId=?";
		return authDao.authDelete(authId);
		
	}
	
	public int getAuthCountByParentId(int parentId){
		//String sql="select count(*) as total from t_auth where parentId=?";
		return authDao.getAuthCountByParentId(parentId);
		
	}

	public int addRoleAuth(Integer athId, Integer rolId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("authId", athId);
		map.put("roleId", rolId);
		return authDao.addRoleAuth(map);
	}
	
	/**
	 * 删除角色与资源的对应关系
	 * @param authId
	 * @return
	 */
	public int deleteRoleAuthByAuthId(Integer authId) {
		return authDao.deleteRoleAuthByAuthId(authId);
	}

}
