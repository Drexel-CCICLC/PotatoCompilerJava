package com.meti.interpret;

import java.util.Set;

public final class PotatoInterpreter extends ListInterpreter {
	public static final Interpreter INSTANCE = init();

	private PotatoInterpreter(Loader root) {
		super(root);
	}

	private static Interpreter init() {
		var root = new CollectionLoader(Set.of(
				new InvocationLoader(),
				new FunctionLoader(),
				new ValueLoader()
		));
		return new PotatoInterpreter(root);
	}
}
