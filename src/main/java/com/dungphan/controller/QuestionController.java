package com.dungphan.controller;

import com.dungphan.model.Question;
import com.dungphan.model.QuestionCategory;
import com.dungphan.model.QuestionPost;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class QuestionController {

	/**
	 * @param category
	 * @return
	 */
	@RequestMapping(value = "/enum-path/{code}", method = RequestMethod.GET)
	public List<Question> getEnumUsePathVariable(@PathVariable(value = "code") QuestionCategory category) {
		return getQuestionsByCategory(category);
	}

	/**
	 * @param category
	 * @return
	 */
	@RequestMapping(value = "/enum-param", method = RequestMethod.GET)
	public List<Question> getEnumUseRequestParam(@RequestParam(name = "code") QuestionCategory[] category) {
		List<Question> list = new ArrayList<>();
		for (QuestionCategory q : category) {
			list.addAll(getQuestionsByCategory(q));
		}
		return list;
	}

	/**
	 * @param questionPost
	 * @return
	 */
	@RequestMapping(value = "/enum-post", method = RequestMethod.POST)
	public List<Question> getEnumUsePost(@RequestBody QuestionPost questionPost) {
		List<Question> list = new ArrayList<>();
		if (Objects.nonNull(questionPost)) {
			for (QuestionCategory q : questionPost.getCategorys()) {
				list.addAll(getQuestionsByCategory(q));
			}
		}
		return list;
	}

	private List<Question> getQuestionsByCategory(QuestionCategory category) {
		List<Question> questions = new ArrayList<>();
		Question question = new Question();
		question.setType(category);
		if (category == QuestionCategory.CSE) {
			question.setQuestion("What is Operating System.");
			question.setAnswer("This is the answer of what is os.");
		} else if (category == QuestionCategory.ECE) {
			question.setQuestion("What is a transistor.");
			question.setAnswer("This is the answer of what is transistor.");
		}
		questions.add(question);
		return questions;
	}
}
