package com.util;

import android.os.Environment;
import android.util.Log;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author zjh
 * @date 2016/1/6
 * @desc 日志输出类
 */
public class SDLogUtil
{
    /**
     * 是否开启log
     */
    public final static boolean DEBUG = true;

    /**
     * 是否开启log
     */
    public final static boolean FLAG = DEBUG;
    /**
     * 发布时必须改成false
     */
    public final static boolean SAVE_LOG = FLAG;
    public final static LEVEL SAVE_LEVEL = LEVEL.INFO;

    public enum LEVEL
    {
        VERBOSE, DEBUG, INFO, WARN, ERROR;

        @Override
        public String toString()
        {
            switch (this)
            {
                case VERBOSE:
                    return "verbose";
                case DEBUG:
                    return "debug";
                case INFO:
                    return "info";
                case WARN:
                    return "warn";
                case ERROR:
                    return "error";
            }
            return "";
        }
    }

    /**
     * 测试log
     *
     * @param tag 标记
     * @param msg 信息
     */
    public static void showLog(String tag, String msg)
    {
        Log.d("测试Log---" + tag, msg);
    }

    /**
     * @param msg 消息
     * @Description: 打印info级别的日志，默认以使用此方法的类 不附带包名的类名作为 TAG。附带DeBug判断
     */
    public static void info(String msg)
    {
        if (FLAG)
        {
            StackTraceElement stackTrace = new Throwable().getStackTrace()[1];
            String head = stackTrace.getClassName() + "."
                    + stackTrace.getMethodName() + "()" + ";第"
                    + stackTrace.getLineNumber() + "行:";
            String className = stackTrace.getClassName();
            className = className.substring(className.lastIndexOf(".") + 1);

            if (msg != null)
            {
                Log.i(className, head + msg);
                saveLog(LEVEL.INFO, className, msg);
            }
        }
    }

    /**
     * @param tag 标签
     * @param msg 消息
     * @Description: 打印error级别的日志
     */
    public static void info(String tag, String msg)
    {
        if (FLAG)
        {
            StackTraceElement stackTrace = new Throwable().getStackTrace()[1];
            String head = stackTrace.getClassName() + "."
                    + stackTrace.getMethodName() + "()" + ";第"
                    + stackTrace.getLineNumber() + "行:";
            String className = stackTrace.getClassName();
            className = className.substring(className.lastIndexOf(".") + 1);
            if (tag == null || "".equals(tag.trim()))
            {
                tag = className;
            }

            if (msg != null)
            {
                Log.e(tag, head + msg);
//				saveLog(LEVEL.INFO, tag, msg);
            }
        }
    }

    public static void debug(String msg)
    {
        if (FLAG)
        {
            StackTraceElement stackTrace = new Throwable().getStackTrace()[1];
            String head = stackTrace.getClassName() + "."
                    + stackTrace.getMethodName() + "()" + ";第"
                    + stackTrace.getLineNumber() + "行:";
            String className = stackTrace.getClassName();
            className = className.substring(className.lastIndexOf(".") + 1);

            if (msg != null)
            {
                Log.d(className, head + msg);
//				saveLog(LEVEL.DEBUG, className, msg);
            }
        }
    }

    public static void debug(String tag, String msg)
    {
        if (FLAG)
        {
            StackTraceElement stackTrace = new Throwable().getStackTrace()[1];
            String head = stackTrace.getClassName() + "."
                    + stackTrace.getMethodName() + "()" + ";第"
                    + stackTrace.getLineNumber() + "行:";
            String className = stackTrace.getClassName();
            className = className.substring(className.lastIndexOf(".") + 1);
            if (tag == null || "".equals(tag.trim()))
            {
                tag = className;
            }

            if (msg != null)
            {
                Log.d(tag, head + msg);
//				saveLog(LEVEL.DEBUG, tag, msg);
            }
        }
    }

    /**
     * @param msg
     * @Description: 打印error级别的日志，默认以使用此方法的类的简单类名作为TAG
     */
    public static void error(String msg)
    {
        if (FLAG)
        {
            StackTraceElement stackTrace = new Throwable().getStackTrace()[1];
            String head = stackTrace.getClassName() + "."
                    + stackTrace.getMethodName() + "()" + ";第"
                    + stackTrace.getLineNumber() + "行:";
            String className = stackTrace.getClassName();
            className = className.substring(className.lastIndexOf(".") + 1);

            if (msg != null)
            {
                Log.e(className, head + msg);
//				saveLog(LEVEL.ERROR, className, msg);
            }
        }
    }

    /**
     * @param tag 标签
     * @param msg 消息
     * @Description: 打印error级别的日志
     */
    public static void error(String tag, String msg)
    {
        if (FLAG)
        {
            StackTraceElement stackTrace = new Throwable().getStackTrace()[1];
            String head = stackTrace.getClassName() + "."
                    + stackTrace.getMethodName() + "()" + ";第"
                    + stackTrace.getLineNumber() + "行:";
            String className = stackTrace.getClassName();
            className = className.substring(className.lastIndexOf(".") + 1);
            if (tag == null || "".equals(tag.trim()))
            {
                tag = className;
            }

            if (msg != null)
            {
                Log.e(tag, head + msg);
//				saveLog(LEVEL.ERROR, tag, msg);
            }
        }
    }

    /**
     * @param tag
     * @param msg
     * @Description: 打印warning级别的日志
     */
    public static void warn(String tag, String msg)
    {
        if (FLAG)
        {
            StackTraceElement stackTrace = new Throwable().getStackTrace()[1];
            String head = stackTrace.getClassName() + "."
                    + stackTrace.getMethodName() + "()" + ";第"
                    + stackTrace.getLineNumber() + "行:";
            String className = stackTrace.getClassName();
            className = className.substring(className.lastIndexOf(".") + 1);
            if (tag == null || "".equals(tag.trim()))
            {
                tag = className;
            }

            if (msg != null)
            {
                Log.w(tag, head + msg);
//				saveLog(LEVEL.WARN, tag, msg);
            }
        }
    }

    /**
     * @param msg
     * @Description: 打印warning级别的日志，默认以使用此方法的类的简单类名作为TAG
     */
    public static void warn(String msg)
    {
        if (FLAG)
        {
            StackTraceElement stackTrace = new Throwable().getStackTrace()[1];
            String head = stackTrace.getClassName() + "."
                    + stackTrace.getMethodName() + "()" + ";第"
                    + stackTrace.getLineNumber() + "行:";
            String className = stackTrace.getClassName();
            className = className.substring(className.lastIndexOf(".") + 1);

            if (msg != null)
            {
                Log.w(className, head + msg);
//				saveLog(LEVEL.WARN, className, msg);
            }
        }
    }

    public static void syso(String msg)
    {
        if (FLAG)
        {
            System.out.println(msg);
        }
    }

    /**
     * @return
     * @Description: 获取日志头信息，包含打印日志的类全路径名，行号，方法名称。
     */
    public static String getLogHeadInfo()
    {
        StackTraceElement stackTrace = new Throwable().getStackTrace()[1];
        String head = stackTrace.getClassName() + "."
                + stackTrace.getMethodName() + "()" + ";第"
                + stackTrace.getLineNumber() + "行:";
        return head;
    }

    /**
     * @return
     * @Description: 获取默认TAG，默认以类，简单名称作为TAG
     */
    public static String getDefaultTag()
    {
        StackTraceElement stackTrace = new Throwable().getStackTrace()[1];
        String className = stackTrace.getClassName();
        return className.substring(className.lastIndexOf("."));
    }


    public static void startMethodTracing(String name)
    {
        if (FLAG)
        {
            android.os.Debug.startMethodTracing(name);
        }
    }

    public static void stopMethodTracing()
    {
        if (FLAG)
        {
            android.os.Debug.stopMethodTracing();
        }
    }

    public static void saveLog(LEVEL level, String tag, String msg)
    {
        if (SAVE_LOG)
        {
            if (SAVE_LEVEL.ordinal() <= level.ordinal())
            {
               // saveLogToFile(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "cx", "supermarking.log"), tag, msg);
            }
        }
    }

//    public static void saveLogToFile(File file, String tag, String msg)
//    {
//        BufferedWriter bw = null;
//        try
//        {
//            if (!file.getParentFile().exists())
//            {
//                file.getParentFile().mkdirs();
//            }
//            bw = new BufferedWriter(new FileWriter(file, true));
//            bw.write(DateUtils.formatDate("yyyy-MM-dd HH:mm:ss", System.currentTimeMillis()) + " " + tag + " " + SAVE_LEVEL.toString() + " : " + msg + "\r\n");
//        } catch (IOException e)
//        {
//            e.printStackTrace();
//        } finally
//        {
//            if (bw != null)
//            {
//                try
//                {
//                    bw.close();
//                } catch (IOException e)
//                {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
}
