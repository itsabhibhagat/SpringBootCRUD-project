package com.assignment.studentdao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.assignment.model.Student;

@Repository("jdbc")
@Primary
public class StudentJdbcServiceImpl implements StudentDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public boolean isvalidUser(String username, String password) {
		// TODO Auto-generated method stub
		boolean isValid = false;
		if(username.equals("admin") && password.equals("admin")) {
			isValid = true;
		}
			
		return isValid;
	}

	@Override
	public boolean registerStudent(Student student) {
		// TODO Auto-generated method stub
		String sql = "insert into student values(?,?,?,?)";
		int k = jdbcTemplate.update(sql,student.getHtno(),student.getName(),student.getBranch(),student.getEmail());
		if(k>1) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		String sql = "select * from student";
		List<Student> students = jdbcTemplate.query(sql, (rs, rowNum)->{
			Student student = new Student();
			student.setHtno(rs.getInt(1));
			student.setName(rs.getString(2));
			student.setBranch(rs.getString(3));
			student.setEmail(rs.getString(4));
			return student;
		});
		return students;
	}

	
	@Override
	public Student getStudent(int htno) {
		// TODO Auto-generated method stub
		String sql = "select * from student where htno =?";
		Student student = jdbcTemplate.queryForObject(sql, (rs,rowNum)->{
			Student s = new Student();
			s.setHtno(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setBranch(rs.getString(3));
			s.setEmail(rs.getString(4));
			return s;
		},htno);
		return student;
	}

	@Override
	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		String sql = "update student set name = ?, branch = ?, email = ? where htno = ?";
		int k = jdbcTemplate.update(sql,student.getName(),student.getBranch(),student.getEmail(),student.getHtno());
		if(k>=1) {
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public boolean deleteStudent(int htno) {
		// TODO Auto-generated method stub
		String sql ="delete from student where htno = ?";
		int k = jdbcTemplate.update(sql, htno);
		if(k >= 1) {
			return true;
		}
		else {
			return false;
		}
	}

}
