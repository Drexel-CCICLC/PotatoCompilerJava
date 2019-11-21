package com.meti.compile;

import com.meti.assemble.node.AllocNode;
import com.meti.assemble.node.IntNode;
import com.meti.assemble.node.VariableNode;
import com.meti.interpret.EvaluateInterpreter;
import com.meti.interpret.evaluate.AllocEvaluator;
import com.meti.interpret.evaluate.IntEvaluator;
import com.meti.interpret.evaluate.VariableEvaluator;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VariableUnitTest {

	@Test
	void compile() {
		var node = new VariableNode("test");
		var interpreter = new EvaluateInterpreter(
				Set.of(new VariableEvaluator()),
				Collections.emptySet()
		);
		var compiler = new UnitCompiler(new VariableUnit());
		var result = compiler.compile(interpreter.interpret(node));
		assertEquals("a0", result);
	}
}