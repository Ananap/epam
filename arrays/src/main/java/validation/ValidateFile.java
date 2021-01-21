package validation;

public class ValidateFile {

    public boolean validateString (String str) {
        String delimetr = " ";
        String[] subStr = str.split(delimetr);
        for (String s : subStr) {
            if (!isDigit(s)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        if(s == null) return false;
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
