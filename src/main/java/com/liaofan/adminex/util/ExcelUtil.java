package com.liaofan.adminex.util;



public class ExcelUtil {
//    /**
//     * 导出word-公共方法
//     *
//     * @param map      导出的数据Map
//     * @param fileName 导出的文件名称
//     * @param request  HttpServletRequest
//     * @param ftlName  模板文件名称(模板文件需要统一放置在WEB-INF\page\yajy\advise\temp")
//     * @return
//     * @throws Exception
//     */
//    public void exportWord_commonMap(Map<String, Object> map, String fileName, String ftlName, HttpServletRequest request) throws Exception {
////        ParamDTO dto = getDto();
//
//        Map<String, Object> exportMap = new HashMap<String, Object>();
//        for (Map.Entry<String, Object> entry : map.entrySet()) {
//            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//
//            String key = entry.getKey();
//            Object value = entry.getValue();
//
//            if (value == null) {
//                value = "";
//            }
//            exportMap.put(key, value);
//        }
//
//
//        Configuration configuration = new Configuration();
//        configuration.setDefaultEncoding("utf-8");
//        String strClassPath_root = getXmlPath();
//
//        //String srcPath = strClassPath_root.substring(0,strClassPath_root.lastIndexOf("\\webapp") -5);
//
//        // String strPath_ftl = strClassPath_root + "\\yajy\\WEB-INF\\classes\\template";
//
//        //String strPath_ftl = strClassPath_root + "page\\yajy\\advise\\template";
//
//        configuration.setClassForTemplateLoading(BascUtil.class, "/templates");
//
//
//        String strTime_haoMiao = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
//
//
//        String strPath_out = strClassPath_root + "\\basc\\WEB-INF\\classes\\temp";
//        // 输出文档路径及名称
//        String strFilePath = strPath_out + "\\exprotFile" + "_" + strTime_haoMiao + ".doc";
//
//        File outFile = new File(strFilePath);
//        new File(strPath_out).mkdirs();
//
//
//        //以utf-8的编码读取ftl文件
//        Template template = configuration.getTemplate(ftlName, "utf-8");
//        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"), 10240);
//        template.process(exportMap, out);
//        out.flush();
//        out.close();
//
//
//        downFile(strFilePath, fileName);
//        //outFile.delete();
//    }
//
//    /**
//     * 下载文件的公共类
//     *
//     * @param strPath
//     * @param strFileName
//     * @throws Exception 2018年3月19日
//     */
//    public void downFile(String strPath, String strFileName) throws Exception {
//        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//
//        OutputStream toClient = null;
//        File file = new File(strPath);
//        // 取得文件名。
//
//        String strFileName_driver = file.getName();
//        // 取得文件的后缀名。
//        String ext = strFileName_driver.substring(
//                strFileName_driver.lastIndexOf('.') + 1).toLowerCase();
//
//        String filename = strFileName + "." + ext;
//
//        // 以流的形式下载文件。
//
//
//        InputStream fis = new BufferedInputStream(new FileInputStream(
//                strPath));
//        byte[] buffer = new byte[fis.available()];
//        fis.read(buffer);
//        fis.close();
//        // 清空response
//        response.reset();
//
//        String new_filename = URLEncoder.encode(filename, "UTF8");
//        // 如果没有UA，则默认使用IE的方式进行编码，因为毕竟IE还是占多数的
//        String rtn = "filename=\"" + new_filename + "\"";
//        String userAgent = request.getHeader("User-Agent");
//        if (userAgent != null) {
//            userAgent = userAgent.toLowerCase();
//            // IE浏览器，只能采用URLEncoder编码
//            if (userAgent.indexOf("msie") != -1) {
//                rtn = "filename=\"" + new_filename + "\"";
//            }
//            // Opera浏览器只能采用filename*
//            else if (userAgent.indexOf("opera") != -1) {
//                rtn = "filename*=UTF-8''" + new_filename;
//            }
//            // Safari浏览器，只能采用ISO编码的中文输出
//            else if (userAgent.indexOf("safari") != -1) {
//                rtn = "filename=\""
//                        + new String(filename.getBytes("UTF-8"),
//                        "ISO8859-1") + "\"";
//            }
//            // Chrome浏览器，只能采用MimeUtility编码或ISO编码的中文输出
//            else if (userAgent.indexOf("applewebkit") != -1) {
//                new_filename = MimeUtility
//                        .encodeText(filename, "UTF8", "B");
//                rtn = "filename=\"" + new_filename + "\"";
//            }
//            // FireFox浏览器，可以使用MimeUtility或filename*或ISO编码的中文输出
//            else if (userAgent.indexOf("mozilla") != -1) {
//                rtn = "filename*=UTF-8''" + new_filename;
//            }
//        }
//        // 设置response的Header
//
//        response.addHeader("Content-Disposition", rtn);
//        response.addHeader("Content-Length", "" + file.length());
//
//        toClient = new BufferedOutputStream(response.getOutputStream());
//        response.setContentType("application/octet-stream");
//        toClient.write(buffer);
//        toClient.flush();
//        toClient.close();
//    }
//
//    /**
//     * 获取WEB-INF目录下面server.xml文件的路径
//     *
//     * @return
//     */
//    public static String getXmlPath() {
//        //file:/D:/JavaWeb/.metadata/.me_tcat/webapps/TestBeanUtils/WEB-INF/classes/
//        String path = Thread.currentThread().getContextClassLoader().getResource("/").toString();
//        path = path.replace('/', '\\'); // 将/换成\
//        path = path.replace("file:", ""); //去掉file:
//        path = path.replace("classes\\", ""); //去掉class\
//        path = path.substring(1); //去掉第一个\,如 \D:\JavaWeb...
//        //path+="server.xml";
//        //System.out.println(path);
//        return path;
//    }
//
//    public void poi_excel(String title, List<Map<String, Object>> list, HttpServletResponse response) throws IOException, ParseException {
//        HSSFWorkbook wb = new HSSFWorkbook();
//        HSSFSheet sheet = wb.createSheet(title);
//
//        //产生表格标题行
//        HSSFRow row = sheet.createRow(0);
//        HSSFCellStyle style = wb.createCellStyle();
//        style.setAlignment(HorizontalAlignment.CENTER);
//        HSSFCell cell = row.createCell(0);
//
//        cell.setCellValue("文件名称");
//        cell.setCellStyle(style);
//
//        cell = row.createCell((short) 1);
//        cell.setCellValue("来文单位");
//        cell.setCellStyle(style);
//
//        cell = row.createCell((short) 2);
//        cell.setCellValue("代拟部门");
//        cell.setCellStyle(style);
//
//        cell = row.createCell((short) 3);
//        cell.setCellValue("收文时间");
//        cell.setCellStyle(style);
//
//        cell = row.createCell((short) 4);
//        cell.setCellValue("分送时间");
//        cell.setCellStyle(style);
//
//        cell = row.createCell((short) 5);
//        cell.setCellValue("分送单位");
//        cell.setCellStyle(style);
//
//        cell = row.createCell((short) 6);
//        cell.setCellValue("要求反馈时间");
//        cell.setCellStyle(style);
//
//        cell = row.createCell((short) 7);
//        cell.setCellValue("联系人");
//        cell.setCellStyle(style);
//
//        cell = row.createCell((short) 8);
//        cell.setCellValue("联系电话");
//        cell.setCellStyle(style);
//
//        cell = row.createCell((short) 9);
//        cell.setCellValue("办理状态");
//        cell.setCellStyle(style);
//
//
//        for (int i = 0; i < list.size(); i++) {
//            //创建单元格，并赋值
//            row = sheet.createRow(i + 1);
//            Map<String, Object> map = list.get(i);
//            row.createCell((short) 0).setCellValue(judageNull(map.get("examinefilename")) + "");
//            row.createCell((short) 1).setCellValue(judageNull(map.get("comefrom")) + "");
//            row.createCell((short) 2).setCellValue(judageNull(map.get("substitution")) + "");
//            row.createCell((short) 3).setCellValue(dateFormat(map.get("receivedate") + ""));
//
//            if (map.get("operatortime") != null) {
//                row.createCell((short) 4).setCellValue(map.get("operatortime") + "");
//            } else {
//                row.createCell((short) 4).setCellValue("");
//            }
//
//
//            row.createCell((short) 5).setCellValue(judageNull(map.get("specialyab003name")) + "");
//            row.createCell((short) 6).setCellValue(dateFormat(map.get("feedbackdatelimit") + ""));
//            row.createCell((short) 7).setCellValue(judageNull(map.get("contactperson")) + "");
//            row.createCell((short) 8).setCellValue(judageNull(map.get("telephone")) + "");
//            row.createCell((short) 9).setCellValue(judageNull(map.get("handlestatusname")) + "");
//        }
//
//        OutputStream out = null;
//        out = response.getOutputStream();
//        String fileName = "市委规范性文件协助审查.xls";
//        response.setContentType("application/x-=msdownload");
//        response.setHeader("Content-Disposition", "attachment; filename="
//                + URLEncoder.encode(fileName, "UTF-8"));
//
//        wb.write(out);
//        out.close();
//    }
//
//
//    /**
//     * 使用POI将数据写入到Excel文件中
//     *
//     * @param title      //文件名称
//     * @param list       //需要导出的数据
//     * @param cellTitles //列名
//     * @param cellDates  //列名对应的数据
//     * @param response   //输出流
//     * @throws IOException
//     * @throws ParseException
//     */
//    public void poiExcelUtil(String title, List<Map<String, Object>> list, String[] cellTitles, String[] cellDates, HttpServletResponse response) throws IOException, ParseException {
//
//        int cellTitleLength = cellTitles.length;
//        int cellDateLength = cellDates.length;
//
//        if(cellTitleLength != cellDateLength){
//            throw new RuntimeException("列名和列名对应的数据长度不一致,请检查");
//        }
//
//        HSSFWorkbook wb = new HSSFWorkbook();
//        HSSFSheet sheet = wb.createSheet(title);
//
//        //产生表格标题行
//        HSSFRow row = sheet.createRow(0);
//        HSSFCellStyle style = wb.createCellStyle();     //样式对象
//        style.setAlignment(HorizontalAlignment.CENTER);   //水平居中
//
//        HSSFCell cell = null;
//        for (int i = 0; i < cellTitles.length; i++) {
//            cell = row.createCell((short) i);     //创建单元格
//            cell.setCellValue(cellTitles[i]);      //设置单元格的值
//            cell.setCellStyle(style);             //设置单元格样式
//        }
//
//        for (int i = 0; i < list.size(); i++) {
//            //创建单元格，并赋值
//            row = sheet.createRow(i + 1);     //创建行
//            Map<String, Object> map = list.get(i);    //获取map对象
//
//            for (int j = 0; j < cellDates.length; j++) {
//                System.out.println(cellDates[j]);
//                row.createCell((short) j).setCellValue(judageNull(map.get(cellDates[j])) + "");   //设置单元格的值
//            }
//
//        }
//
//        OutputStream out = null;
//        out = response.getOutputStream();     //输出流
//        //设置文件名
//        String fileName = title;
//
//        response.setContentType("application/x-=msdownload");  //设置为下载application/x-msdownload
//        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));  //设置文件名
//        wb.write(out);  //写入文件
//        out.close();   //关闭输出流
//    }
//
//    public Object judageNull(Object o) throws ParseException {
//        if (o == null) {
//            o = "";
//        }
//
//        if (isValidDate(o + "")) {
//            o = dateFormat(o.toString());
//        }
//
//
//        return o;
//    }
//
//    public static boolean isValidDate(String str) {
//        boolean convertSuccess = true;// 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        try {
//            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
//            format.setLenient(false);
//            format.parse(str);
//        } catch (ParseException e) {
//            // e.printStackTrace();
//// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
//            convertSuccess = false;
//        }
//        return convertSuccess;
//    }
//
//    public String dateFormat(String dateIn) throws ParseException {
//        if (dateIn == null || dateIn.equals("")) {
//            dateIn = "";
//            return dateIn;
//        } else {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            //字符串转换成日期
//            Date date = sdf.parse(dateIn);
//            dateIn = sdf.format(date);
//            return dateIn;
//        }
//
//    }
}
