package com.yingtongquan.zuul.filter;

import cn.hutool.crypto.symmetric.AES;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.netflix.zuul.http.ServletInputStreamWrapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class PerFilter extends ZuulFilter {


    @Override
    public String filterType() {
        //前置过滤器
        return "pre";
    }

    @Override
    public int filterOrder() {
        //优先级，数字越大，优先级越低
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //是否执行该过滤器，true代表需要过滤
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String servletPath = request.getServletPath();
        if (servletPath.contains("/v2/api-docs") || "/system/system/systemUser/addUser".equals(servletPath)
                || "/system/system/systemUser/getPhoneCheckCode".equals(servletPath) || "/system/system/systemUser/userLogin".equals(servletPath)
                || "/system/system/tblUserPo/encode".equals(servletPath) || "/system/system/tblUserPo/decode".equals(servletPath)
                || "/system/system/tblUserPo/upload".equals(servletPath)) {
            return null;
        }
        String requestBody = getRequestBody(request);
        System.out.println(requestBody);
        // 解密请求报文
//        String requestBodyMw = decode(requestBody);
//        Assert.isTrue(JSONUtil.isJson(requestBodyMw), "请求数据解密错误，请检查密文是否正确。");
        context.setRequest(new HttpServletRequestWrapper(request) {
            @Override
            public ServletInputStream getInputStream() throws IOException {
//                return new ServletInputStreamWrapper(requestBodyMw.getBytes());
                return new ServletInputStreamWrapper(requestBody.getBytes());
            }
        });
        //设置request请求头中的Content-Type为application/json，否则api接口模块需要进行url转码操作
        context.addZuulRequestHeader("Content-Type", MediaType.APPLICATION_JSON + ";charset=UTF-8");
        context.setSendZuulResponse(true);
        context.setResponseStatusCode(200);
        return null;
    }

    private static AES aes;

    static {
        aes = new AES("CBC", "PKCS5Padding", "81d3d6a45b08b86259caa3e338551e38".getBytes(), "5b08b86259caa3e3".getBytes());
    }

    public static AES getAes() {
        return aes;
    }

    /**
     * @Date 2020/4/25 17:55
     * @Author 胖虎
     * 解密
     **/

    private String decode(String content) {
        String s = aes.decryptStr(content);
        return s;
    }

    private String getRequestBody(HttpServletRequest req) {
        try {
            BufferedReader reader = req.getReader();
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            String json = sb.toString();
            return json;
        } catch (IOException e) {
            System.out.println("请求体读取失败" + e.getMessage());
        }
        return "";
    }

    private void writeResponse(ServletResponse response, String responseString)
            throws IOException {
        PrintWriter out = response.getWriter();
        out.print(responseString);
        out.flush();
        out.close();
    }


}
