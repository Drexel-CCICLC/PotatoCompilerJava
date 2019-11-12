package com.meti.assemble.pattern;

import com.meti.assemble.AssemblyState;
import com.meti.assemble.node.AssemblyNode;
import com.meti.assemble.node.ContentArrayNode;
import com.meti.lexeme.match.format.ListMatch;
import com.meti.lexeme.match.format.SeparatorMatch;

import java.util.stream.Collectors;

public class ContentArrayPattern implements Pattern {
	@Override
	public boolean canAssemble(AssemblyState state) {
		return state.hasFirst(ListMatch.class) && state.getFirst(ListMatch.class).value() &&
				state.hasLast(ListMatch.class) && !state.getLast(ListMatch.class).value();
	}

	@Override
	public AssemblyNode assemble(AssemblyState state) {
		var content = state.sub(1, state.size() - 1);
		var states = content.split(SeparatorMatch.class);
		var subNodes = states.stream()
				.map(state.parent()::assemble)
				.collect(Collectors.toList());
		return new ContentArrayNode(subNodes);
	}
}
