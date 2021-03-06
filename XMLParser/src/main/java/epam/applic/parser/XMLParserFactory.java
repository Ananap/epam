package epam.applic.parser;

public abstract class XMLParserFactory {
    public abstract XMLParser getXMLParser();

    public enum XMLParserType {
        DOM("epam.applic.parser.dom.DomParserFactory"),
        SAX("epam.applic.parser.sax.SaxParserFactory"),
        STAX("epam.applic.parser.stax.StaxParserFactory");

        private final String clazz;

        private XMLParserType(String clazz) {
            this.clazz = clazz;
        }
    }

    public static XMLParserFactory getInstance(XMLParserType type) {
        switch (type) {
            case DOM:
            case SAX:
            case STAX:
                try {
                    Class clazz = Class.forName(type.clazz);
                    return (XMLParserFactory) clazz.newInstance();
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            default:
                return null;
        }
    }
}
