package br.com.jardimtech.brainlang.enums;

public enum TrainingDirection {
	Neutral(""),
	Left(""),
	Right(""),
	Top(""),
	Bottom("");
	
	String name;
	
	private TrainingDirection(String name) {
		this.name = name;
	}
	
	public String toName() {
		return this.name;
	}
}