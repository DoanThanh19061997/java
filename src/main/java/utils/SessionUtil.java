package utils;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil  {
     private static  SessionUtil  sessionUtil = null;

     public SessionUtil() {
     }
     public static  SessionUtil getSessionUtilIntance(){
          if (sessionUtil == null){
               sessionUtil = new SessionUtil();
          }
          return sessionUtil;
     }

     public static void xoaDL(HttpServletRequest request,String key){
          request.getSession().removeAttribute(key);
     }
     public void putValue(HttpServletRequest request, String key, Object value){
          request.getSession().setAttribute(key,value);
     }
     public static Object getValue(HttpServletRequest request, String key){
          return  request.getSession().getAttribute(key);
     }


}
