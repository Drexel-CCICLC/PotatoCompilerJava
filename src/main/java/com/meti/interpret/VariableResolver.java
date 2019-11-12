package com.meti.interpret;

import com.meti.interpret.statement.InlineVariable;
import com.meti.interpret.statement.Statement;
import com.meti.interpret.type.Type;

public class VariableResolver implements com.meti.interpret.resolve.Resolver {
	@Override
	public boolean canResolve(Statement statement) {
		return statement instanceof InlineVariable;
	}

	@Override
	public Type resolve(Statement statement, Interpreter interpreter) {
		var variable = (InlineVariable) statement;
		var type = interpreter.variables().get(variable.name());
		if(type == null) {
			throw new IllegalArgumentException("Could not find declaration for variable \"" + variable.name() + "\"");
		}
		return type;
	}
}
