package com.meti.compile;

import java.util.Set;

public final class JSPotatoCompiler extends UnitCompiler {
	public static final Compiler INSTANCE = init();

	private JSPotatoCompiler(Set<? extends Unit> units, CompilerState state) {
		super(units, state);
	}

	private static Compiler init() {
		var units = Set.of(
				new JSFunctionUnit(),
				new JSInvocationUnit(),
				new JSValueUnit());
		var generator = new SimpleGenerator();
		var state = new InlineCompilerState(generator);
		return new JSPotatoCompiler(units, state);
	}
}
