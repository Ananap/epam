package applic.parser;

public abstract class XMLParserFactory {
    public abstract XMLParser getXMLParser();

    public enum XMLParserType {
        DOM("applic.parser.dom.DomParserFactory"),
        SAX("applic.parser.sax.SAXParserFactory"),
        STAX("applic.parser.stax.StAXParserFactory");

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
