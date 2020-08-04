package com.xn2001.college.common.base.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamUtils {

    private static int _buffer_size = 1024;

    /**
     * InputStream流转换成String字符串
     * @param inStream InputStream流
     * @param encoding 编码格式
     * @return String字符串
     */
    public static String inputStream2String(InputStream inStream, String encoding){
        String result = null;
        ByteArrayOutputStream outStream = null;
        try {
            if(inStream != null){
                outStream = new ByteArrayOutputStream();
                byte[] tempBytes = new byte[_buffer_size];
                int count = -1;
                while((count = inStream.read(tempBytes, 0, _buffer_size)) != -1){
                    outStream.write(tempBytes, 0, count);
                }
                tempBytes = null;
                outStream.flush();
                result = new String(outStream.toByteArray(), encoding);
                outStream.close();
            }
        } catch (Exception e) {
            result = null;
        } finally {
            try {
                if(inStream != null) {
                    inStream.close();
                    inStream = null;
                }
                if(outStream != null) {
                    outStream.close();
                    outStream = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
