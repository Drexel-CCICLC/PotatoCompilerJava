package com.meti.assemble.node.value;

public class InlineStringNode extends InlineValueNode<String> {
	public InlineStringNode(String value) {
		super(value);
	}

	@Override
	public String toString() {
		return "StringNode{" +
				"value='" + value + '\'' +
				'}';
	}
}