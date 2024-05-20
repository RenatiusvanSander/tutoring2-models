package edu.remad.tutoring2.models;

public enum GenderEnum {

	MALE(0,"Herr" ),
	FEMALE(1,"Frau"),
	DIVERSE(2,"Divers");

	private final int genderNumber;
	private final String speech;
	
	GenderEnum(int i, String speech) {
		genderNumber = i;
		this.speech = speech;
	}

	public int getGenderNumber() {
		return genderNumber;
	}

	public String getSpeech() {
		return speech;
	}
}
