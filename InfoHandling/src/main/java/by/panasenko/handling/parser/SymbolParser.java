package by.panasenko.handling.parser;

import by.panasenko.handling.composite.ComponentType;
import by.panasenko.handling.composite.Symbol;
import by.panasenko.handling.composite.TextComponent;
import by.panasenko.handling.composite.TextComposite;

public class SymbolParser extends AbstractParser {
	private static final String PUNCTUATION_MARK_REGEX = "\\p{Punct}";
	private static final String BLANK_REGEX = "\\s";
	@Override
	public void parse(String text, TextComposite textComposite) {
		TextComponent symbol;
		char[] symbols = text.toCharArray();
		for (Character ch : symbols) {
			String str = ch.toString();
			if (!str.matches(BLANK_REGEX)) {
				if (str.matches(PUNCTUATION_MARK_REGEX)) {
					symbol = new Symbol(ch, ComponentType.PUNCTUATION_MARK);
				} else {
					symbol = new Symbol(ch, ComponentType.SYMBOL);
				}
				textComposite.add(symbol);
			}
		}
	}
}
