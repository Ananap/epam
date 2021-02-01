package applic.utils;

public class ProjectUtils {

    public static <T> T checkNotNull(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException();
        }

        return obj;
    }
}
