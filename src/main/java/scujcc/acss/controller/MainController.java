package scujcc.acss.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import scujcc.acss.utils.FileUploadUtil;

/**
 * 主要的控制器，负责相应请求
 * @author CZM
 * @create 2018-10-20 上午 12:33
 */
@RestController
public class MainController {
    //TODO
    @PostMapping(value = "/acss/upload")
    public void upload(@RequestBody HttpServletRequest request) throws Exception {
        (new FileUploadUtil()).getFile(request);
    }
    //TODO
}
