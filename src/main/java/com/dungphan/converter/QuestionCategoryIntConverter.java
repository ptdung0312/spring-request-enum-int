package com.dungphan.converter;

import com.dungphan.model.QuestionCategory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QuestionCategoryIntConverter implements Converter<String, QuestionCategory> {
	@Override
	public QuestionCategory convert(String s) {
		try {
			int code = Integer.valueOf(s);
			return QuestionCategory.fromCode(code);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
