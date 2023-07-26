package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.QuestionDAO;
import com.example.demo.models.Question;

@Service
public class QuestionService {

	@Autowired
	QuestionDAO questrepo;
	
	public List<Question> getAllQuestion(){
		
		return questrepo.findAll();
	}
	
	public Question addQuest(Question q) {
		
		questrepo.save(q);
		return q;
	}
	
	public Optional<Question> findById(int id) {
		
		return questrepo.findById(id);
	}
	
	public void deleteById(int id) {
		
		questrepo.deleteById(id);
		
	}
	
	
	
	public List<Question> getQuestion(String type, String diffLevel){
		return questrepo.getQuestion(type, diffLevel);
	}

	
}
