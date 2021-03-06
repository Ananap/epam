package by.panasenko.handling.comparator;

import by.panasenko.handling.composite.TextComponent;

import java.util.Comparator;

public class WordComparator implements Comparator<TextComponent> {
	@Override
	public int compare(TextComponent component1, TextComponent component2) {
		int lengthComponent1 = component1.countSymbol();
		int lengthComponent2 = component2.countSymbol();
		return lengthComponent1 - lengthComponent2;
	}
}
