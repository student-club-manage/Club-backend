package com.feng.service;

import com.feng.entity.User;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.web.multipart.MultipartFile;

public interface UserexcelService extends IService<User> {
    void importExcel(MultipartFile multipartFile);
}
