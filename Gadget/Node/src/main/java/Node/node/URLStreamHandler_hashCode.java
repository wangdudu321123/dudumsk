package Node.node;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class URLStreamHandler_hashCode {
    public static java.net.URLStreamHandler init_node(){
        java.net.URLStreamHandler handler = new SilentURLStreamHandler();
        return handler;
    }

    private static class SilentURLStreamHandler extends java.net.URLStreamHandler {
        protected URLConnection openConnection(URL u) throws IOException {
            return null;
        }
    }
}
