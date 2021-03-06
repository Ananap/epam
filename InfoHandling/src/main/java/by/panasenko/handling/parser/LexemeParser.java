package by.panasenko.handling.parser;

import by.panasenko.handling.composite.ComponentType;
import by.panasenko.handling.composite.TextComposite;

public class LexemeParser extends AbstractParser {
	private static final String LEXEME_REGEX ="\\s"; 
	private AbstractParser nextParser = new SymbolParser();
	@Override
	public void parse(String sentence, TextComposite textComposite) {
		sentence = sentence.trim();
		String[] words = sentence.split(LEXEME_REGEX);
		for(String word: words) {
			TextComposite lexemeComposite = new TextComposite(ComponentType.LEXEME);
			textComposite.add(lexemeComposite);
			nextParser.parse(word,lexemeComposite);
		}
	}
}
