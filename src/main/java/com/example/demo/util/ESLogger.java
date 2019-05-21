package com.example.demo.util;

/**
 * Author: leesanghyuk
 * Date: 2019-05-20 11:20
 * Description:日志工具类
 */

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


public class ESLogger {

    private static Logger log = LoggerFactory.getLogger(ESLogger.class);


    /*******************************log链式编程条件定义开始*******************************/
    //模块名称
    private String moduleName;
    //方法参数
    private Object methodPram;
    //返回结果集
    private Object returnResult;


    public ESLogger setModuleName(String moduleName) {
        this.moduleName = moduleName;
        return this;
    }


    public ESLogger setMethodPram(Object methodPram) {
        this.methodPram = methodPram;
        return this;
    }


    public ESLogger setReturnResult(Object returnResult) {
        this.returnResult = returnResult;
        return this;
    }
    /*******************************log链式编程条件定义结束*******************************/

    public static ESLogger init() {
        ESLogger nfsqlog = new ESLogger();
        return	nfsqlog.initLog();
    }

    public ESLogger initLog() {
        return this;
    }

    //日志信息组装
    public  String logInfo() {
        StringBuffer  str = new StringBuffer("");
        //模块名称
        if(this.moduleName!=null) {
            str.append("模块名称:").append(this.moduleName);
        }
        //传递参数
        if(this.methodPram!=null) {
            StringBuffer  pramStr = new StringBuffer("");
            if(this.methodPram instanceof HttpServletRequest){
                HttpServletRequest request=(HttpServletRequest) this.methodPram;
                Map<String, String[]> map = request.getParameterMap();
                String jsonstr = JSONObject.toJSONString(map);
                pramStr.append(jsonstr);
            }else {
                String jsonstr = JSONObject.toJSONString(this.methodPram);
                pramStr.append(jsonstr);
            }
            if(pramStr.length()>0) {
                str.append("，").append("方法参数:").append(pramStr);
            }
        }
        //返回参数
        if(this.returnResult!=null) {
            String jsonstr = JSONObject.toJSONString(this.returnResult);
            str.append("，").append("返回参数:");
            str.append(jsonstr);
        }

        if(str.toString().length()>0)
            return str.toString()+" ，";
        else
            return str.toString();

    }

    public void debug(String msg) {
        String logs = logInfo();
        log.debug(logs+"日志内容："+ msg);
    }


    public void debug(String format, Object arg) {
        String logs = logInfo();
        log.debug(logs+"日志内容："+ format,arg);
    }


    public void debug(String format, Object arg1, Object arg2) {
        String logs = logInfo();
        log.debug(logs+"日志内容："+ format, arg1,arg2);
    }


    public void debug(String format, Object... arguments) {
        String logs = logInfo();
        log.debug(logs+"日志内容："+ format,arguments);
    }


    public void debug(String msg, Throwable t) {
        String logs = logInfo();
        log.debug(logs+"日志内容："+ msg,t);
    }


    public void debug(Marker marker, String msg) {
        log.debug(marker,msg);
    }


    public void debug(Marker marker, String format, Object arg) {
        log.debug(marker,format,arg);
    }


    public void debug(Marker marker, String format, Object arg1, Object arg2) {
        log.debug(marker, format,  arg1,  arg2);
    }


    public void debug(Marker marker, String format, Object... arguments) {
        log.debug(marker, format, arguments);
    }


    public void debug(Marker marker, String msg, Throwable t) {
        log.debug(marker, msg, t);
    }

    public void info(String msg) {
        String logs = logInfo();
        log.info(logs+"日志内容："+ msg);
    }


    public void info(String format, Object arg) {
        String logs = logInfo();
        log.info(logs+"日志内容："+ format,arg);

    }


    public void info(String format, Object arg1, Object arg2) {
        String logs = logInfo();
        log.info(logs+"日志内容："+ format, arg1,arg2);
    }


    public void info(String format, Object... arguments) {
        String logs = logInfo();
        log.info(logs+"日志内容："+ format,arguments);
    }

    //打印异常的堆栈信息
    public void info(String msg, Throwable t) {
        String logs = logInfo();
        log.info(logs+"日志内容："+ msg,t);
    }

    public void info(Marker marker, String msg) {
        log.info(marker,msg);
    }


    public void info(Marker marker, String format, Object arg) {
        log.info(marker,format,arg);
    }


    public void info(Marker marker, String format, Object arg1, Object arg2) {
        log.info(marker,format,arg1,arg2);
    }


    public void info(Marker marker, String format, Object... arguments) {
        log.info(marker,format,arguments);
    }


    public void info(Marker marker, String msg, Throwable t) {
        log.info(marker,msg,t);
    }

    public void warn(String msg) {
        String logs = logInfo();
        log.warn(logs+"日志内容："+ msg);
    }


    public void warn(String format, Object arg) {
        String logs = logInfo();
        log.warn(logs+"日志内容："+ format,arg);
    }


    public void warn(String format, Object... arguments) {
        String logs = logInfo();
        log.warn(logs+"日志内容："+ format,arguments);
    }


    public void warn(String format, Object arg1, Object arg2) {
        String logs = logInfo();
        log.warn(logs+"日志内容："+ format, arg1,arg2);
    }


    public void warn(String msg, Throwable t) {
        String logs = logInfo();
        log.warn(logs+"日志内容："+ msg,t);
    }

    public void warn(Marker marker, String msg) {
        log.warn(marker,msg);
    }


    public void warn(Marker marker, String format, Object arg) {
        log.warn(marker,format,arg);
    }


    public void warn(Marker marker, String format, Object arg1, Object arg2) {
        log.warn(marker,format,arg1,arg2);
    }


    public void warn(Marker marker, String format, Object... arguments) {
        log.warn(marker,format,arguments);
    }


    public void warn(Marker marker, String msg, Throwable t) {
        log.warn(marker,msg,t);
    }


    public void error(String msg) {
        String logs = logInfo();
        log.error(logs+"日志内容："+ msg);
    }


    public void error(String format, Object arg) {
        String logs = logInfo();
        log.error(logs+"日志内容："+ format,arg);
    }


    public void error(String format, Object arg1, Object arg2) {
        String logs = logInfo();
        log.error(logs+"日志内容："+ format, arg1,arg2);
    }


    public void error(String format, Object... arguments) {
        String logs = logInfo();
        log.error(logs+"日志内容："+ format,arguments);
    }


    public void error(String msg, Throwable t) {
        String logs = logInfo();
        log.error(logs+"日志内容："+ msg,t);
    }

    public void error(Marker marker, String msg) {
        log.error(marker,msg);
    }


    public void error(Marker marker, String format, Object arg) {
        log.error(marker,format,arg);
    }


    public void error(Marker marker, String format, Object arg1, Object arg2) {
        log.error(marker,format,arg1,arg2);
    }


    public void error(Marker marker, String format, Object... arguments) {
        log.error(marker,format,arguments);

    }


    public void error(Marker marker, String msg, Throwable t) {
        log.error(marker,msg,t);
    }

}

