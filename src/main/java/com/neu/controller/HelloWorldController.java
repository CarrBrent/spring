package com.neu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;











import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.neu.service.HelloService;

@Controller
public class HelloWorldController {

	@Autowired
	private HelloService helloService;

	@RequestMapping("helloworld")
	public void getNewName(@RequestParam("username")String username,HttpServletRequest request,HttpServletResponse response) throws IOException{
		String newUserName=helloService.getNewName(username);
		request.setAttribute("newUserName", newUserName);

		response.setContentType("application/json");  
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		List<HashMap<String, String>> myclass = new ArrayList<HashMap<String, String>>();
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("classname", "数据仓库");
		myclass.add(map);
		
		map = new HashMap<String, String>();
		map.put("classname", "机器学习");
		myclass.add(map);
		
		map = new HashMap<String, String>();
		map.put("classname", "数据结构");
		myclass.add(map);
		
		map = new HashMap<String, String>();
		map.put("classname", "软件重构技术");
		myclass.add(map);
		
		
		
		String opts = createJsonString("classes",myclass);
		out.print(opts);

		out.flush();
		out.close();
		System.out.println(opts);
		//return "helloworld";
	}
	@RequestMapping("login")
	public void Login(@RequestParam("SAccount")String SAccount,@RequestParam("SPwd")String SPwd,HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		out.print(SAccount);
		out.flush();
		out.close();
		System.out.println("SAccount : "+SAccount+"   SPwd : "+SPwd);
	}
	@RequestMapping("signin")
	public void Signin(@RequestParam("SId")String SId,@RequestParam("CId")String CId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		out.print(SId);
		out.print(CId);
		out.flush();
		out.close();
		System.out.println("SId : "+SId+"   CId : "+CId);
	}
	
	@RequestMapping("finduserbyid")
	public void Finduserbyid(@RequestParam("SId")String SId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		out.print(SId);
		out.flush();
		out.close();
		System.out.println("finduserbyid() SId : "+SId);
	}

	 public static String  createJsonString(String key,Object value){  
         
	        JSONObject jsonObject=new JSONObject();  
	        jsonObject.put(key, value);  
	        return jsonObject.toString();  
	          
	        } 

}
