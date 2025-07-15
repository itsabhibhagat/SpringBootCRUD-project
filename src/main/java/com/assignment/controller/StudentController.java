package com.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.assignment.model.Student;
import com.assignment.studentservice.StudentService;

@Controller
//@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/")
	public String login() {
		return "login";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("/validate")
	public String validate(@RequestParam String username,
			@RequestParam String password, Model model) {
		if(studentService.isvalidUser(username, password)) {
			return "home";
		}
		else {
			return "login";
		}
	}
	//minor change
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	// @PostMapping
	@PostMapping("/addstudents")
	public String addStudent(
			@RequestParam("htno")int htno,
			@RequestParam("name")String name,
			@RequestParam("branch")String branch,
			@RequestParam("email")String email,
			Model model) {
		Student student = new Student(htno,name,branch,email);
		boolean result = studentService.registerStudent(student);
		if(result) {
			return "home";
		}
		else {
			return "register";
		}
	}
	
	@GetMapping("/display")
	public String display(Model model) {
		List<Student> students = studentService.getAllStudents();
		if (students.isEmpty()) {
            model.addAttribute("error", "No students found!");
        }
		model.addAttribute("Students", students);
//		System.out.println(students);
		return "display";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "login";
	}
	
	@GetMapping("/deleteStudent/{htno}")
	public String deleteStudent(@PathVariable int htno, Model model) {
		boolean result = studentService.deleteStudent(htno);
		if(result) {
			model.addAttribute("Students",studentService.getAllStudents());
			return "display";
		}
		else {
			model.addAttribute("error", "student not found");
			return "display";
		}
	}
	
	@GetMapping("/edit/{htno}")
	public String editStudent(@PathVariable int htno, Model model) {
		Student student = studentService.getStudent(htno);
		model.addAttribute("student", student);
		return "edit";
	}
	
	
	@PostMapping("/update/{htno}")
	public String updateStudent(@PathVariable int htno,
			@ModelAttribute Student student, Model model) {
		boolean flag = studentService.updateStudent(student);
		if(flag) {
			return "redirect:/display";
		}
		else {
			return "edit";
		}
	}
	
	@GetMapping("/search")
	public String searchPage() {
		return "search";
	}
	
	@GetMapping("/searchStudent")
	public String searchStudent(@RequestParam("htno") int htno,Model model) {
		Student student = studentService.getStudent(htno);
		if(student != null) {
			model.addAttribute("student", student);
			return "searchStudent";
		}
		else {
			model.addAttribute("error", "student not found");
			return "search";
		}
		
	}
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
}
