package com.neu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.acl.Group;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.util.JSONStringer;

import org.omg.CORBA.DATA_CONVERSION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.neu.bean.Course;
import com.neu.bean.GroupVo;
import com.neu.bean.Seminar;
import com.neu.bean.SeminarStudentNo;
import com.neu.bean.Student;
import com.neu.bean.StudentEvaluateVo;
import com.neu.service.HelloService;

@Controller
public class TeacherController {

	@Autowired
	private HelloService helloService;
	@RequestMapping("teacherlogin")
	public void Login(@RequestParam("tAccount")String tAccount,@RequestParam("tPwd")String tPwd,HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		out.print(tAccount);
		out.flush();
		out.close();
		System.out.println("teacherlogin.do  SAccount : "+tAccount+"   SPwd : "+tPwd);
	}

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
		System.out.println("findcoursebytid.do  "+opts);
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
		System.out.println("findseminarbycid.do  "+opts);
	}
	@RequestMapping("findsigninstudentsbyseid")
	public void findsigninstudentsbyseid(@RequestParam("seId")String seId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		response.setContentType("application/json");  
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		List<Student> students = new ArrayList<Student>();
		
		Student student = new Student(1,"123@126.com","123pwd","��ȫ��","15040302010");
		students.add(student);
		
		student = new Student(2,"123@126.com","123pwd","��ȫ��","15040302010");
		students.add(student);
		
		student = new Student(3,"123@126.com","123pwd","��ȫ��","15040302010");
		students.add(student);
		
		student = new Student(3,"123@126.com","123pwd","��ȫ��","15040302010");
		students.add(student);
		
		student = new Student(3,"123@126.com","123pwd","��ȫ��","15040302010");
		students.add(student);
		
		student = new Student(3,"123@126.com","123pwd","��ȫ��","15040302010");
		students.add(student);
		
		student = new Student(3,"123@126.com","123pwd","��ȫ��","15040302010");
		students.add(student);
		
		student = new Student(3,"123@126.com","123pwd","��ȫ��","15040302010");
		students.add(student);
		
		student = new Student(3,"123@126.com","123pwd","��ȫ��","15040302010");
		students.add(student);
		
		student = new Student(3,"123@126.com","123pwd","��ȫ��","15040302010");
		students.add(student);
		
		student = new Student(3,"123@126.com","123pwd","��ȫ��","15040302010");
		students.add(student);
		
		student = new Student(3,"123@126.com","123pwd","��ȫ��","15040302010");
		students.add(student);
		
		student = new Student(3,"123@126.com","123pwd","��ȫ��","15040302010");
		students.add(student);
		
		student = new Student(3,"123@126.com","123pwd","��ȫ��","15040302010");
		students.add(student);
		
		student = new Student(3,"123@126.com","123pwd","��ȫ��","15040302010");
		students.add(student);
		
		student = new Student(3,"123@126.com","123pwd","��ȫ��","15040302010");
		students.add(student);
		
		student = new Student(3,"123@126.com","123pwd","��ȫ��","15040302010");
		students.add(student);
		
		String opts = createJsonString("students",students);
		out.print(opts);
		
		out.flush();
		out.close();
		System.out.println("findsigninstudentsbyseid.do  "+opts);
	}
	@RequestMapping("grouping")
	public void grouping(@RequestParam("seId")String seId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("application/json");  
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		List<GroupVo> groups = new ArrayList<GroupVo>();
		Date date=new Date();
		
		GroupVo group = new GroupVo("1��","���������壬���ģ�����"+date.toString());
		groups.add(group);
		group = new GroupVo("2��","���ģ����壬����������");
		groups.add(group);
		group = new GroupVo("3��","���壬���������ģ�����");
		groups.add(group);
		
		
		String gps = createJsonString("groups",groups);
		
		out.print(gps);
		
		out.flush();
		out.close();
		System.out.println("grouping.do  "+gps);
	}
	@RequestMapping("groupsubmit")
	public void groupsubmit(@RequestParam("seId")String seId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		System.out.println("groupsubmit.do  "+seId);
	}
	@RequestMapping("startingroupevaluate")
	public void startingroupevaluate(@RequestParam("seId")String seId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		System.out.println("startingroupevaluate.do  "+seId);
	}
	@RequestMapping("endingroupevaluate")
	public void endingroupevaluate(@RequestParam("seId")String seId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		System.out.println("endingroupevaluate.do  "+seId);
	}
	@RequestMapping("startoutgroupevaluate")
	public void startoutgroupevaluate(@RequestParam("seId")String seId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		System.out.println("startoutgroupevaluate.do  "+seId);
	}
	@RequestMapping("endoutgroupevaluate")
	public void endoutgroupevaluate(@RequestParam("seId")String seId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		System.out.println("endoutgroupevaluate.do  "+seId);
	}
	@RequestMapping("getvotedata")
	public void getvotedata(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("application/json");  
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		JSONObject jsonObject=new JSONObject();  
		jsonObject.put("A", 10); 
		jsonObject.put("B", 15); 
		jsonObject.put("C", 1); 
		jsonObject.put("D", 15); 



		out.print(jsonObject.toString());

		out.flush();
		out.close();
		System.out.println("getvotedata.do  "+jsonObject.toString());
	}
	@RequestMapping("startvote")
	public void startvote(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		System.out.println("startvote.do  ");
	}
	@RequestMapping("startcourseselect")
	public void startcourseselect(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		System.out.println("startcourseselect.do  ");
	}
	@RequestMapping("findseminarstudentsnumberbycid")
	public void findseminarstudentsnumberbycid(@RequestParam("cId")String cId,HttpServletRequest request,HttpServletResponse response) throws IOException{

		response.setContentType("application/json");  
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		List<SeminarStudentNo> nos = new ArrayList<SeminarStudentNo>();

		SeminarStudentNo number = new SeminarStudentNo("���ݲֿ����ֿ�1",10);
		nos.add(number);
		
		number = new SeminarStudentNo("���ݲֿ����ֿ�2",20);
		nos.add(number);
		
		number = new SeminarStudentNo("���ݲֿ����ֿ�3",30);
		nos.add(number);

		String opts = createJsonString("numbers",nos);
		out.print(opts);

		out.flush();
		out.close();
		System.out.println("findseminarstudentsnumberbycid.do  "+opts);
	}
	@RequestMapping("findexerciseinfo")
	public void findexerciseinfo(@RequestParam("seId")String seId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("application/json");  
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		JSONObject jsonObject=new JSONObject();  
		jsonObject.put("number", 10); 
		jsonObject.put("time", 7); 


		out.print(jsonObject.toString());

		out.flush();
		out.close();
		System.out.println("findexerciseinfo.do  "+jsonObject.toString());
	}
	@RequestMapping("starttimelimitexercise")
	public void starttimelimitexercise(@RequestParam("seId")String seId,@RequestParam("time")String time,
			@RequestParam("number")String number,HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		System.out.println("starttimelimitexercise.do  "+"seId:"+seId+"time:"+time+"number:"+number);
	}
	@RequestMapping("endtimelimitexercise")
	public void endtimelimitexercise(@RequestParam("seId")String seId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		System.out.println("endtimelimitexercise.do  "+"seId:"+seId);
	}
	@RequestMapping("exerciserushsubmit")
	public void exerciserushsubmit(@RequestParam("seId")String seId,@RequestParam("sId")String sId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		System.out.println("exerciserushsubmit.do  "+seId +sId);
	}
	@RequestMapping("startexerciserush")//��ʼ�����ܿ���֮�󣬲��ܽ������𣬵�����ͬѧ����ɹ�ʱ��Ӧ�ùر������ܣ�����ѧ����Ϣ����
	public void startexerciserush(@RequestParam("seId")String seId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("application/json");  
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		JSONObject jsonObject=new JSONObject();  
		jsonObject.put("name","����"); 
		jsonObject.put("sId","16161616"); 


		out.print(jsonObject.toString());

		out.flush();
		out.close();
		System.out.println("startexerciserush.do  "+jsonObject.toString());
	}
	@RequestMapping("findstudentsbyseid")
	public void findstudentsbyseid(@RequestParam("seId")String seId,HttpServletRequest request,HttpServletResponse response) throws IOException{

		response.setContentType("application/json");  
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		List<StudentEvaluateVo> students = new ArrayList<StudentEvaluateVo>();

		StudentEvaluateVo stu = new StudentEvaluateVo(1,"����","No");
		students.add(stu);
		
		stu = new StudentEvaluateVo(2,"����","No");
		students.add(stu);
		
		stu = new StudentEvaluateVo(3,"����","No");
		students.add(stu);

		String opts = createJsonString("students",students);
		out.print(opts);

		out.flush();
		out.close();
		System.out.println("findstudentsbyseid.do  "+opts);
	}

	public static String  createJsonString(String key,Object value){  

		JSONObject jsonObject=new JSONObject();  
		jsonObject.put(key, value);  
		return jsonObject.toString();  

	} 

}
