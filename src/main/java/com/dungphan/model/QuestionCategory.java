
package com.dungphan.model;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;

public enum QuestionCategory {

	CSE(1, "cse"), ECE(2, "ece");

	private int code;
	private String value;


	QuestionCategory(int code, String value) {
		this.code = code;
		this.value = value;
	}

	@JsonCreator
	public static QuestionCategory fromCode(int code) {
		for (QuestionCategory category : values()) {
			if (category.code == code) {
				return category;
			}
		}
		throw new IllegalArgumentException("Unknown enum type " + code + ", Allowed values are " + Arrays.toString(values()));
	}

}
