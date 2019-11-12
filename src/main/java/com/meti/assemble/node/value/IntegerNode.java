package com.meti.assemble.node.value;

public class IntegerNode extends InlineValueNode<Integer> {
	IntegerNode(int value) {
		super(value);
	}

	@Override
	public String toString() {
		return "IntegerNode{" +
				"value=" + value +
				'}';
	}
}
