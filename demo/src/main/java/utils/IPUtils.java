package utils;

import javax.servlet.http.HttpServletRequest;

public class IPUtils {
    public static String getVisitorIP(HttpServletRequest request){
        String remoteAddr = request.getRemoteAddr();
        String forwarded = request.getHeader("X-Forwarded-For");
        String realIP = request.getHeader("X-Real-IP");

        String ipAddress=null;
        if(realIP==null){
            if(forwarded==null){
                ipAddress=remoteAddr;
            }else{
                ipAddress=remoteAddr+"/"+forwarded.split(",")[0];
            }
        }else{
            if(realIP.equals(forwarded)){
                ipAddress=realIP;
            }else{
                if(forwarded!=null){
                    forwarded=forwarded.split(",")[0];
                }
                ipAddress=realIP+"/"+forwarded;
            }
        }
        return ipAddress;
    }
}
