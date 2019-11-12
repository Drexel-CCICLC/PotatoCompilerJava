package com.meti.compile;

import com.meti.interpret.statement.Statement;

public interface Unit {
	boolean canCompile(Statement statement);

	String compile(Statement statement, CompilerState state, Compiler compiler);
}
