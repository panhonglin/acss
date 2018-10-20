package scujcc.acss.utils;/**
 * @author CZM
 * @create 2018-10-20 下午 03:50
 */

import org.springframework.web.multipart.MultipartFile;
import scujcc.acss.enums.ResultEnums;
import scujcc.acss.exception.FileException;

/**
 *@ClassNmae FileUploadUtil
 *@Description 用户上传文件的工具
 *@Author CZM
 *@Date 2018/10/20 下午 03:50
 *@Version 1.0
 **/
public class FileUploadUtil {
    public void getFile(MultipartFile file) throws Exception{
        if (!file.isEmpty()) {

        } else {
            throw new FileException(ResultEnums.FILE_EMPTY);
        }
    }
}
