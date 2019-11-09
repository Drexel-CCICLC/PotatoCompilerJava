package com.meti.lexeme.match;

import com.meti.lexeme.LexerState;

import java.util.Optional;

public class BooleanMatcher implements Matcher {
	@Override
	public Optional<Match<?>> build(LexerState state) {
		var value = state.compute();
		if (value.equals("true") || value.equals("false")) {
			return Optional.of(new BooleanMatch(Boolean.parseBoolean(value)));
		}
		return Optional.empty();
	}
}
