package com.assignment.studentdao;

import java.util.List;

import com.assignment.model.Student;

public interface StudentDao {
	
	public boolean isvalidUser(String username,String password);
	public boolean registerStudent(Student student);
	public List<Student> getAllStudents();
	public boolean deleteStudent(int htno);
	public Student getStudent(int htno);
	public boolean updateStudent(Student student);
	
}
