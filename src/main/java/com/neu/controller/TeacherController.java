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
import com.neu.bean.EvaluateKeys;
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
	public void Login(@RequestParam("tAccount")String tAccount,@RequestParam("tPwd")String tPwd,
			HttpServletRequest request,HttpServletResponse response) throws IOException{

		PrintWriter out = response.getWriter();
		out.print(tAccount);
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
	 * ����ʦ�����Լ��Ŀγ��б�ʱ����
	 * 
	 * ����ֵ  List<Course> myclass
	 * 
	 */

	@RequestMapping("findcoursebytid")
	public void findcoursebytid(@RequestParam("TId")String TId,
			HttpServletRequest request,HttpServletResponse response) throws IOException{

		/**
		 * ��Ҫʵ��
		 * ������ʵ���Լ��Ĵ��룬����service�㣬����TId�Ľ�ʦ�����пγ̡�
		 */

		//����response�ĸ��ֲ���
		response.setContentType("application/json");  
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		List<Course> myclass = new ArrayList<Course>();

		//��Ҫʵ��
		//�ô������ҳ���Course��ӵ�List��
		Course course = new Course(1,1,"#001","���ݲֿ�","2016���һѧ��","����ʦ");
		myclass.add(course);
		course = new Course(2,1,"#002","�߼��������","2016��ڶ�ѧ��","����ʦ");
		myclass.add(course);
		course = new Course(3,1,"#003","���ݽṹ","2016���һѧ��","����ʦ");
		myclass.add(course);

		//�ô���listת����JsonString����
		String opts = createJsonString("classes",myclass);
		out.print(opts);
		out.flush();
		out.close();
		//���Ը��У�system.out���ڲ��ԣ�ʵ�ʱ����в���Ҫʵ��
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
	 * ����ĳ�γ��µ����ֿ��б�
	 * �������� List<Seminar> seminars
	 * 
	 */
	@RequestMapping("findseminarbycid")
	public void findseminarbycid(@RequestParam("CId")String CId,HttpServletRequest request,HttpServletResponse response) throws IOException{

		/**
		 * ��Ҫʵ��
		 * ������ʵ���Լ��Ĵ��룬����service�㣬����CId�Ŀγ��µ��������ֿΡ�
		 */

		//����response�ĸ��ֲ���
		response.setContentType("application/json");  
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		List<Seminar> seminars = new ArrayList<Seminar>();

		//��Ҫʵ��
		//�ô������ҳ���Seminar��ӵ�List��
		Seminar seminar = new Seminar(1,1,1,"���ݲֿ�","���ݲֿ����ֿ�1","��һ��ʱ","������",20,30,"����ʦ");
		seminars.add(seminar);
		seminar = new Seminar(2,1,1,"���ݲֿ�","���ݲֿ����ֿ�2","�ڶ���ʱ","������",30,40,"����ʦ");
		seminars.add(seminar);
		seminar = new Seminar(3,1,1,"���ݲֿ�","���ݲֿ����ֿ�3","������ʱ","������",40,50,"����ʦ");
		seminars.add(seminar);

		//ת����JsonString
		String opts = createJsonString("seminars",seminars);
		out.print(opts);
		out.flush();
		out.close();
		//���Ը��У�system.out���ڲ��ԣ�ʵ�ʱ����в���Ҫʵ��
		System.out.println("findseminarbycid.do  "+opts);
	}
	/**
	 * 
	 * @param seId
	 * @param request
	 * @param response
	 * @throws IOException
	 * 
	 * ��������ֿ�id������ǩ����ѧ���б�
	 * �������� List<Seminar> seminars
	 * 
	 */
	@RequestMapping("findsigninstudentsbyseid")
	public void findsigninstudentsbyseid(@RequestParam("seId")String seId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * ��Ҫʵ��
		 * ������ʵ���Լ��Ĵ��룬����service�㣬����seId�Ŀγ��µ���ǩ����ѧ���б�
		 */

		//����response�ĸ��ֲ���
		response.setContentType("application/json");  
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		//��Ҫʵ��
		//�ô������ҳ���Student��ӵ�List��
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


		//ת����JsonString
		String opts = createJsonString("students",students);
		out.print(opts);
		out.flush();
		out.close();
		//���Ը��У�system.out���ڲ��ԣ�ʵ�ʱ����в���Ҫʵ��
		System.out.println("findsigninstudentsbyseid.do  "+opts);
	}

	/**
	 * 
	 * @param seId
	 * @param request
	 * @param response
	 * @throws IOException
	 * ���鷽��
	 * ��������List<GroupVo> groups
	 */
	@RequestMapping("grouping")
	public void grouping(@RequestParam("seId")String seId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * ��Ҫʵ��
		 * ������ʵ���Լ��Ĵ��룬����service�㣬��seId���ֿ��е�ѧ�����з��飬�����ط�������
		 */

		//����response�ĸ��ֲ���
		response.setContentType("application/json");  
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		List<GroupVo> groups = new ArrayList<GroupVo>();

		//��Ҫʵ��
		//�ô������ҳ���GroupVo��ӵ�List��
		GroupVo group = new GroupVo("1��","���������壬���ģ�����");
		groups.add(group);
		group = new GroupVo("2��","���ģ����壬����������");
		groups.add(group);
		group = new GroupVo("3��","���壬���������ģ�����");
		groups.add(group);

		//ת����JsonString
		String gps = createJsonString("groups",groups);
		out.print(gps);
		out.flush();
		out.close();
		//���Ը��У�system.out���ڲ��ԣ�ʵ�ʱ����в���Ҫʵ��
		System.out.println("grouping.do  "+gps);
	}
	/**
	 * 
	 * @param seId
	 * @param request
	 * @param response
	 * @throws IOException
	 * 
	 * ������ȷ�ϣ���ʦ���з���֮������Խ�����������ȷ������ʱ���ø÷���
	 * �п�����Ҫ��ӱ�־λ
	 * �޷���ֵ
	 */
	@RequestMapping("groupsubmit")
	public void groupsubmit(@RequestParam("seId")String seId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * ��Ҫʵ��
		 * ������ʵ���Լ��Ĵ��룬����service��ķ�����ȷ�ϵķ������������seId��
		 */

		//���Ը��У�system.out���ڲ��ԣ�ʵ�ʱ����в���Ҫʵ��
		System.out.println("groupsubmit.do  "+seId);
	}
	/**
	 * 
	 * @param seId
	 * @param request
	 * @param response
	 * @throws IOException
	 * �������ۿ�ʼ����ʦ�����ʼ�������۰�ťʱ���ø÷���
	 * 
	 * �п�����Ҫ��ӱ�־λ
	 * �޷���ֵ
	 */
	@RequestMapping("startingroupevaluate")
	public void startingroupevaluate(@RequestParam("seId")String seId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * ��Ҫʵ��
		 * ������ʵ���Լ��Ĵ��룬����service��
		 */

		//���Ը��У�system.out���ڲ��ԣ�ʵ�ʱ����в���Ҫʵ��
		System.out.println("startingroupevaluate.do  "+seId);
	}
	/**
	 * 
	 * @param seId
	 * @param request
	 * @param response
	 * @throws IOException
	 * �������۽������������۵���ʱ����ʱ���ø÷��� ��ʦ��������ʱ��ʱ���ø÷���
	 * 
	 * �п�����Ҫ��ӱ�־λ
	 * �޷���ֵ
	 */
	@RequestMapping("endingroupevaluate")
	public void endingroupevaluate(@RequestParam("seId")String seId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * ��Ҫʵ��
		 * ������ʵ���Լ��Ĵ��룬����service��
		 */

		//���Ը��У�system.out���ڲ��ԣ�ʵ�ʱ����в���Ҫʵ��
		System.out.println("endingroupevaluate.do  "+seId);
	}
	/**
	 * 
	 * @param seId
	 * @param request
	 * @param response
	 * @throws IOException
	 * 
	 * ������ۿ�ʼ����ʦ�����ʼ������۰�ťʱ���ø÷���
	 * 
	 * �п�����Ҫ��ӱ�־λ
	 * �޷���ֵ
	 */
	@RequestMapping("startoutgroupevaluate")
	public void startoutgroupevaluate(@RequestParam("seId")String seId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * ��Ҫʵ��
		 * ������ʵ���Լ��Ĵ��룬����service��
		 */

		//���Ը��У�system.out���ڲ��ԣ�ʵ�ʱ����в���Ҫʵ��
		System.out.println("startoutgroupevaluate.do  "+seId);
	}
	/**
	 * 
	 * @param seId
	 * @param request
	 * @param response
	 * @throws IOException
	 * ������۽�����������۵���ʱ����ʱ���ø÷��� ��ʦ��������ʱ��ʱ���ø÷���
	 */
	@RequestMapping("endoutgroupevaluate")
	public void endoutgroupevaluate(@RequestParam("seId")String seId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * ��Ҫʵ��
		 * ������ʵ���Լ��Ĵ��룬����service��
		 */

		//���Ը��У�system.out���ڲ��ԣ�ʵ�ʱ����в���Ҫʵ��
		System.out.println("endoutgroupevaluate.do  "+seId);
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * 
	 * û�д���������п�����Ҫ�ı�
	 * 
	 * ��ѯ��ǰͶƱ��ͶƱ����
	 * 
	 */
	@RequestMapping("getvotedata")
	public void getvotedata(HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * ��Ҫʵ��
		 * ������ʵ���Լ��Ĵ��룬����service�㣬��ѯ��ǰͶƱ��ͶƱ���ݡ�
		 */

		//����response�ĸ��ֲ���
		response.setContentType("application/json");  
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		//��Ҫʵ��
		//�ô������ҳ���ͶƱ������ӵ�jsonObject��
		JSONObject jsonObject=new JSONObject();  
		jsonObject.put("A", 10); 
		jsonObject.put("B", 15); 
		jsonObject.put("C", 1); 
		jsonObject.put("D", 15); 



		out.print(jsonObject.toString());
		out.flush();
		out.close();
		//���Ը��У�system.out���ڲ��ԣ�ʵ�ʱ����в���Ҫʵ��
		System.out.println("getvotedata.do  "+jsonObject.toString());
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * ͶƱ��ʼ����ʦ�����ʼͶƱ��ťʱ���ø÷���
	 * 
	 * �п�����Ҫ��ӱ�־λ
	 * �޷���ֵ
	 */
	@RequestMapping("startvote")
	public void startvote(HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * ��Ҫʵ��
		 * ������ʵ���Լ��Ĵ��룬����service��
		 */

		//���Ը��У�system.out���ڲ��ԣ�ʵ�ʱ����в���Ҫʵ��
		System.out.println("startvote.do  ");
	}
	@RequestMapping("endvote")
	public void endvote(HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * ��Ҫʵ��
		 * ������ʵ���Լ��Ĵ��룬����service��
		 */
		
		//���Ը��У�system.out���ڲ��ԣ�ʵ�ʱ����в���Ҫʵ��
		System.out.println("endvote.do  ");
	}
	/**
	 * @param cId
	 * @param request
	 * @param response
	 * @throws IOException
	 * 
	 * ѡ�ο�ʼ
	 * �п�����Ҫ��ӱ�־λ
	 * �޷���ֵ
	 */
	@RequestMapping("startcourseselect")
	public void startcourseselect(@RequestParam("cId")String cId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * ��Ҫʵ��
		 * ������ʵ���Լ��Ĵ��룬����service��
		 */
		//���Ը��У�system.out���ڲ��ԣ�ʵ�ʱ����в���Ҫʵ��
		System.out.println("startcourseselect.do   cId:"+cId);
	}
	/**
	 * 
	 * @param cId
	 * @param request
	 * @param response
	 * @throws IOException
	 * 
	 * ��ѯ���ֿ�ѡ�е�����
	 * 
	 * ������������
	 */
	@RequestMapping("findseminarstudentsnumberbycid")
	public void findseminarstudentsnumberbycid(@RequestParam("cId")String cId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * ��Ҫʵ��
		 * ������ʵ���Լ��Ĵ��룬����service����ҳ�ѡ�ε�ѧ����
		 */
		//����response�ĸ��ֲ���
		response.setContentType("application/json");  
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//��Ҫʵ��
		//�ô������ҳ���ѧ������ӵ�List<SeminarStudentNo>��
		List<SeminarStudentNo> nos = new ArrayList<SeminarStudentNo>();
		SeminarStudentNo number = new SeminarStudentNo("���ݲֿ����ֿ�1",10);
		nos.add(number);
		number = new SeminarStudentNo("���ݲֿ����ֿ�2",20);
		nos.add(number);
		number = new SeminarStudentNo("���ݲֿ����ֿ�3",30);
		nos.add(number);

		//ת����JsonString
		String opts = createJsonString("numbers",nos);
		out.print(opts);
		out.flush();
		out.close();
		//���Ը��У�system.out���ڲ��ԣ�ʵ�ʱ����в���Ҫʵ��
		System.out.println("findseminarstudentsnumberbycid.do  "+opts);
	}
	/**
	 * 
	 * @param seId
	 * @param request
	 * @param response
	 * @throws IOException
	 * ����Ĭ�ϵ���ʱ��ϰ��������ʱ�䣬��λ���룬���û��������Ϊ0
	 */
	@RequestMapping("findexerciseinfo")
	public void findexerciseinfo(@RequestParam("seId")String seId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * ��Ҫʵ��
		 * ������ʵ���Լ��Ĵ��룬����service�����Ĭ�ϵ���ʱ��ϰ��������ʱ��
		 */

		//����response�ĸ��ֲ���
		response.setContentType("application/json");  
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		//��Ҫʵ��
		//�ô������ҳ���������ʱ����ӵ�jsonObject
		JSONObject jsonObject=new JSONObject();  
		jsonObject.put("number", 10); 
		jsonObject.put("time", 7); 


		out.print(jsonObject.toString());
		out.flush();
		out.close();
		//���Ը��У�system.out���ڲ��ԣ�ʵ�ʱ����в���Ҫʵ��
		System.out.println("findexerciseinfo.do  "+jsonObject.toString());
	}
	/**
	 * 
	 * @param seId
	 * @param time
	 * @param number
	 * @param request
	 * @param response
	 * @throws IOException
	 * 
	 * ��ʼ��ʱ����
	 * �п�����Ҫ��־λ
	 */
	@RequestMapping("starttimelimitexercise")
	public void starttimelimitexercise(@RequestParam("seId")String seId,@RequestParam("time")String time,
			@RequestParam("number")String number,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * ��Ҫʵ��
		 * ������ʵ���Լ��Ĵ��룬����service��
		 */

		//���Ը��У�system.out���ڲ��ԣ�ʵ�ʱ����в���Ҫʵ��
		System.out.println("starttimelimitexercise.do  "+"seId:"+seId+"time:"+time+"number:"+number);
	}
	/**
	 * 
	 * @param seId
	 * @param request
	 * @param response
	 * @throws IOException
	 * ������ʱ����
	 * �п�����Ҫ��־λ
	 */
	@RequestMapping("endtimelimitexercise")
	public void endtimelimitexercise(@RequestParam("seId")String seId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * ��Ҫʵ��
		 * ������ʵ���Լ��Ĵ��룬����service��
		 */

		//���Ը��У�system.out���ڲ��ԣ�ʵ�ʱ����в���Ҫʵ��
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
	 * �����⣬ȷ������ѧ��
	 * 
	 */

	@RequestMapping("exerciserushsubmit")
	public void exerciserushsubmit(@RequestParam("seId")String seId,@RequestParam("sId")String sId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * ��Ҫʵ��
		 * ������ʵ���Լ��Ĵ��룬����service��
		 */

		//���Ը��У�system.out���ڲ��ԣ�ʵ�ʱ����в���Ҫʵ��
		System.out.println("exerciserushsubmit.do  "+seId +sId);
	}
	/**
	 * 
	 * @param seId
	 * @param request
	 * @param response
	 * @throws IOException
	 * ��ʼ����
	 * �п�����Ҫ��־λ
	 */
	@RequestMapping("startexerciserush")//
	public void startexerciserush(@RequestParam("seId")String seId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * ��Ҫʵ��
		 * ������ʵ���Լ��Ĵ��룬����service�㿪ʼ���𣬷���ѧ����Ϣ
		 * ��ʼ�����ܿ���֮�󣬲��ܽ������𣬵�����ͬѧ����ɹ�ʱ��Ӧ�ùر������ܣ�����ѧ����Ϣ���أ����Ϲ���Ӧ����service��ʵ��
		 * 
		 */
		//����response�ĸ��ֲ���
		response.setContentType("application/json");  
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		//��Ҫʵ��
		//�ô������ҳ���ѧ����Ϣ��ӵ�jsonObject
		JSONObject jsonObject=new JSONObject();  
		jsonObject.put("name","����");  //jsonObject�е�key���ܸı�ֻ���޸�value
		jsonObject.put("sId","16161616"); 
		out.print(jsonObject.toString());
		out.flush();
		out.close();
		//���Ը��У�system.out���ڲ��ԣ�ʵ�ʱ����в���Ҫʵ��
		System.out.println("startexerciserush.do  "+jsonObject.toString());
	}
	/**
	 * 
	 * @param seId
	 * @param request
	 * @param response
	 * @throws IOException
	 * 
	 * �������ֿ�Id���Ҹ����ֿ��еĽ�ʦ��ѧ��������Ϣ���б�
	 * �п�����Ҫ��־λ
	 */
	@RequestMapping("findstudentsbyseid")
	public void findstudentsbyseid(@RequestParam("seId")String seId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * ��Ҫʵ��
		 * ������ʵ���Լ��Ĵ��룬����service����ҽ�ʦ��ѧ����������Ϣ
		 * 
		 */
		//����response�ĸ��ֲ���
		response.setContentType("application/json");  
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		//����ѯ������Ϣ��ӵ�List<StudentEvaluateVo> students
		List<StudentEvaluateVo> students = new ArrayList<StudentEvaluateVo>();
		StudentEvaluateVo stu = new StudentEvaluateVo(1,"����","No");
		students.add(stu);
		stu = new StudentEvaluateVo(2,"����","No");
		students.add(stu);
		stu = new StudentEvaluateVo(3,"����","No");
		students.add(stu);


		//ת����JsonString
		String opts = createJsonString("students",students);
		out.print(opts);
		out.flush();
		out.close();
		//���Ը��У�system.out���ڲ��ԣ�ʵ�ʱ����в���Ҫʵ��
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
	 * �ύ��ʦ������Ϣ
	 */
	@RequestMapping("teacherevaluatesubmit")
	public void teacherevaluatesubmit(
			@RequestParam("evaluations")String evaluations,
			HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * ��Ҫʵ��
		 * ������ʵ���Լ��Ĵ��룬����service��submit��ʦ������Ϣ
		 * 
		 */

		//���Ը��У�system.out���ڲ��ԣ�ʵ�ʱ����в���Ҫʵ��
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
		 * ��Ҫʵ��
		 * ������ʵ���Լ��Ĵ��룬����service����ҽ�ʦ������Ŀ
		 * 
		 */
		//����response�ĸ��ֲ���
		response.setContentType("application/json");  
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		//����ѯ������Ϣ��ӵ�List<EvaluateKeys> students
		List<EvaluateKeys> keys = new ArrayList<EvaluateKeys>();
		EvaluateKeys key = new EvaluateKeys(1,"ѧϰ����","");
		keys.add(key);
		key = new EvaluateKeys(2,"Э������","");
		keys.add(key);
		key = new EvaluateKeys(3,"���û�����","");
		keys.add(key);

		//ת����JsonString
		String opts = createJsonString("keys",keys);
		out.print(opts);
		out.flush();
		out.close();

		//���Ը��У�system.out���ڲ��ԣ�ʵ�ʱ����в���Ҫʵ��
		System.out.println("findteacherevaluatekeys.do  "+ opts+cId +eeName);
	}


	/**
	 * 
	 * @param key
	 * @param value
	 * @return
	 * ��Objectת����JsonString�ķ���
	 */
	public static String  createJsonString(String key,Object value){  

		JSONObject jsonObject=new JSONObject();  
		jsonObject.put(key, value);  
		return jsonObject.toString();  

	} 

}
