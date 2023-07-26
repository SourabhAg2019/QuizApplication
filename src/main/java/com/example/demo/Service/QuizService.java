package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.QuizDAO;
import com.example.demo.models.Question;
import com.example.demo.models.Quiz;
import com.example.demo.models.Response;
import com.example.demo.models.QuestionWrapper;


@Service
public class QuizService {

	@Autowired
	QuizDAO quizrepo;
	
	@Autowired
	QuestionService fetchData;
	
	
	public ResponseEntity<String> createQuiz(String type, String diffLevel) {
		// TODO Auto-generated method stub
		
		
		List<Question> list=fetchData.getQuestion(type, diffLevel);
		
		Quiz quiz=new Quiz();
		quiz.setDiffLevel(diffLevel);
		quiz.setType(type);
		quiz.setList(list);
		
		quizrepo.save(quiz);
		
		return new ResponseEntity<>("Created", HttpStatus.OK);
			
		
	}


	public ResponseEntity<List<QuestionWrapper>> getQuiz(int id) {
		// TODO Auto-generated method stub
		
		List<Question> list=quizrepo.findById(id).get().getList();
		
		List<QuestionWrapper> ans=new ArrayList<>();
		
		for(Question q: list) {
			QuestionWrapper wrp=new QuestionWrapper();
			wrp.setQues(q.getQues());
			wrp.setOptA(q.getOptA());
			wrp.setOptB(q.getOptB());
			
			ans.add(wrp);
		}
		
		return new ResponseEntity<>(ans, HttpStatus.OK);
		
	
	}


	public ResponseEntity<Integer> seeMarks(int id, List<Response> res) {
		// TODO Auto-generated method stub
		
		List<Question> list=quizrepo.findById(id).get().getList();
		int count=0;
		int i=0;
		for(Response r:res) {
			if(r.getAns().equals(list.get(i).getAns())){
				count++;
			}
			i++;
		}
		
		return new ResponseEntity<>(count, HttpStatus.OK);
	}
	
	

}
