package by.panasenko.handling.parser;

import by.panasenko.handling.composite.ComponentType;
import by.panasenko.handling.composite.Symbol;
import by.panasenko.handling.composite.TextComposite;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SymbolParserTest extends Assert {
	TextComposite expectedResult;
	TextComposite actualResult;
	SymbolParser parser;
	String testText;

	@BeforeTest
	public void setUp() {
		parser = new SymbolParser();
		testText = "My dog, name -Cocos!";
		expectedResult = new TextComposite();
		Symbol l1 = new Symbol('M', ComponentType.SYMBOL);
		Symbol l2 = new Symbol('y', ComponentType.SYMBOL);
		Symbol l3 = new Symbol('d', ComponentType.SYMBOL);
		Symbol l4 = new Symbol('o', ComponentType.SYMBOL);
		Symbol l5 = new Symbol('g', ComponentType.SYMBOL);
		Symbol l6 = new Symbol(',', ComponentType.PUNCTUATION_MARK);
		Symbol l7 = new Symbol('n', ComponentType.SYMBOL);
		Symbol l8 = new Symbol('a', ComponentType.SYMBOL);
		Symbol l9 = new Symbol('m', ComponentType.SYMBOL);
		Symbol l10 = new Symbol('e', ComponentType.SYMBOL);
		Symbol l11 = new Symbol('-', ComponentType.PUNCTUATION_MARK);
		Symbol l12 = new Symbol('C', ComponentType.SYMBOL);
		Symbol l13 = new Symbol('o', ComponentType.SYMBOL);
		Symbol l14 = new Symbol('c', ComponentType.SYMBOL);
		Symbol l15 = new Symbol('o', ComponentType.SYMBOL);
		Symbol l16 = new Symbol('s', ComponentType.SYMBOL);
		Symbol l17 = new Symbol('!', ComponentType.PUNCTUATION_MARK);
		expectedResult.add(l1);
		expectedResult.add(l2);
		expectedResult.add(l3);
		expectedResult.add(l4);
		expectedResult.add(l5);
		expectedResult.add(l6);
		expectedResult.add(l7);
		expectedResult.add(l8);
		expectedResult.add(l9);
		expectedResult.add(l10);
		expectedResult.add(l11);
		expectedResult.add(l12);
		expectedResult.add(l13);
		expectedResult.add(l14);
		expectedResult.add(l15);
		expectedResult.add(l16);
		expectedResult.add(l17);
	}
	@Test
	public void parse() {
		actualResult = new TextComposite();
		parser.parse(testText, actualResult);
		assertEquals(actualResult, expectedResult);
	}
}
