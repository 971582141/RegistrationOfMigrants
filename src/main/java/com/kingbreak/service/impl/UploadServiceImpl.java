package com.kingbreak.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kingbreak.entity.SysUpload;
import com.kingbreak.mapper.SysUploadMapper;
import com.kingbreak.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UploadServiceImpl extends
        ServiceImpl<SysUploadMapper, SysUpload> implements UploadService {

    // 真实路径
    @Value("${myPath.filePath}")
    private String filePath;

    @Value("${myPath.imgPath}")
    private String imgPath;

    @Value("${myPath.excelPath}")
    private String excelPath;

    @Value("${myPath.zipPath}")
    private String zipPath;

    @Override
    public SysUpload uploadFile(MultipartFile file, String fileType) {
        if (null != file) {
            if ("file".equals(fileType)) {
                return upload(file, filePath);
            }
            if ("img".equals(fileType)) {
                return upload(file, imgPath);
            }
            if ("excel".equals(fileType)) {
                return upload(file, excelPath);
            }
            if ("zip".equals(fileType)) {
                return upload(file, zipPath);
            }
        }
        return null;
    }

    @Override
    public Integer fileList(List<MultipartFile> fileList) {
        AtomicInteger i = new AtomicInteger();
        fileList.forEach(file -> {
            SysUpload sysUpload = upload(file, filePath);
            String fileName = sysUpload.getFileName();
            String name = fileName.substring(fileName.lastIndexOf("/") + 1);
            String planNo = name.substring(0, name.indexOf("_"));
            String fileType = name.substring(name.indexOf("_") + 1);
            String type = fileType.substring(0, fileType.lastIndexOf("."));
            System.out.println(type);
        });
        return i.get();
    }

    @Override
    public void preview(String url, HttpServletResponse response) throws Exception {
        File file = new File(url);
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        bis = new BufferedInputStream(new FileInputStream(file));
        bos = new BufferedOutputStream(response.getOutputStream());

        response.setHeader("Content-Type", "image/jpeg");
        byte b[] = new byte[1024];
        int read;

        while ((read = bis.read(b)) != -1) {
            bos.write(b, 0, read);
        }
        //request.getRequestDispatcher("/components/hazard/yscchird.html").forward(request, response);


        if (bos != null) {
            bos.close();
        }
        if (bis != null) {
            bis.close();
        }

    }

    @Override
    public void downloadFile(Integer uploadId, String fileName,
                             HttpServletResponse response) {
        SysUpload entity = baseMapper.selectById(uploadId);
        if (entity == null) {
            return;
        }
        if (!fileName.trim().equals(
                entity.getFileName().substring(0,
                        entity.getFileName().lastIndexOf(".")))) {
            return;
        }
        String tempPath = entity.getFileRealPath();
        String tempFileName = entity.getFileName();
        if (tempFileName != null) {
            // 设置文件路径
            File file = new File(tempPath.replace("/", File.separator));
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                try {
                    response.setHeader(
                            "Content-Disposition",
                            "attachment; fileName=" + tempFileName + ";"
                                    + "filename*=utf-8''"
                                    + URLEncoder.encode(tempFileName, "UTF-8"));
                } catch (UnsupportedEncodingException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                // 设置中文名称并且解决中文乱码问题
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return;
    }


    public SysUpload upload(MultipartFile file, String path) {
        SysUpload up = new SysUpload();
        if (file.isEmpty()) {
            return up;
        }
        String name = file.getOriginalFilename();
        if (name.equals("")) {
            // 如果没有传入自定义文件名，则自动获取文件名称
            name = file.getOriginalFilename();
        }
        // IE浏览器会跟上盘符路径
        String ieName = name.substring(name.lastIndexOf("\\") + 1);
        String linuxName = ieName.substring(ieName.lastIndexOf("/") + 1);
        // 获取文件的后缀名
        String suffixName = linuxName.substring(linuxName.lastIndexOf("."));
        // 文件上传后的路径
        // 解决中文问题，liunx下中文路径，图片显示问题
        String fileName = UUID.randomUUID() + linuxName;
        File dest = new File(path + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);

        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        up.setFileName(linuxName);
        up.setFileType(suffixName);
        up.setFileRealPath(path + fileName);
        baseMapper.insert(up);
        return up;
    }

}
