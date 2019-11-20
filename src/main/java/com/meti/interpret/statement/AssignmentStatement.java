package com.meti.interpret.statement;

import com.meti.interpret.Variable;

public class AssignmentStatement implements Statement {
    private final Variable variable;
    private final Statement value;

    public AssignmentStatement(Variable variable, Statement value) {
        this.variable = variable;
        this.value = value;
    }

    public Variable variable() {
        return variable;
    }

    public Statement value() {
        return value;
    }
}
