package Node.payload;


/**
 * @author mbechler
 *
 */
public interface ReleaseableObjectPayload<T> extends ObjectPayload<T> {

    void release(T obj) throws Exception;
}
