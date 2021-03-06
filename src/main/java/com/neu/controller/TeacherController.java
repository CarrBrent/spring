package com.neu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.neu.bean.Course;
import com.neu.bean.EvaluateKeys;
import com.neu.bean.EvaluationVo;
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
	
	@RequestMapping("findteacherbyid")
	public void Finduserbyid(@RequestParam("tId")String tId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONObject jsonObject=new JSONObject();  
		jsonObject.put("tId", "-1"); 
		out.print(jsonObject.toString());
		out.flush();
		out.close();
		System.out.println("findteacherbyid() tId : "+tId);
	}

	@RequestMapping("teacherlogin")
	public void Login(@RequestParam("tAccount")String tAccount,@RequestParam("tPwd")String tPwd,
			HttpServletRequest request,HttpServletResponse response) throws IOException{

		PrintWriter out = response.getWriter();
		JSONObject jsonObject=new JSONObject();  
		jsonObject.put("tId", "123"); 
		out.print(jsonObject.toString());
		out.flush();
		out.close();
		System.out.println("teacherlogin.do  SAccount : "+tAccount+"   SPwd : "+tPwd);
	}
	/**
	 * 
	 * @param TId
	 * @param request
	 * @param response
	 * @throws IOException
	 * 
	 * 当教师查找自己的课程列表时调用
	 * 
	 * 返回值  List<Course> myclass
	 * 
	 */

	@RequestMapping("findcoursebytid")
	public void findcoursebytid(@RequestParam("TId")String TId,
			HttpServletRequest request,HttpServletResponse response) throws IOException{

		/**
		 * 需要实现
		 * 在这里实现自己的代码，调用service层，查找TId的教师的所有课程。
		 */

		//定义response的各种参数
		response.setContentType("application/json");  
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		List<Course> myclass = new ArrayList<Course>();

		//需要实现
		//该处将查找出的Course添加到List中
		Course course = new Course(1,1,"#001","数据仓库","2016年第一学期","王老师");
		myclass.add(course);
		course = new Course(2,1,"#002","高级软件工程","2016年第二学期","王老师");
		myclass.add(course);
		course = new Course(3,1,"#003","数据结构","2016年第一学期","王老师");
		myclass.add(course);

		//该处将list转化成JsonString返回
		String opts = createJsonString("classes",myclass);
		out.print(opts);
		out.flush();
		out.close();
		//忽略该行，system.out用于测试，实际编码中不需要实现
		System.out.println("findcoursebytid.do  "+opts);
		//return "helloworld";
	}


	/**
	 * 
	 * @param CId
	 * @param request
	 * @param response
	 * @throws IOException
	 * 
	 * 查找某课程下的研讨课列表
	 * 返回数据 List<Seminar> seminars
	 * 
	 */
	@RequestMapping("findseminarbycid")
	public void findseminarbycid(@RequestParam("CId")String CId,HttpServletRequest request,HttpServletResponse response) throws IOException{

		/**
		 * 需要实现
		 * 在这里实现自己的代码，调用service层，查找CId的课程下的所有研讨课。
		 */

		//定义response的各种参数
		response.setContentType("application/json");  
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		List<Seminar> seminars = new ArrayList<Seminar>();

		//需要实现
		//该处将查找出的Seminar添加到List中
		Seminar seminar = new Seminar(1,1,1,"数据仓库","数据仓库研讨课1","第一课时","星期天",20,30,"王老师");
		seminars.add(seminar);
		seminar = new Seminar(2,1,1,"数据仓库","数据仓库研讨课2","第二课时","星期天",30,40,"王老师");
		seminars.add(seminar);
		seminar = new Seminar(3,1,1,"数据仓库","数据仓库研讨课3","第三课时","星期天",40,50,"王老师");
		seminars.add(seminar);

		//转化成JsonString
		String opts = createJsonString("seminars",seminars);
		out.print(opts);
		out.flush();
		out.close();
		//忽略该行，system.out用于测试，实际编码中不需要实现
		System.out.println("findseminarbycid.do  "+opts);
	}
	/**
	 * 
	 * @param seId
	 * @param request
	 * @param response
	 * @throws IOException
	 * 
	 * 查根据研讨课id查找已签到的学生列表
	 * 返回数据 List<Seminar> seminars
	 * 
	 */
	@RequestMapping("findsigninstudentsbyseid")
	public void findsigninstudentsbyseid(@RequestParam("seId")String seId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * 需要实现
		 * 在这里实现自己的代码，调用service层，查找seId的课程下的已签到的学生列表。
		 */

		//定义response的各种参数
		response.setContentType("application/json");  
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		//需要实现
		//该处将查找出的Student添加到List中
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


		//转化成JsonString
		String opts = createJsonString("students",students);
		out.print(opts);
		out.flush();
		out.close();
		//忽略该行，system.out用于测试，实际编码中不需要实现
		System.out.println("findsigninstudentsbyseid.do  "+opts);
	}

	/**
	 * 
	 * @param seId
	 * @param request
	 * @param response
	 * @throws IOException
	 * 分组方法
	 * 返回数据List<GroupVo> groups
	 */
	@RequestMapping("grouping")
	public void grouping(@RequestParam("seId")String seId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * 需要实现
		 * 在这里实现自己的代码，调用service层，对seId研讨课中的学生进行分组，并返回分组结果。
		 */

		//定义response的各种参数
		response.setContentType("application/json");  
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		List<GroupVo> groups = new ArrayList<GroupVo>();

		//需要实现
		//该处将查找出的GroupVo添加到List中
		GroupVo group = new GroupVo("1组","张三，王五，李四，赵六");
		groups.add(group);
		group = new GroupVo("2组","李四，王五，张三，赵六");
		groups.add(group);
		group = new GroupVo("3组","王五，张三，李四，赵六");
		groups.add(group);

		//转化成JsonString
		String gps = createJsonString("groups",groups);
		out.print(gps);
		out.flush();
		out.close();
		//忽略该行，system.out用于测试，实际编码中不需要实现
		System.out.println("grouping.do  "+gps);
	}
	/**
	 * 
	 * @param seId
	 * @param request
	 * @param response
	 * @throws IOException
	 * 
	 * 分组结果确认，教师进行分组之后如果对结果满意则进行确定，这时调用该方法
	 * 有可能需要添加标志位
	 * 无返回值
	 */
	@RequestMapping("groupsubmit")
	public void groupsubmit(@RequestParam("seId")String seId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * 需要实现
		 * 在这里实现自己的代码，调用service层的分组结果确认的方法，传入参数seId。
		 */

		//忽略该行，system.out用于测试，实际编码中不需要实现
		System.out.println("groupsubmit.do  "+seId);
	}
	/**
	 * 
	 * @param seId
	 * @param request
	 * @param response
	 * @throws IOException
	 * 组内评价开始，教师点击开始组内评价按钮时调用该方法
	 * 
	 * 有可能需要添加标志位
	 * 无返回值
	 */
	@RequestMapping("startingroupevaluate")
	public void startingroupevaluate(@RequestParam("seId")String seId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * 需要实现
		 * 在这里实现自己的代码，调用service层
		 */

		//忽略该行，system.out用于测试，实际编码中不需要实现
		System.out.println("startingroupevaluate.do  "+seId);
	}
	/**
	 * 
	 * @param seId
	 * @param request
	 * @param response
	 * @throws IOException
	 * 组内评价结束，组内评价倒计时结束时调用该方法 教师重置评价时间时调用该方法
	 * 
	 * 有可能需要添加标志位
	 * 无返回值
	 */
	@RequestMapping("endingroupevaluate")
	public void endingroupevaluate(@RequestParam("seId")String seId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * 需要实现
		 * 在这里实现自己的代码，调用service层
		 */

		//忽略该行，system.out用于测试，实际编码中不需要实现
		System.out.println("endingroupevaluate.do  "+seId);
	}
	/**
	 * 
	 * @param seId
	 * @param request
	 * @param response
	 * @throws IOException
	 * 
	 * 组间评价开始，教师点击开始组间评价按钮时调用该方法
	 * 
	 * 有可能需要添加标志位
	 * 无返回值
	 */
	@RequestMapping("startoutgroupevaluate")
	public void startoutgroupevaluate(@RequestParam("seId")String seId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * 需要实现
		 * 在这里实现自己的代码，调用service层
		 */

		//忽略该行，system.out用于测试，实际编码中不需要实现
		System.out.println("startoutgroupevaluate.do  "+seId);
	}
	/**
	 * 
	 * @param seId
	 * @param request
	 * @param response
	 * @throws IOException
	 * 组间评价结束，组间评价倒计时结束时调用该方法 教师重置评价时间时调用该方法
	 */
	@RequestMapping("endoutgroupevaluate")
	public void endoutgroupevaluate(@RequestParam("seId")String seId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * 需要实现
		 * 在这里实现自己的代码，调用service层
		 */

		//忽略该行，system.out用于测试，实际编码中不需要实现
		System.out.println("endoutgroupevaluate.do  "+seId);
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * 
	 * 没有传入参数，有可能需要改变
	 * 
	 * 查询当前投票题投票数据
	 * 
	 */
	@RequestMapping("getvotedata")
	public void getvotedata(@RequestParam("seId")String seId,@RequestParam("voteId")String voteId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * 需要实现
		 * 在这里实现自己的代码，调用service层，查询当前投票题投票数据。
		 */

		//定义response的各种参数
		response.setContentType("application/json");  
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		//需要实现
		//该处将查找出的投票数据添加到jsonObject中
		JSONObject jsonObject=new JSONObject();  
		jsonObject.put("A", 10); 
		jsonObject.put("B", 15); 
		jsonObject.put("C", 1); 
		jsonObject.put("D", 15); 



		out.print(jsonObject.toString());
		out.flush();
		out.close();
		//忽略该行，system.out用于测试，实际编码中不需要实现
		System.out.println("getvotedata.do  voteId:"+voteId+"seId"+seId+jsonObject.toString());
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * 投票开始，教师点击开始投票按钮时调用该方法
	 * 
	 * 有可能需要添加标志位
	 * 无返回值
	 */
	@RequestMapping("startvote")
	public void startvote(@RequestParam("seId")String seId,@RequestParam("correctAnswer")String correctAnswer,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * 需要实现
		 * 在这里实现自己的代码，调用service层
		 */
		//定义response的各种参数
		response.setContentType("application/json");  
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		//需要实现
		//该处将查找出的投票数据添加到jsonObject中
		JSONObject jsonObject=new JSONObject();  
		jsonObject.put("qvid", 10); 
		
		out.print(jsonObject.toString());
		out.flush();
		out.close();
		//忽略该行，system.out用于测试，实际编码中不需要实现
		System.out.println("startvote.do  correctAnswer:"+correctAnswer+"seId:"+seId);
	}
	@RequestMapping("endvote")
	public void endvote(@RequestParam("vqid")String vqid,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * 需要实现
		 * 在这里实现自己的代码，调用service层
		 */

		//忽略该行，system.out用于测试，实际编码中不需要实现
		System.out.println("endvote.do  vqid:"+vqid);
	}
	/**
	 * @param cId
	 * @param request
	 * @param response
	 * @throws IOException
	 * 
	 * 选课开始
	 * 有可能需要添加标志位
	 * 无返回值
	 */
	@RequestMapping("startcourseselect")
	public void startcourseselect(@RequestParam("cId")String cId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * 需要实现
		 * 在这里实现自己的代码，调用service层
		 */
		//忽略该行，system.out用于测试，实际编码中不需要实现
		System.out.println("startcourseselect.do   cId:"+cId);
	}
	/**
	 * @param cId
	 * @param request
	 * @param response
	 * @throws IOException
	 * 
	 * 选课结束
	 * 有可能需要添加标志位
	 * 无返回值
	 */
	@RequestMapping("endcourseselect")
	public void endcourseselect(@RequestParam("cId")String cId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * 需要实现
		 * 在这里实现自己的代码，调用service层
		 */
		//忽略该行，system.out用于测试，实际编码中不需要实现
		System.out.println("endcourseselect.do   cId:"+cId);
	}
	/**
	 * 
	 * @param cId
	 * @param request
	 * @param response
	 * @throws IOException
	 * 
	 * 查询研讨课选中的人数
	 * 
	 * 返回人数数据
	 */
	@RequestMapping("findseminarstudentsnumberbycid")
	public void findseminarstudentsnumberbycid(@RequestParam("cId")String cId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * 需要实现
		 * 在这里实现自己的代码，调用service层查找出选课的学生数
		 */
		//定义response的各种参数
		response.setContentType("application/json");  
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//需要实现
		//该处将查找出的学生数添加到List<SeminarStudentNo>中
		List<SeminarStudentNo> nos = new ArrayList<SeminarStudentNo>();
		SeminarStudentNo number = new SeminarStudentNo("数据仓库研讨课1",10);
		nos.add(number);
		number = new SeminarStudentNo("数据仓库研讨课2",20);
		nos.add(number);
		number = new SeminarStudentNo("数据仓库研讨课3",30);
		nos.add(number);

		//转化成JsonString
		String opts = createJsonString("numbers",nos);
		out.print(opts);
		out.flush();
		out.close();
		//忽略该行，system.out用于测试，实际编码中不需要实现
		System.out.println("findseminarstudentsnumberbycid.do  "+opts);
	}
	/**
	 * 
	 * @param seId
	 * @param request
	 * @param response
	 * @throws IOException
	 * 查找默认的限时练习题数量和时间，单位是秒，如果没有则设置为0
	 */
	@RequestMapping("findexerciseinfo")
	public void findexerciseinfo(@RequestParam("seId")String seId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * 需要实现
		 * 在这里实现自己的代码，调用service层查找默认的限时练习题数量和时间
		 */

		//定义response的各种参数
		response.setContentType("application/json");  
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		//需要实现
		//该处将查找出的数量和时间添加到jsonObject
		JSONObject jsonObject=new JSONObject();  
		jsonObject.put("number", 10); 
		jsonObject.put("time", 7); 


		out.print(jsonObject.toString());
		out.flush();
		out.close();
		//忽略该行，system.out用于测试，实际编码中不需要实现
		System.out.println("findexerciseinfo.do  "+jsonObject.toString());
	}
	/**
	 * 
	 * @param seId
	 * @param number
	 * @param request
	 * @param response
	 * @throws IOException
	 * 
	 * 开始限时答题
	 * 有可能需要标志位
	 */
	@RequestMapping("starttimelimitexercise")
	public void starttimelimitexercise(@RequestParam("seId")String seId,
			@RequestParam("number")String number,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * 需要实现
		 * 在这里实现自己的代码，调用service层
		 */

		//忽略该行，system.out用于测试，实际编码中不需要实现
		System.out.println("starttimelimitexercise.do  "+"seId:"+seId+"number:"+number);
	}
	/**
	 * 
	 * @param seId
	 * @param request
	 * @param response
	 * @throws IOException
	 * 结束限时答题
	 * 有可能需要标志位
	 */
	@RequestMapping("endtimelimitexercise")
	public void endtimelimitexercise(@RequestParam("seId")String seId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * 需要实现
		 * 在这里实现自己的代码，调用service层
		 */

		//忽略该行，system.out用于测试，实际编码中不需要实现
		System.out.println("endtimelimitexercise.do  "+"seId:"+seId);
	}
	/**
	 * 
	 * @param seId
	 * @param sId
	 * @param request
	 * @param response
	 * @throws IOException
	 * 
	 * 抢答题，确定答题学生
	 * 
	 */

	@RequestMapping("exerciserushsubmit")
	public void exerciserushsubmit(@RequestParam("rushId")String rushId,@RequestParam("seId")String seId,@RequestParam("sId")String sId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * 需要实现
		 * 在这里实现自己的代码，调用service层
		 */

		//忽略该行，system.out用于测试，实际编码中不需要实现
		System.out.println("exerciserushsubmit.do  "+rushId+"    "+seId+"    "+sId);
	}
	/**
	 * 
	 * @param seId
	 * @param request
	 * @param response
	 * @throws IOException
	 * 开始抢答
	 * 有可能需要标志位
	 */
	@RequestMapping("startexerciserush")//
	public void startexerciserush(@RequestParam("seId")String seId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * 需要实现
		 * 在这里实现自己的代码，调用service层开始抢答，返回学生信息
		 * 开始抢答功能开启之后，才能进行抢答，当出现同学抢答成功时，应该关闭抢答功能，并将学生信息返回，以上功能应该在service中实现
		 * 
		 */
		//定义response的各种参数
		response.setContentType("application/json");  
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		//需要实现
		//该处将查找出的学生信息添加到jsonObject
		JSONObject jsonObject=new JSONObject();  
		jsonObject.put("name","张三");  //jsonObject中的key不能改变只能修改value
		jsonObject.put("sId",1616); 
		jsonObject.put("rushId",666); 
		out.print(jsonObject.toString());
		out.flush();
		out.close();
		//忽略该行，system.out用于测试，实际编码中不需要实现
		System.out.println("startexerciserush.do  "+jsonObject.toString());
	}
	/**
	 * 
	 * @param seId
	 * @param request
	 * @param response
	 * @throws IOException
	 * 开始抢答
	 * 有可能需要标志位
	 */
	@RequestMapping("reexerciserush")//
	public void reexerciserush(@RequestParam("rushId")String rushId,@RequestParam("seId")String seId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * 需要实现
		 * 在这里实现自己的代码，调用service层开始抢答，返回学生信息
		 * 开始抢答功能开启之后，才能进行抢答，当出现同学抢答成功时，应该关闭抢答功能，并将学生信息返回，以上功能应该在service中实现
		 * 
		 */
		//定义response的各种参数
		response.setContentType("application/json");  
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		//需要实现
		//该处将查找出的学生信息添加到jsonObject
		JSONObject jsonObject=new JSONObject();  
		jsonObject.put("name","张三");  //jsonObject中的key不能改变只能修改value
		jsonObject.put("sId",16161); 
		jsonObject.put("rushId",555); 
		out.print(jsonObject.toString());
		out.flush();
		out.close();
		//忽略该行，system.out用于测试，实际编码中不需要实现
		System.out.println("reexerciserush.do  "+jsonObject.toString());
	}
	/**
	 * 
	 * @param seId
	 * @param request
	 * @param response
	 * @throws IOException
	 * 
	 * 根据研讨课Id查找给研讨课中的教师对学生评价信息的列表
	 * 有可能需要标志位
	 */
	@RequestMapping("findstudentsbyseid")
	public void findstudentsbyseid(@RequestParam("seId")String seId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * 需要实现
		 * 在这里实现自己的代码，调用service层查找教师对学生的评价信息
		 * 
		 */
		//定义response的各种参数
		response.setContentType("application/json");  
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		//将查询到的信息添加到List<StudentEvaluateVo> students
		List<StudentEvaluateVo> students = new ArrayList<StudentEvaluateVo>();
		StudentEvaluateVo stu = new StudentEvaluateVo(11001,"张三");
		students.add(stu);
		stu = new StudentEvaluateVo(11002,"李四");
		students.add(stu);
		stu = new StudentEvaluateVo(11003,"王五");
		students.add(stu);


		//转化成JsonString
		String opts = createJsonString("students",students);
		out.print(opts);
		out.flush();
		out.close();
		//忽略该行，system.out用于测试，实际编码中不需要实现
		System.out.println("findstudentsbyseid.do  "+opts);
	}
	/**
	 * 
	 * @param seId
	 * @param sId
	 * @param positivity
	 * @param communicate
	 * @param keypoint
	 * @param request
	 * @param response
	 * @throws IOException
	 * 提交教师评价信息
	 */
	@RequestMapping("teacherevaluatesubmit")
	public void teacherevaluatesubmit(
			@RequestParam("evaluations")String evaluations,
			HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * 需要实现
		 * 在这里实现自己的代码，调用service层submit教师评价信息
		 * 
		 */
		List<EvaluationVo> list = new ArrayList<EvaluationVo>();
		//Evaluation evaluation = new Evaluation();
		EvaluationVo evaluation;
		JSONObject jsonObject= JSONObject.fromObject(evaluations);
		JSONArray jsonArray = jsonObject.getJSONArray("evaluations");
		for (int i = 0; i < jsonArray.size(); i++) {  
			JSONObject jsonObject2 = jsonArray.getJSONObject(i);
			evaluation = new EvaluationVo(jsonObject2.getInt("seId"),jsonObject2.getInt("sId"),jsonObject2.getInt("eeId"),jsonObject2.getString("evalRank"));
			list.add(evaluation);
		}
		//忽略该行，system.out用于测试，实际编码中不需要实现
		System.out.println("teacherevaluatesubmit.do  "+evaluations);
	}
	/**
	 * 
	 * @param cId
	 * @param eeName
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("findteacherevaluatekeys")
	public void findteacherevaluatekeys(
			@RequestParam("cId")String cId,@RequestParam("eeName")String eeName,
			HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * 需要实现
		 * 在这里实现自己的代码，调用service层查找教师评价项目
		 * 
		 */
		//定义response的各种参数
		response.setContentType("application/json");  
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		//将查询到的信息添加到List<EvaluateKeys> students
		List<EvaluateKeys> keys = new ArrayList<EvaluateKeys>();
		EvaluateKeys key = new EvaluateKeys(1,"学习能力","");
		keys.add(key);
		key = new EvaluateKeys(2,"协作能力","");
		keys.add(key);
		key = new EvaluateKeys(3,"课堂积极性","");
		keys.add(key);

		//转化成JsonString
		String opts = createJsonString("keys",keys);
		out.print(opts);
		out.flush();
		out.close();

		//忽略该行，system.out用于测试，实际编码中不需要实现
		System.out.println("findteacherevaluatekeys.do  "+ opts+cId +eeName);
	}


	/**
	 * 
	 * @param key
	 * @param value
	 * @return
	 * 将Object转化成JsonString的方法
	 */
	public static String  createJsonString(String key,Object value){  

		JSONObject jsonObject=new JSONObject();  
		jsonObject.put(key, value);  
		return jsonObject.toString();  

	} 

}
