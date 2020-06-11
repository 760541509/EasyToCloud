package com.yingtongquan.startcommon.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * send post、get请求
 *
 * @author joe
 */
public class HttpRequest {
    private HttpURLConnection conn;
    private OutputStream os = null;
    private BufferedReader br = null;
    private String param = "";
    private String method = "";
    private String url = "";

    public HttpRequest(String url, String param, String method) {
       this.param = param;
       this.method = method;
       this.url = url;
    }

    /**
     * send request
     *
     * @return
     */
    public String send() {
        String res = "";
        if (method == "post") {
            res = sendPost();
        } else if (method == "get") {
            res = sendGet();
        } else {

        }
        return res;
    }

    private String sendGet() {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    private String getResponse() {
        String res = "";
        try {
            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            res = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    /*
     *   send post请求
     * @param url 发送请求的 URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public String sendPost() {
        String str = "";
        try {
            URL u = new URL(url);
            conn = (HttpURLConnection) u.openConnection();// 打开和URL之间的连接
            conn.setDoOutput(true); // 设置允许写出数据,默认是不允许 false
            conn.setDoInput(true);//当前的连接可以从服务器读取内容, 默认是true
            conn.setRequestMethod("POST");
            os = conn.getOutputStream(); // 获取URLConnection对象对应的输出流
            os.write(param.getBytes()); // 发送请求参数
            os.flush();
            str = getResponse();
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally {
            try {
                if (os != null) {
                    os.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return str;
    }
}
