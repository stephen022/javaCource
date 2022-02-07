package org.javacourse.xlassloader;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/**
 * @author zyb
 */
public class XlassLoader extends ClassLoader {

    private final String suffix = ".xlass";

    @Override
    protected Class<?> findClass(String fileName) throws ClassNotFoundException {

        int end = fileName.length();
        int start = 0 ;
        int pathLen = fileName.lastIndexOf(File.separator,start);
        if(pathLen != -1){
            start = pathLen + 1;
        }
        int fileNameLen = fileName.lastIndexOf(suffix,start);
        if(fileNameLen != -1){
            end = fileNameLen;
        }
        String className = fileName.substring(start,end);

        if(fileName.endsWith(suffix)){
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
            try {
                if(inputStream!=null) {
                    int length = inputStream.available();
                    byte[] byteArray = new byte[length];
                    int readLen = inputStream.read(byteArray);
                    byte[] decodeBytes = decode(byteArray);
                    return defineClass(className, decodeBytes, 0, readLen);
                }
                else{
                    return null;
                }
            } catch (IOException e) {
                throw new ClassNotFoundException(fileName, e);
            } finally {
                close(inputStream);
            }
        }
        else{
            return null;
        }
    }

    private byte[] decode(byte[] byteArray) {
        byte[] decodeByteArray = new byte[byteArray.length];
        for (int i = 0; i < byteArray.length; i++) {
            decodeByteArray[i] = (byte) (255 - byteArray[i]);
        }
        return decodeByteArray;
    }

    private void close(Closeable res) {
        if (null != res) {
            try {
                res.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {

        String fileName = "resources/Hello.xlass";

        ClassLoader classLoader = new XlassLoader();

        Class<?> clazz = classLoader.loadClass(fileName);

        Object instance = clazz.getDeclaredConstructor().newInstance();
        for (Method m : clazz.getDeclaredMethods()) {
            System.out.println(clazz.getSimpleName() + "has method:" + m.getName());
            m.invoke(instance);
        }

    }
}
