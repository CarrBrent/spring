package com.neu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.acl.Group;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.omg.CORBA.DATA_CONVERSION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.neu.bean.Course;
import com.neu.bean.GroupVo;
import com.neu.bean.Seminar;
import com.neu.bean.Student;
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

		Course course = new Course(1,1,"#001","数据仓库","2016年第一学期");
		myclass.add(course);
		
		course = new Course(2,1,"#002","高级软件工程","2016年第二学期");
		myclass.add(course);
		
		course = new Course(3,1,"#003","数据结构","2016年第一学期");
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
		
		Seminar seminar = new Seminar(1,1,"数据仓库研讨课1","第一课时",new Date(),20,30);
		seminars.add(seminar);
		
	    seminar = new Seminar(2,1,"数据仓库研讨课2","第二课时",new Date(),30,40);
		seminars.add(seminar);
		
		seminar = new Seminar(3,1,"数据仓库研讨课3","第三课时",new Date(),40,50);
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
		
		Student student = new Student(1,"123@126.com","123pwd","张全蛋","15040302010");
		students.add(student);
		
		student = new Student(2,"123@126.com","123pwd","李全蛋","15040302010");
		students.add(student);
		
		student = new Student(3,"123@126.com","123pwd","王全蛋","15040302010");
		students.add(student);
		
		student = new Student(3,"123@126.com","123pwd","王全蛋","15040302010");
		students.add(student);
		
		student = new Student(3,"123@126.com","123pwd","王全蛋","15040302010");
		students.add(student);
		
		student = new Student(3,"123@126.com","123pwd","王全蛋","15040302010");
		students.add(student);
		
		student = new Student(3,"123@126.com","123pwd","王全蛋","15040302010");
		students.add(student);
		
		student = new Student(3,"123@126.com","123pwd","王全蛋","15040302010");
		students.add(student);
		
		student = new Student(3,"123@126.com","123pwd","王全蛋","15040302010");
		students.add(student);
		
		student = new Student(3,"123@126.com","123pwd","王全蛋","15040302010");
		students.add(student);
		
		student = new Student(3,"123@126.com","123pwd","王全蛋","15040302010");
		students.add(student);
		
		student = new Student(3,"123@126.com","123pwd","王全蛋","15040302010");
		students.add(student);
		
		student = new Student(3,"123@126.com","123pwd","王全蛋","15040302010");
		students.add(student);
		
		student = new Student(3,"123@126.com","123pwd","王全蛋","15040302010");
		students.add(student);
		
		student = new Student(3,"123@126.com","123pwd","王全蛋","15040302010");
		students.add(student);
		
		student = new Student(3,"123@126.com","123pwd","王全蛋","15040302010");
		students.add(student);
		
		student = new Student(3,"123@126.com","123pwd","王全蛋","15040302010");
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
		
		GroupVo group = new GroupVo("1组","张三，王五，李四，赵六"+date.toString());
		groups.add(group);
		group = new GroupVo("2组","李四，王五，张三，赵六");
		groups.add(group);
		group = new GroupVo("3组","王五，张三，李四，赵六");
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

	public static String  createJsonString(String key,Object value){  

		JSONObject jsonObject=new JSONObject();  
		jsonObject.put(key, value);  
		return jsonObject.toString();  

	} 

}
