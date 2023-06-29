package com.feng.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.feng.dto.ActivityFileDto;
import com.feng.entity.*;
import com.feng.service.ClubApplyService;
import com.feng.service.UserService;
import com.feng.util.ResponseResultUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("/clubApply")
public class ClubApplyController {
    @Autowired
    private ClubApplyService clubApplyService;
    @Autowired
    private UserService userService;
    @ApiOperation(value = "通过id获取一个社团申请", notes = "通过id获取一个社团申请")
    @GetMapping("/{id}")
    public ResponseResult getById(@PathVariable("id") Integer id) {
        ClubApply clubApply = clubApplyService.selectById(id);
//        ActivityFileDto activity = clubApplyService.getInfoById(id);
        return ResponseResultUtil.renderSuccess(clubApply);
    }

    @PutMapping
    @ApiOperation(value = "更新俱乐部申请",notes = "更新俱乐部申请")
    public ResponseResult edit(@Valid @RequestBody ClubApply clubApply) {
        System.out.println(clubApply);
        clubApplyService.updateById(clubApply);
        return ResponseResultUtil.renderSuccess("更新成功");
    }

    @ApiOperation("添加俱乐部申请")
    @PostMapping
    public ResponseResult add(@Valid @RequestBody ClubApply clubApply) {
        System.out.println(clubApply);
        clubApplyService.insert(clubApply);
        return ResponseResultUtil.renderSuccess("添加俱乐部申请成功");
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "根据id删除俱乐部申请",notes = "根据id删除俱乐部申请")
    public ResponseResult delete( @PathVariable Integer id) {
        clubApplyService.deleteById(id);
        return ResponseResultUtil.renderSuccess("删除俱乐部申请成功");
    }
    @ApiOperation("通过userid获取俱乐部申请list文件")
    @GetMapping("/userid/{userid}")
    public ResponseResult getByuser(@PathVariable("userid") Integer userid) {
        List<ClubApply> files = clubApplyService.getByuserId(userid);
        return ResponseResultUtil.renderSuccess(files);
    }
    @ApiOperation("通过clubid获取俱乐部申请list文件")
    @GetMapping("/clubid/{clubid}")
    public ResponseResult getByclub(@PathVariable("clubid") Integer clubid) {
        List<ClubApply> files = clubApplyService.getByclubId(clubid);
        return ResponseResultUtil.renderSuccess(files);
    }
    @ApiOperation("通过userid_clubid获取俱乐部申请list文件")
    @GetMapping("/clubuser_id/{userid}/{clubid}")
    public ResponseResult getByuser_club(@PathVariable("userid") Integer userid,@PathVariable("clubid") Integer clubid) {
        System.out.println(userid + " " + clubid);
        List<ClubApply> files = clubApplyService.getByclubId_userid(userid, clubid);

        return ResponseResultUtil.renderSuccess(files);
    }
    @ApiOperation("通过id得到所有该管理的club的信息")
    @GetMapping("/get_all_apply/{userid}")
    public ResponseResult get_all_apply(@PathVariable("userid") Integer userid) {
        User user = userService.getById(userid);
        List<ClubApply> ans = new ArrayList<>();
        if(user.getRoleId() == 1) {// 超级管理原可以管理所有人
            List<User> run = userService.getUserPage(100, 100, new User()).getList();
            for (int i = 0; i < run.size(); i += 1) {
                System.out.println(run.get(i));
                List<ClubApply> tmp = clubApplyService.getByuserId(run.get(i).getId());
                for (int j = 0; j < tmp.size(); j += 1) {
                    if(Objects.equals(tmp.get(j).getUserId(), userid)) continue;
                    ans.add(tmp.get(j));
                }
            }
            return ResponseResultUtil.renderSuccess(ans);
        } // 普通用户只能管理自己为社长的社团
        List<ClubApply> files = clubApplyService.getByuserId(userid);
        List<Integer>clubs = new ArrayList<>();
        for (int i = 0; i < files.size(); i += 1) {
            if(files.get(i).getId() != userid || files.get(i).getIsJoin() == 0) continue;
            clubs.add(files.get(i).getClubId());
        }
        System.out.println(clubs);
        for (int i = 0; i < clubs.size(); i += 1) {
            List<ClubApply> tmp = clubApplyService.getByclubId(clubs.get(i));
            for (int j = 0 ;  j < tmp.size(); j += 1) {
                if(Objects.equals(tmp.get(j).getUserId(), userid)) continue;
                ans.add(tmp.get(j));
            }
        }

        return ResponseResultUtil.renderSuccess(ans);
    }
}
