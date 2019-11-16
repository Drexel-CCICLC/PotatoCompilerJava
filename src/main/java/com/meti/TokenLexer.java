package com.meti;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TokenLexer implements Lexer<Token<?>> {
	private final List<? extends Tokenizer<?>> tokenizers;

	TokenLexer(List<? extends Tokenizer<?>> tokenizers) {
		this.tokenizers = tokenizers;
	}

	@Override
	public LexerOutput<Token<?>> lexise(LexerInput lexerInput) {
		var list = new ArrayList<Token<?>>();
		do {
			lexerInput.skipWhitespace();
			var optional = compute(lexerInput);
			if (optional.isPresent()) {
				lexerInput.advance();
				list.add(optional.get());
			} else {
				lexerInput.extend();
			}
		} while (lexerInput.hasMoreToScan());
		return new ListLexerOutput<>(list);
	}

	private Optional<? extends Token<?>> compute(LexerInput lexerInput) {
		return tokenizers.stream()
				.map(tokenizer -> tokenizer.match(lexerInput))
				.flatMap(Optional::stream)
				.findAny();
	}
}
