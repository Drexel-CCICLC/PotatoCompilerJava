package com.meti.token;

public interface Token<T> {
	default <R> R valueAs(Class<R> clazz) {
		return clazz.cast(value());
	}

	TokenType type();

	T value();
}
