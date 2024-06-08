package cqut.keshe3.controller;

import cqut.keshe3.common.Code;
import cqut.keshe3.common.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/common")
public class CommonController {

    @Value("${car_rental.path}")
    private String basePath;

    /**
     文件上传，MultipartFile的参数名必须为file
     * @param file
     * @return: com.reggie.common.R<java.lang.String>
     */
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file){
        //file是一个临时文件，需要转到指定位置，否则本次请求完成后就会自动删除

        //1.取出原始文件名
        String originalFilename = file.getOriginalFilename();

        //2.使用UUID重新生成文件名，防止文件名重复造成覆盖
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = UUID.randomUUID() + suffix;

        //3.创建一个目录
        File dir = new File(basePath);
        //4.判断当前目录是否存在
        if(!dir.exists()){
            //如果目录不存在
            dir.mkdirs();
        }

        //5.将临时文件转存到指定位置
        try {
            file.transferTo(new File(basePath + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Result<>(Code.SAVE_OK, fileName, Code.SAVE_OK_MESSAGE);
    }

    /**
     文件下载
     * @param name
     * @param response
     * @return: void
     */
    @GetMapping("/download")
    public void download(@RequestParam String name, HttpServletResponse response){
        try {
            System.out.println(name);
            //输入流，通过输入流读取文件内容
            FileInputStream fileInputStream = new FileInputStream(new File(basePath + name));
            //输出流，通过输出流将文件写回浏览器，在浏览器展示图片
            ServletOutputStream outputStream = response.getOutputStream();

            response.setContentType("image/jpeg");

            int len = 0;
            byte[] bytes = new byte[1024];
            while( (len = fileInputStream.read(bytes)) != -1){
                outputStream.write(bytes, 0, len);
            }

            outputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
