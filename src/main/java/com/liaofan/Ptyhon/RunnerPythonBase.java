package com.liaofan.Ptyhon;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * java调用Python
 * 由于java调用Python是通过系统命令调用的，所以需要在系统命令路径下面添加Python的路径
 * 同时在windows下,json转换的时候需要加上单引号
 *
 * @author liaofan
 */
public class RunnerPythonBase {

    public static void main(String[] args) {
        List<String> paramList = new ArrayList<String>();
        paramList.add("http://www.baidu.com");
        //paramList.add("form");
        //paramList.add("class");
        //paramList.add("fm");
        //String content = JavaRunnerPython_Covert(paramList);
        //System.out.println(content);

        String PythonPath = "F:\\Python\\venv\\Scripts\\python.exe";
        //python脚本路径
        String pythonScriptPath = "F:\\Python_2\\Analysis.py";
        Map<String, String> paramMap = new HashMap<String, String>();


        //url
        paramMap.put("url", "http://www.baidu.com");
        //python路径
        paramMap.put("pythonPath", PythonPath);
        //python脚本路径
        paramMap.put("pythonScriptPath", pythonScriptPath);
        //选择器类型
        paramMap.put("selectortype", "id");
        //选择器id
        paramMap.put("selectorid", "lg");
        //标签
        paramMap.put("tag", "div");

        //callPython(PythonPath, pythonScriptPath, paramMap);
        callPython(paramMap);
    }


    public static String callPython(Map<String, String> paramMap) {
        checkInputRequire(paramMap);
        String PythonPath="";
        String pythonScriptPath="";
        //遍历map
        for (String key : paramMap.keySet()) {

            if(key.equals("pythonPath")){
                PythonPath = paramMap.get(key).toString();
            }

            if(key.equals("pythonScriptPath")){
                pythonScriptPath = paramMap.get(key).toString();
            }
        }


        String selectortype= paramMap.get("selectortype").toString();
        String selectorid= paramMap.get("selectorid").toString();
        String url = paramMap.get("url").toString();
        String tag = paramMap.get("tag").toString();

        List<String> paramList = new ArrayList<String>();

        paramList.add(url);
        paramList.add(tag);
        paramList.add(selectortype);
        paramList.add(selectorid);


        //String json = "{\"url\":\"" + url + "\",\"selectortype\":\"" + selectortype + "\",\"selectorid\":\"" + selectorid + "\"}";
        //  String[] args = new String[]{PythonPath, pythonScriptPath, json};


        System.out.println(JavaRunnerPython_Covert(PythonPath,pythonScriptPath,paramList));
       return JavaRunnerPython_Covert(PythonPath,pythonScriptPath,paramList);

    }


    /**
     * 检查输入参数是否完整
     * @param paramMap
     */
    public static void checkInputRequire(Map<String,String> paramMap){
        //检查参数是否完整
        for (String key : paramMap.keySet()) {
            if(paramMap.get(key)==null){
                throw new RuntimeException("参数不完整");
            }
        }
    }







    /**
     * 传入参数列表
     *
     * @param paramList
     * @return
     */
    public static String JavaRunnerPython_Covert(String PythonPath, String pythonScriptPath,List paramList) {
        //python解释器路径(后期可以改为配置文件)


        List<String> configList = new ArrayList<String>();
        //python路径
        configList.add(PythonPath);
        //python文件路径
        configList.add(pythonScriptPath);

        //遍历参数列表
        for (Object object : paramList) {
            //添加参数
            configList.add(object.toString());
        }

        //arraylist转换为数组
        String[] args = configList.toArray(new String[configList.size()]);
        return JavaRunnerPython(args);
    }

    /**
     * 传入参数列表
     *
     * @param paramList 参数列表
     * @return
     */
    public static String JavaRunnerPython_Covert() {
        List<String> configList = new ArrayList<String>();
        //python路径
        configList.add("F:\\Python\\venv\\Scripts\\python.exe");
        //python文件路径
        configList.add("F:\\Python_2\\Hello.py");

        //arraylist转换为数组
        String[] args = configList.toArray(new String[configList.size()]);
        return JavaRunnerPython(args);
    }


    /**
     * java调用Python
     *
     * @return
     * @author liaofan
     * @date 2022-05-10
     */
    public static String JavaRunnerPython(String[] args) {
        Process proc;
        StringBuffer sb = new StringBuffer();
        try {
        	/*
			附加：
			String[] args1=new String[]{"/home/huan/anaconda2/bin/python","/home/huan/myfile/pythonfile/helloword.py"};
            Process pr=Runtime.getRuntime().exec(args1);
			String数组里的那一行很重要
			首先一定要设置好你所使用的python的位置，切记不要直接使用python，因为系统会默认使用自带的python，所以一定要设置好你所使用的python的位置，否则可能会出现意想不到的问题（比如说我使用的是anaconda中的python，而ubuntu系统会默认调用自带的python，而我自带的python中并没有numpy库，所以会造成相应的代码不会执行的问题，所以设置好python的位置是很重要的）。还有就是要设置好py文件的位置，使用绝对路径。在这里插入代码片
                还有就是可以看出，此方法可以满足我们python代码   中调用第三方库的情况，简单实用。
			*/
            //这里是你的python文件的位置
            //String[] args = new String[]{"F:\\Python\\venv\\Scripts\\python.exe","F:\\Python_2\\Hello.py","1","2","3"};
            //执行python脚本
            proc = Runtime.getRuntime().exec(args);
            //获取python脚本的输出
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream(), StandardCharsets.UTF_8));
            //定义一个变量，用来存储python脚本的输出
            String line = null;
            //循环读取python脚本的输出
            while ((line = in.readLine()) != null) {
                //将python脚本的输出添加到变量sb中
                sb.append(line);
            }
            in.close();      //关闭流
            proc.waitFor();   //等待子进程结束
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
