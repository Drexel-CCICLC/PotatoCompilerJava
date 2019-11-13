package com.meti.lexeme.match.struct;

import com.meti.lexeme.LexerState;
import com.meti.lexeme.match.Match;
import com.meti.lexeme.match.Matcher;

import java.util.Optional;

public class EndLineMatcher implements Matcher {
	@Override
	public Optional<Match<?>> build(LexerState state) {
		if(state.compute().equals(";")){
			return Optional.of(new EndLineMatch(state.depth().value()));
		}
		return Optional.empty();
	}
}
