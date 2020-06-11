package com.yingtongquan.zuul.component;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;

public class WrapperedRequest extends HttpServletRequestWrapper {

    private String requestBody = null; 
    HttpServletRequest req = null;
    
    public WrapperedRequest(HttpServletRequest request) {
        super(request);
        this.req = request;
    }
    
    public WrapperedRequest(HttpServletRequest request, String requestBody) {
        super(request);
        this.requestBody = requestBody;
        this.req = request;
    }

    /**
     * (non-Javadoc)
     *
     */
    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new StringReader(requestBody));
    }

    /**
     * (non-Javadoc)
     *
     */
    @Override
    public ServletInputStream getInputStream() throws IOException {
        return new ServletInputStream() {
            private InputStream in = new ByteArrayInputStream(
                    requestBody.getBytes(req.getCharacterEncoding()));
            @Override
            public int read() throws IOException {
                return in.read();
            }
            @Override
            public boolean isFinished() {
                return false;
            }
            @Override
            public boolean isReady() {
                return false;
            }
            @Override
            public void setReadListener(ReadListener readListener) {

            }
        };
    }
}