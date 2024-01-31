package com.org.students.service;

import java.util.List;
import java.util.Random;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.students.dao.MyDetailsDao;
import com.org.students.dao.Mydao;
import com.org.students.dto.Student;
import com.org.students.dto.StudentDetails;
import com.org.students.exception.DataAlreadyExists;
import com.org.students.exception.InvalidCredentialsException;
import com.org.students.helper.MailSendingHelper;
import com.org.students.helper.MyResponseStructure;
import com.org.students.helper.RegisterHelper;


@Service
public class Myservice {

	@Autowired
	Mydao mydao;

	@Autowired
	MyResponseStructure<Student> structure1;

	@Autowired
	MyResponseStructure<RegisterHelper> structure3;

	@Autowired
	MyResponseStructure<List<Student>> structure2;
	
	@Autowired
	MyResponseStructure<List<StudentDetails>> structure5;
	
	@Autowired
	MyResponseStructure<StudentDetails> structure6;
	@Autowired
	StudentDetails details;
	
	@Autowired
	MyDetailsDao detailsDao;
	
	@Autowired
	MyResponseStructure<StudentDetails> structure4;
	
	@Autowired
    MailSendingHelper sendingHelper; 
     

	public MyResponseStructure<RegisterHelper> save(RegisterHelper registerHelper) {
		if (mydao.checkUserNameExists(registerHelper.getUsername())) {
			throw new DataAlreadyExists("Username Already Exists");
		} else {
			Student student=new Student();
			student.setUsername(registerHelper.getUsername());
			student.setPassword(registerHelper.getPassword());
			student.setToken(registerHelper.getUsername() + new Random().nextInt(100000, 999999999));
			mydao.save(student);
			structure3.setData(registerHelper);
			structure3.setMessage("Account Created Success");
			structure3.setStatus(HttpStatus.CREATED.value());
			return structure3;
		}
	}

	public MyResponseStructure<Student> login(RegisterHelper registerHelper) {
		Student student = mydao.findByUsername(registerHelper.getUsername());
		if (student == null)
			throw new InvalidCredentialsException("Invalid Username");
		else {
			if (student.getPassword().equals(registerHelper.getPassword())) {
				structure1.setData(student);
				structure1.setMessage("Login Success");
				structure1.setStatus(HttpStatus.FOUND.value());
				return structure1;
			} else {
				throw new InvalidCredentialsException("Invalid Password");
			}
		}
	}

	public MyResponseStructure<StudentDetails> details(StudentDetails details) {
		int total=details.getWeb()+details.getCorejava()+details.getAdvancejava()+details.getApti()+details.getMsql();
     double per=(total*100)/500;
     details.setTotal(total);
		
		details.setPercentage(per);
		if(details.getAdvancejava()<35 || details.getApti()<35 || details.getCorejava()<35 || details.getMsql()<35 || details.getWeb()<35) {
			 details.setResult("Fail");
		}else {
		if(details.getPercentage()>=85) {
			
			details.setResult("Distinction");
		}else if(details.getPercentage()>=60) {
			
			details.setResult("Firstclass");
		}else if(details.getPercentage()>=35) {
			
			details.setResult("Second class");
		}else {
			
			details.setResult("Fail");
		}
		}
	   structure4.setData(detailsDao.savedetails(details));
	   structure4.setMessage("Data saved Success");
	   structure4.setStatus(HttpStatus.CREATED.value());
	   return structure4;
	}

	public MyResponseStructure<List<StudentDetails>> fetchall() {
		List<StudentDetails> list=detailsDao.fetchall();
		structure5.setData(list);
		 structure5.setMessage("Data found");
		 structure5.setStatus(HttpStatus.FOUND.value());
		 return structure5;
		
	}

	public MyResponseStructure<StudentDetails> update(StudentDetails details2, int id) {
		StudentDetails details	=detailsDao.fetchbyid(id);
		
		
		if(details2.getStudentname()!=null)
			details.setStudentname(details2.getStudentname());
		if(details2.getStudentemail()!=null)
			details.setStudentemail(details2.getStudentemail());
		if(details2.getStudentphone()!=0)
			details.setStudentphone(details2.getStudentphone());
		if(details2.getWeb()!=0)
			details.setWeb(details2.getWeb());
		if(details2.getCorejava()!=0)
			details.setCorejava(details2.getCorejava());
		if(details2.getMsql()!=0)
			details.setMsql(details2.getMsql());
		if(details2.getAdvancejava()!=0)
			details.setAdvancejava(details2.getAdvancejava());
		if(details2.getApti()!=0)
			details.setApti(details2.getApti());
		
		
		int total=details.getWeb()+details.getCorejava()+details.getAdvancejava()+details.getApti()+details.getMsql();
	     double per=(total*100)/500;
	     details.setTotal(total);
			
			details.setPercentage(per);
			
			if(details.getAdvancejava()<35 || details.getApti()<35 || details.getCorejava()<35 || details.getMsql()<35 || details.getWeb()<35) {
				 details.setResult("Fail");
			}else {
			if(details.getPercentage()>=85) {
				
				details.setResult("Distinction");
			}else if(details.getPercentage()>=60) {
				
				details.setResult("Firstclass");
			}else if(details.getPercentage()>=35) {
				
				details.setResult("Second class");
			}else {
				
				details.setResult("Fail");
			}
			}
		   structure4.setData(detailsDao.savedetails(details));
		   structure4.setMessage("Data saved Success");
		   structure4.setStatus(HttpStatus.CREATED.value());
		   return structure4;
		
	}

	public MyResponseStructure<StudentDetails> delete(int id) {
		structure6.setData(detailsDao.fetchbyid(id));
		detailsDao.deleteById(id);
		structure6.setMessage("Data Deleted success");	
		structure6.setStatus(HttpStatus.OK.value());
		return structure6;
	}

	public MyResponseStructure<StudentDetails> sentemail(String studentemail) {
	    StudentDetails details=	detailsDao.fetchByEmail(studentemail);
	    sendingHelper.sendotp(details);
	    structure6.setData(details);
	    structure6.setMessage("email sent");
	    structure6.setStatus(HttpStatus.OK.value());
	    return structure6;
	
	}

	

}
