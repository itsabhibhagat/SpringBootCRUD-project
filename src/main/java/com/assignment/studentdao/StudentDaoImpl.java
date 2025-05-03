package com.assignment.studentdao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assignment.model.Student;

@Service
public class StudentDaoImpl implements StudentDao {

	@Override
	public boolean isvalidUser(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteStudent(int htno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Student getStudent(int htno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

}
