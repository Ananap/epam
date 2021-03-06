package by.panasenko.handling.composite;

import java.util.List;

public interface TextComponent {
	void add(TextComponent component);
	void setComponents(List<TextComponent> components);
	List<TextComponent> getComponents();
	ComponentType getType();
	int countSymbol();
}
