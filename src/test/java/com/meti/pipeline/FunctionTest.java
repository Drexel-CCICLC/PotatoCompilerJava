package com.meti.pipeline;

import com.meti.PotatoTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FunctionTest extends PotatoTest {
	@Test
	void test() {
		assertEquals("function a0(){}", compile("test={}"));
	}

	@Test
	void testWithParameters() {
		assertEquals("function a0(b1){}", compile("testWithParameters[value string]={}"));
	}

	@Test
	void testWithContent(){
		assertEquals("function a0(c2){var b1;b1=c2;}", compile("testWithContent[value string]={val other = value;}"));
	}
}
