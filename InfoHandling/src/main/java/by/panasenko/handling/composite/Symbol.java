package by.panasenko.handling.composite;

import java.util.List;

public class Symbol implements TextComponent {
    private static final int SYMBOL_COUNTER = 1;
    private char value;
    private ComponentType type;

	public Symbol(char value, ComponentType componentType) {
    	this.value = value;
    	this.type=componentType;
    }
	@Override
	public void add(TextComponent c) {
		throw new UnsupportedOperationException("Operation not supported");
	}

	@Override
	public List<TextComponent> getComponents() {
		throw new UnsupportedOperationException("Operation not supported");
	}
	
	@Override
	public void setComponents(List<TextComponent> components) {
		throw new UnsupportedOperationException("Operation not supported");
	}
	@Override
	public int countSymbol() {
			return SYMBOL_COUNTER;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + value;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Symbol other = (Symbol) obj;
		if (type != other.type)
			return false;
		return value == other.value;
	}
	@Override
	public String toString() {
		return Character.toString(value);
	}
	@Override
	public ComponentType getType() {
		return type;
	}
}
