package com.example.demo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Question;


@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer> {
	
	
	@Query(value="select * from Question q where q.type=:type AND q.diff_level=:diffLevel order by rand() LIMIT 2",
			nativeQuery=true)
	List<Question> getQuestion(String type, String diffLevel);

}
