package com.edu.fjnu.cjrserver.utils;

import com.edu.fjnu.cjrserver.model.ResultData;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by Administrator on 2017/12/27 0027.
 */
public class FileUtils {
    //活动服务，赛事服务，人工服务文件上传路径
    private static final String SPORT_SERVICE_FILE_PATH = "file\\dox\\service\\spts\\";
    private static final String ARTIFICIAL_SERVICE_FILE_PATH = "file\\dox\\service\\arts\\";
    private static final String ACTIVITY_SERVICE_FILE_PATH = "file\\dox\\service\\acts\\";
    //招标文件上传路径
    private static final String TENDER_PLAN_FILE_PATH = "file\\dox\\tenderplan\\";
    //场地服务，器材图片上传路径
    private static final String FIELD_SERVICE_FILE_PATH = "file\\img\\service\\flds\\";
    private static final String EQUIPMENT_CONTENT_FILE_PATH = "file\\img\\service\\eqct\\";
    //评价报告路径
    private static final String ASSESS_REPORT_FILE_PATH = "file\\dox\\evaluation\\";
    //允许的文件类型
    private static final String[] FILE_TYPE = {"DOCX","DOC","TXT"};
    //允许的图片类型
    private static final String[] IMG_TYPE = {"GIF","PNG","JPG"};

    /**
     *
     * @param file      文件类型的文件
     * @param isFile    boolean类型表示文件为图片还是文件，true表示是文件，false表示是图片
     * @param FileType  字符串的值表示该文件是什么文件，根据该值在下面getPath（）函数查询应该将这个文件存入哪里
     * @param request
     * @param response
     * @param session
     * @return          如果保存成功，返回文件存放的路径与文件名。如果保存失败则返回null
     * @throws IllegalStateException
     * @throws IOException
     */
    public String FileUpload(MultipartFile file,boolean isFile,String FileType, HttpServletRequest request, HttpServletResponse response, HttpSession session)throws IllegalStateException, IOException {
        if (file!=null) {// 判断上传的文件是否为空
            String fileName = file.getOriginalFilename();// 文件原名称
            String trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;
            String typePath = getPath(FileType);
            if(typePath==null){
                return null;
            }
            String realPath = request.getSession().getServletContext().getRealPath("/") + typePath;
            String path=null;// 文件路径
            String type=null;// 文件类型
            System.out.println("上传的文件原名称:"+fileName);
            // 判断文件类型
            type=fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
            if (type!=null) {// 判断文件类型是否为空
                boolean  typeRight;
                if (isFile == true){
                    typeRight = isFileTypeRight(type.toUpperCase());
                }else {
                    typeRight = isImgTypeRight(type.toUpperCase());
                }
                if (typeRight == true) {
                    // 设置存放图片文件的路径
                    path=realPath+/*System.getProperty("file.separator")+*/trueFileName;
                    System.out.println("存放文件的路径:"+path);
                    // 转存文件到指定的路径
                    file.transferTo(new File(path));
                    System.out.println("文件成功上传到指定目录下");
                    return typePath + trueFileName;
                }else {
                    System.out.println("不是我们想要的文件类型,请按要求重新上传");
                    return null;
                }
            }else {
                System.out.println("文件类型为空");
                return null;
            }
        }else {
            System.out.println("没有找到相对应的文件");
            return null;
        }
    }

    private String getPath(String type){
        if(type.equals("SportServic")){
            return SPORT_SERVICE_FILE_PATH;
        }else if(type.equals("ArtificialService")){
            return ARTIFICIAL_SERVICE_FILE_PATH;
        }else if(type.equals("ActivityService")){
            return ACTIVITY_SERVICE_FILE_PATH;
        }else if(type.equals("FeildService")) {
            return FIELD_SERVICE_FILE_PATH;
        }else if (type.equals("EquipmentContent")) {
            return EQUIPMENT_CONTENT_FILE_PATH;
        }else if (type.equals("AssessReport")) {
            return ASSESS_REPORT_FILE_PATH;
        }else if(type.equals("TenderPlan")){
            return TENDER_PLAN_FILE_PATH;
        }
        else{
            return null;
        }
    }

    public void DeleteFile(String FilePath, HttpServletRequest request){
        File file1 = new File(request.getSession().getServletContext().getRealPath("/") + FilePath);
        if (file1.exists()) {
            file1.delete();
        }
    }

    private boolean isFileTypeRight(String type){
        for(String fileType:FILE_TYPE){
            if(type.equals(fileType))
                return true;
        }
        return false;
    }

    private boolean isImgTypeRight(String type){
        for(String imgType:IMG_TYPE){
            if(type.equals(imgType))
                return true;
        }
        return false;
    }
}
