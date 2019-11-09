package com.meti.lexeme;

import java.util.Optional;

public class SimpleLexerState implements LexerState {
	private final String value;
	private int beginning = 0;
	private int end = 1;

	SimpleLexerState(String value) {
		this.value = value;
	}

	@Override
	public void advance() {
		if (end == value.length()) {
			throw new IllegalStateException("Could not parse:\"" + compute() + "\"");
		} else end++;
	}

	@Override
	public String compute() {
		return value.substring(beginning, end);
	}

	@Override
	public boolean hasMoreCharacters() {
		return beginning != value.length();
	}

	@Override
	public void reset() {
		beginning = end;
		if (end != value.length()) end = beginning + 1;
	}

	@Override
	public void skipWhitespace() {
		if (beginning == value.length()) return;
		while (value.charAt(beginning) == ' ') {
			beginning++;
			end++;
		}
	}

	@Override
	public String trailing(int count) {
		int bound = Math.min(end + count, value.length());
		return value.substring(end, bound);
	}

	@Override
	public Optional<Character> trailing() {
		return end < value.length() ?
				Optional.of(value.charAt(end)) :
				Optional.empty();
	}

	@Override
	public String toString() {
		return "SimpleLexerState{" +
				"value=\'" + compute() + "\'" +
				'}';
	}
}
