package com.bboss.action;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bboss.model.Manager;
import com.bboss.model.PageBean;
import com.bboss.service.ManagerService;
import com.bboss.service.RoleService;
import com.bboss.util.AESUtil;
import com.bboss.util.ECPConstants;
import com.bboss.util.JsonUtil;
import com.bboss.util.ObjectUtil;


/**
 * 权限管理系统登录用户的管理
 * @author admin
 *
 */
@Controller
@RequestMapping("/manager")
public class ManagerAction{

	
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private RoleService roleService;
	
	
	
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response){
		//HttpSession session= null;
		/*if(ObjectUtil.isNotEmpty(request.getSession(false))){
			//System.out.println(request.getSession(false).getId());
			return "main";
		}*/
		
		String managerName=request.getParameter("managerName");
		String password=request.getParameter("password");
		//String imageCode=request.getParameter("imageCode");
		//request.setAttribute("managerName", managerName);
		//request.setAttribute("password", password);
		//request.setAttribute("imageCode", imageCode);
		if(ObjectUtil.isEmpty(managerName)||ObjectUtil.isEmpty(password)){
			request.setAttribute("error", "账号或密码为空");
			return "login";
		}
		String passwordEcp = AESUtil.encrypt(password,ECPConstants.AesKey.AES_CODE);
		Manager manager=new Manager(managerName, passwordEcp);
		Manager sessionManager = (Manager) request.getSession(false).getAttribute("currentManager");
		//session中存有用户信息而且和上次登录的用户一致
		if(ObjectUtil.isNotEmpty(sessionManager) && sessionManager.equals(manager)){
			return "main";
		}
		Manager currentManager=managerService.login(manager);
		if(currentManager==null){
			request.setAttribute("error", "用户不存在");
			return "login";
		}else{
			String roleName=roleService.getRoleNameById(currentManager.getRoleId());
			currentManager.setRoleName(roleName);
			HttpSession session = request.getSession();
			String sessionId = session.getId();
			currentManager.setPassword(password);
			session.setAttribute("currentManager", currentManager);
			//session.
			//request.setAttribute("manager",manager);
			return "main";
		}
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response){
		//request.setCharacterEncoding("utf-8");
		request.getSession().invalidate();
		return "login";
		
	}
	
	@ResponseBody
	@RequestMapping("/modifyPassword")
	public String modifyPassword(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		String managerId=request.getParameter("managerId");
		String newPassword=request.getParameter("newPassword");
		newPassword  = AESUtil.encrypt(newPassword,ECPConstants.AesKey.AES_CODE);
		Manager manager=new Manager();
		manager.setManagerId(Integer.parseInt(managerId));
		manager.setPassword(newPassword);
		
		int updateNum=managerService.modifyPassword(manager);
		if(updateNum>0){
			jsonMap.put("success", true);
		}else{
			jsonMap.put("success", false);
			jsonMap.put("errorMsg", "修改失败");
		}
		return JsonUtil.object2Json(jsonMap);
	}
	
	@ResponseBody
	@RequestMapping("/list")
	public String list(HttpServletRequest request, HttpServletResponse response){
		//request.setCharacterEncoding("utf-8");
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		String page=request.getParameter("page");
		String rows=request.getParameter("rows");
		Manager manager = new Manager();
		String s_managerName=request.getParameter("s_managerName");
		String s_roleId=request.getParameter("s_roleId");
		if(ObjectUtil.isNotEmpty(s_managerName)){
			manager.setManagerName(s_managerName);
		}
		if(ObjectUtil.isNotEmpty(s_roleId)){
			manager.setRoleId(Integer.parseInt(s_roleId));
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		List<Manager> managers = managerService.managerList(pageBean,manager);
		int total = managerService.managerCount(manager);
		jsonMap.put("rows", managers);
		jsonMap.put("total", total);
		return JsonUtil.object2Json(jsonMap);
		
		
	}
	
	@ResponseBody
	@RequestMapping("/save")
	public String save(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		String managerName=request.getParameter("managerName");
		String password=request.getParameter("password");
		//密码加密
		password  = AESUtil.encrypt(password,ECPConstants.AesKey.AES_CODE);
		String roleId=request.getParameter("roleId");
		String userDescription=request.getParameter("userDescription");
		String managerId=request.getParameter("managerId");
		Manager manager = new Manager(managerName, password, Integer.parseInt(roleId), userDescription);
		if(ObjectUtil.isNotEmpty(managerId)){
			manager.setManagerId(Integer.parseInt(managerId));
		}
		int saveNums=0;
		if(ObjectUtil.isNotEmpty(managerId)){
			saveNums=managerService.managerUpdate(manager);
		}else{
			if(managerService.existManagerWithManagerName(managerName)){
				saveNums=-1;
			}else{
				saveNums=managerService.managerAdd(manager);					
			}
		}
		if(saveNums==-1){
			jsonMap.put("success", true);
			jsonMap.put("errorMsg", "用户存在");
		}else if(saveNums==0){
			jsonMap.put("success", true);
			jsonMap.put("errorMsg", "保存失败");
		}else{
			jsonMap.put("success", true);
		}
		return JsonUtil.object2Json(jsonMap);	
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		String delIds=request.getParameter("delIds");
		int delNums = managerService.managerDelete(delIds);
		if(delNums>0){
			jsonMap.put("success", true);
			jsonMap.put("delNums", delNums);
		}else{
			jsonMap.put("errorMsg", "删除失败");
		}
		return JsonUtil.object2Json(jsonMap);
	
		
	}		
	
}
