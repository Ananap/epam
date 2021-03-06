package by.panasenko.handling.parser;

import by.panasenko.handling.composite.ComponentType;
import by.panasenko.handling.composite.TextComposite;

public class ParagraphParser extends AbstractParser {
	private static final String PARAGRAPH_REGEX = "(?=(\\t))";
	private AbstractParser nextParser = new SentenceParser();
	@Override
	public void parse(String text, TextComposite textComposite) {
		String[] paragraphs = text.split(PARAGRAPH_REGEX);
		for(String paragraph: paragraphs) {
			TextComposite paragraphComposite = new TextComposite(ComponentType.PARAGRAPH);
			textComposite.add(paragraphComposite);
			nextParser.parse(paragraph,paragraphComposite);
		}
	}
}
