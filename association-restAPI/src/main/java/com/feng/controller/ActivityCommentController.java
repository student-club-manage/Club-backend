package com.feng.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.feng.dao.UserMapper;
import com.feng.entity.ActivityComment;
import com.feng.entity.ResponseResult;
import com.feng.service.ActivityCommentService;
import com.feng.util.ResponseResultUtil;
import com.feng.util.SensitiveWordsUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/activityComment")
@Api(tags = "活动评论接口")
public class ActivityCommentController {
    @Autowired
    private ActivityCommentService cctivitycommentService;
    private UserMapper userMapper;

    @GetMapping("/get")
    public ResponseResult list(ActivityComment tmp) {
        EntityWrapper<ActivityComment>wrapper = new EntityWrapper<>();
        System.out.println(tmp);
        if(tmp.getId() != null)
        wrapper.eq("id", tmp.getId());
        if(tmp.getUserId() != null)
        wrapper.eq("user_id", tmp.getUserId());
        if(tmp.getActivityId() != null)
        wrapper.eq("activity_id", tmp.getActivityId());
        System.out.println(tmp);
        List<ActivityComment> activityTypeList= cctivitycommentService.selectList(wrapper);
        return ResponseResultUtil.renderSuccess(activityTypeList);
    }
    @PostMapping("/add")
    @ApiOperation("添加一个评论")
    public ResponseResult add( ActivityComment activityComment) {
        activityComment.setCreateTime(new Date());
        activityComment.setComment(SensitiveWordsUtil.outWords(activityComment.getComment()));
        System.out.println(activityComment);
        cctivitycommentService.insert(activityComment);
        return ResponseResultUtil.renderSuccess("添加评论成功");
    }
    @DeleteMapping("/del/{id}")
    @ApiOperation("通过id删除一个评论")
    public ResponseResult delete(@PathVariable("id") Integer id) {
        cctivitycommentService.deleteById(id);
        return ResponseResultUtil.renderSuccess("删除成功");
    }
//    @PostMapping("/add")
//    @ApiOperation("添加一个评论")
//    public ResponseResult add( ActivityComment activityComment) {
//        activityComment.setCreateTime(new Date());
//        activityComment.setComment(SensitiveWordsUtil.outWords(activityComment.getComment()));
//        System.out.println(activityComment);
//        cctivitycommentService.insert(activityComment);
//        return ResponseResultUtil.renderSuccess("添加评论成功");
//    }
}
