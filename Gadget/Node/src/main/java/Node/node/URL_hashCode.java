package Node.node;

import Node.utils.Reflections;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLStreamHandler;

public class URL_hashCode {
    public static URL init_node(String url, URLStreamHandler handler) throws MalformedURLException {
        URL u = new URL(null, url,handler);
        return u;
    }

    public static void end_node(URL u) throws Exception {
        Reflections.setFieldValue(u, "hashCode", -1);
    }
}
