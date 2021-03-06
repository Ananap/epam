package by.panasenko.handling.action;

import by.panasenko.handling.comparator.ParagraphComparator;
import by.panasenko.handling.composite.TextComponent;
import by.panasenko.handling.composite.TextComposite;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortText {
	private static final Logger logger = LogManager.getLogger();

	public void sortBySentencesNumber(TextComposite text) {
		List<TextComponent> components = text.getComponents();
		List<TextComponent> copyOfComponents = new ArrayList<>(components);
		Collections.sort(copyOfComponents, new ParagraphComparator());
		text.setComponents(copyOfComponents);
		logger.log(Level.INFO, "composite sorted by sentence number: " + text);
	}
}
