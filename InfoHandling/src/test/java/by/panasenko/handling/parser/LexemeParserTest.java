package by.panasenko.handling.parser;

import by.panasenko.handling.composite.ComponentType;
import by.panasenko.handling.composite.Symbol;
import by.panasenko.handling.composite.TextComposite;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LexemeParserTest extends Assert {
	TextComposite expectedResult;
	TextComposite actualResult;
	LexemeParser parser;
	String testText;

	@BeforeTest
	public void setUp() {
		parser = new LexemeParser();
		TextComposite lexeme1 = new TextComposite(ComponentType.LEXEME);
		TextComposite lexeme2 = new TextComposite(ComponentType.LEXEME);
		TextComposite lexeme3 = new TextComposite(ComponentType.LEXEME);
		TextComposite lexeme4 = new TextComposite(ComponentType.LEXEME);
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
		lexeme1.add(l1);
		lexeme1.add(l2);
		lexeme2.add(l3);
		lexeme2.add(l4);
		lexeme2.add(l5);
		lexeme2.add(l6);
		lexeme3.add(l7);
		lexeme3.add(l8);
		lexeme3.add(l9);
		lexeme3.add(l10);
		lexeme4.add(l11);
		lexeme4.add(l12);
		lexeme4.add(l13);
		lexeme4.add(l14);
		lexeme4.add(l15);
		lexeme4.add(l16);
		lexeme4.add(l17);
		expectedResult.add(lexeme1);
		expectedResult.add(lexeme2);
		expectedResult.add(lexeme3);
		expectedResult.add(lexeme4);
	}
	@Test
	public void testParse() {
		actualResult = new TextComposite();
		parser.parse(testText, actualResult);
		assertEquals(actualResult, expectedResult);
	}
}
