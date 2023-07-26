package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.QuestionService;
import com.example.demo.models.Question;

@RestController
@RequestMapping("/")
public class questionController {
	
	
	@Autowired
	QuestionService fetchData;
	
	@GetMapping("questions")
	public List<Question> getQuestion(){
		
		return fetchData.getAllQuestion();
		
	}
	
	@PostMapping("add")
	public Question addQuestion(Question q) {
		
		return fetchData.addQuest(q);
		
	}
	
	@GetMapping("questions/{id}")
	public Optional<Question> getQuestion(@PathVariable int id){
		
		return fetchData.findById(id);
		
	}
	
	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable int id) {
		
		fetchData.deleteById(id);
		return "Success";
		
	}
	

}
