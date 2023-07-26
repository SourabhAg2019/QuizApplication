package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.QuizService;
import com.example.demo.models.Response;
import com.example.demo.models.QuestionWrapper;

@RestController
@RequestMapping("/")
public class quizController {
	
	@Autowired
	QuizService fetchQuiz;
	
	@PostMapping("createQuiz")
	public ResponseEntity<String> createQuiz(@RequestParam String type, @RequestParam String diffLevel) {
		
		//return new ResponseEntity<>("Success", HttpStatus.OK);
		return fetchQuiz.createQuiz(type, diffLevel);
	}
	
	
	@GetMapping("solveQuiz/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable int id){
		
		return fetchQuiz.getQuiz(id);
		
		
	}
	
	@PostMapping("getMarks/{id}")
	public ResponseEntity<Integer> seeMarks(@PathVariable int id, @RequestBody List<Response> res){
		
		return fetchQuiz.seeMarks(id, res);
	}
	
}

	