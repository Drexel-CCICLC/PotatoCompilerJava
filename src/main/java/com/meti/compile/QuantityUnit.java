package com.meti.compile;

import com.meti.interpret.statement.QuantityStatement;
import com.meti.interpret.statement.Statement;

public class QuantityUnit implements Unit {
	@Override
	public boolean canCompile(Statement statement) {
		return statement instanceof QuantityStatement;
	}

	@Override
	public String compile(Statement statement, Compiler compiler) {
		var quantity = (QuantityStatement) statement;
		var child = quantity.child();
		return "(" + compiler.compile(child) + ")";
	}
}
