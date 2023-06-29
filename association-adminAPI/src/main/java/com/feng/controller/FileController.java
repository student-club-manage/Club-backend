package com.feng.controller;


import com.feng.constants.AppConstant;
import com.feng.entity.File;
import com.feng.entity.ResponseResult;
import com.feng.entity.User;
import com.feng.enums.FileEnum;
import com.feng.service.FileService;
import com.feng.util.ResponseResultUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/files")
@Api(value = "社团管理系统后台文件管理文档接口",tags = "社团管理系统后台文件管理文档接口")
public class FileController {
    @Autowired
    private FileService fileService;

    @ApiOperation("通过文件id查看一个文件")
    @GetMapping("/{id}")
    public ResponseResult get(@PathVariable("id") Integer id) throws Exception {
        File file = fileService.selectById(id);
        return ResponseResultUtil.renderSuccess(file);
    }
    @ApiOperation("通过name获取list文件")
    @GetMapping("/club/{fileName}")
    public ResponseResult getByName(@PathVariable("fileName") String file_name) {
//        User user = userService.getById(id);
        List<File> files = fileService.getByName(file_name);

        return ResponseResultUtil.renderSuccess(files);
    }
    @GetMapping
    @ApiOperation("根据条件分页查询所有文件")
    public ResponseResult list(File search, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        PageInfo filePageInfo = fileService.getPage(pageNum, pageSize, search);
        return ResponseResultUtil.renderSuccess(filePageInfo);
    }

    @ApiOperation("通过文件id删除一个文件")
    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable("id") Integer id) {
        fileService.deleteById(id);
        return ResponseResultUtil.renderSuccess(id);
    }
    @ApiOperation("通过文件id更新一个文件")
    @PutMapping("update/{id}/{fileTypeId}")
    public ResponseResult update(@PathVariable("id") Integer id, @PathVariable("fileTypeId") Integer type) {
        File file = fileService.selectById(id);
        fileService.deleteById(id);
        file.setFileTypeId(type);
        fileService.insert(file);
        return ResponseResultUtil.renderSuccess(file);
    }
    @ApiOperation("添加文件")
    @PostMapping
    public ResponseResult save(@Valid @RequestBody File file) {
        fileService.insert(file);
        return ResponseResultUtil.renderSuccess("添加文件成功");
    }

    @ApiOperation("添加活动文件")
    @PostMapping("/activity")
    public ResponseResult saveActivityFile(@Valid @RequestBody File file) {
        file.setPassageId(0);
        file.setFileTypeId(FileEnum.ACTIVITY_IMG.getFileId());
        fileService.save(file);
        return ResponseResultUtil.renderSuccess("添加文件成功");
    }

    @ApiOperation("添加新闻文件")
    @PostMapping("/passage")
    public ResponseResult savePassageFile(@Valid @RequestBody File file) {
        file.setActivityId(0);
        if (file.getFileTypeId() == null) {
            file.setFileTypeId(FileEnum.PASSAGE_IMG.getFileId());
        }

        fileService.save(file);
        return ResponseResultUtil.renderSuccess("添加文件成功");
    }
    @ApiOperation("添加俱乐部图片")
    @PostMapping("/club")
    public ResponseResult saveClubFile(@Valid @RequestBody File file) {
        file.setActivityId(0);
        file.setPassageId(0);
        file.setFileTypeId(FileEnum.CLUB_IMG.getFileId());
        fileService.save(file);
        return ResponseResultUtil.renderSuccess("添加文件成功");
    }
}

