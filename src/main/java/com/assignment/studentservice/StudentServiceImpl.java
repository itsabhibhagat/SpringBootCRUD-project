package com.assignment.studentservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.model.Student;
import com.assignment.studentdao.StudentDao;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;
	
	@Override
	public boolean isvalidUser(String username, String password) {
		// TODO Auto-generated method stub
		return studentDao.isvalidUser(username, password);
	}

	@Override
	public boolean registerStudent(Student student) {
		// TODO Auto-generated method stub
		studentDao.registerStudent(student);
		return true;
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		List<Student> std = studentDao.getAllStudents();
		return std;
	}

	
	@Override
	public Student getStudent(int htno) {
		// TODO Auto-generated method stub
		return studentDao.getStudent(htno);
	}

	@Override
	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.updateStudent(student);
	}

	@Override
	public boolean deleteStudent(int htno) {
		// TODO Auto-generated method stub
		return studentDao.deleteStudent(htno);
	}

}
