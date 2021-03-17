package com.xtt.lib.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description NetWorkUtil
 * @Author Monster
 * @Date 2021/3/17 10:10
 * @Version 1.0
 */
public class NetworkUtil {

    private static final String[] HEADERS_TO_TRY = {
            "X-Real-IP",        //Nginx请求头
            "Proxy-Client-IP",  // apache http服务器
            "WL-Proxy-Client-IP",
            "HTTP_CLIENT_IP",
            "HTTP_X_FORWARDED_FOR",
    };

    /**
     * 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址;
     *
     * @param request
     * @return
     */
    public final static String getIpAddress(HttpServletRequest request) {
        // 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址
        String ip = request.getHeader("X-Forwarded-For");
        if(StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)){
            for (String header : HEADERS_TO_TRY) {
                ip = request.getHeader(header);
                if(!StringUtils.isEmpty(ip) && !"unknown".equalsIgnoreCase(ip)){
                    break;
                }
            }
            if(StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)){
                ip = request.getRemoteAddr();
            }
        } else if (ip.length() > 15) {
            String[] ips = ip.split(",");
            for (String s : ips) {
                if (!("unknown".equalsIgnoreCase(s))) {
                    ip = s;
                    break;
                }
            }
        }
        return ip;
    }
}
