package com.neu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
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

import com.neu.bean.Course;
import com.neu.bean.Seminar;
import com.neu.service.HelloService;

@Controller
public class Teacher {

	@Autowired
	private HelloService helloService;

	@RequestMapping("findcoursebytid")
	public void findcoursebytid(@RequestParam("TId")String TId,HttpServletRequest request,HttpServletResponse response) throws IOException{

		response.setContentType("application/json");  
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		List<Course> myclass = new ArrayList<Course>();

		Course course = new Course(1,1,"#001","���ݲֿ�","2016���һѧ��");
		myclass.add(course);
		
		course = new Course(2,1,"#002","�߼��������","2016��ڶ�ѧ��");
		myclass.add(course);
		
		course = new Course(3,1,"#003","���ݽṹ","2016���һѧ��");
		myclass.add(course);

		String opts = createJsonString("classes",myclass);
		out.print(opts);

		out.flush();
		out.close();
		System.out.println(opts);
		//return "helloworld";
	}
	@RequestMapping("findseminarbycid")
	public void findseminarbycid(@RequestParam("CId")String CId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		response.setContentType("application/json");  
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		List<Seminar> seminars = new ArrayList<Seminar>();
		
		Seminar seminar = new Seminar(1,1,"���ݲֿ����ֿ�1","��һ��ʱ",new Date(),20,30);
		seminars.add(seminar);
		
	    seminar = new Seminar(2,1,"���ݲֿ����ֿ�2","�ڶ���ʱ",new Date(),30,40);
		seminars.add(seminar);
		
		seminar = new Seminar(3,1,"���ݲֿ����ֿ�3","������ʱ",new Date(),40,50);
		seminars.add(seminar);
		
		
		String opts = createJsonString("seminars",seminars);
		out.print(opts);
		
		out.flush();
		out.close();
		System.out.println(opts);
		//return "helloworld";
	}

	public static String  createJsonString(String key,Object value){  

		JSONObject jsonObject=new JSONObject();  
		jsonObject.put(key, value);  
		return jsonObject.toString();  

	} 

}
