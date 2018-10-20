package scujcc.acss.utils;/**
 * @author CZM
 * @create 2018-10-20 下午 03:50
 */

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import scujcc.acss.enums.ResultEnums;
import scujcc.acss.exception.FileException;
import scujcc.acss.exception.SystemException;

import java.io.*;
import java.util.List;

/**
 *@ClassNmae FileUploadUtil
 *@Description 用户上传文件的工具
 *@Author CZM
 *@Date 2018/10/20 下午 03:50
 *@Version 1.0
 **/
public class FileUploadUtil {
    /**
     * @Author CZM
     * @Description 获取文件
     * @Date 下午 06:17 2018/10/20
     * @Param [request]
     * @return void
     **/
    public void getFile(HttpServletRequest request) throws Exception{
        List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i =0;i<files.size();++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
                    stream.write(bytes);
                    stream.close();
                } catch (FileNotFoundException e) {
                    throw new FileException(ResultEnums.FILE_NOT_FOUND);
                } catch (IOException e) {
                    throw new SystemException(ResultEnums.SYSTEM_IO_ERROR);
                }
            } else {
                throw new FileException(ResultEnums.FILE_EMPTY);
            }
        }
    }
}
