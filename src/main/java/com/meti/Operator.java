package com.meti;

public enum Operator implements Valued<Character> {
	ADD('+');

	private final char value;

	Operator(char value) {
		this.value = value;
	}

	@Override
	public Character value() {
		return value;
	}
}
