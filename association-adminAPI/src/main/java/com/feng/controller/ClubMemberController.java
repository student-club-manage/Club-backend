package com.feng.controller;

import com.feng.dto.ActivityFileDto;
import com.feng.entity.ActivityType;
import com.feng.entity.ClubMember;
import com.feng.entity.File;
import com.feng.entity.ResponseResult;
import com.feng.service.ClubMemberService;
import com.feng.util.ResponseResultUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/clubMember")
public class ClubMemberController {
    @Autowired
    private ClubMemberService clubMemberService;
    @ApiOperation(value = "通过id获取一个社团申请", notes = "通过id获取一个社团申请")
    @GetMapping("/{id}")
    public ResponseResult getById(@PathVariable("id") Integer id) {
        ClubMember clubMember = clubMemberService.selectById(id);
//        ActivityFileDto activity = clubMemberService.getInfoById(id);
        return ResponseResultUtil.renderSuccess(clubMember);
    }
    @PutMapping
    @ApiOperation(value = "更新俱乐部申请",notes = "更新俱乐部申请")
    public ResponseResult edit(ClubMember clubMember) {
        clubMemberService.updateById(clubMember);
        return ResponseResultUtil.renderSuccess("更新成功");
    }

    @ApiOperation("添加俱乐部申请")
    @PostMapping
    public ResponseResult add(@Valid @RequestBody ClubMember clubMember) {
        System.out.println(clubMember);
        clubMemberService.insert(clubMember);
        return ResponseResultUtil.renderSuccess("添加俱乐部申请成功");
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "根据id删除俱乐部申请",notes = "根据id删除俱乐部申请")
    public ResponseResult delete( @PathVariable Integer id) {
        clubMemberService.deleteById(id);
        return ResponseResultUtil.renderSuccess("删除俱乐部申请成功");
    }
    @ApiOperation("通过userid获取俱乐部申请list文件")
    @GetMapping("/userid/{userid}")
    public ResponseResult getByuser(@PathVariable("userid") Integer userid) {
        List<ClubMember> files = clubMemberService.getByuserId(userid);
        return ResponseResultUtil.renderSuccess(files);
    }
    @ApiOperation("通过clubid获取俱乐部申请list文件")
    @GetMapping("/clubid/{clubid}")
    public ResponseResult getByclub(@PathVariable("clubid") Integer clubid) {
        List<ClubMember> files = clubMemberService.getByclubId(clubid);
        return ResponseResultUtil.renderSuccess(files);
    }
    @ApiOperation("通过userid_clubid获取俱乐部申请list文件")
    @GetMapping("/clubuser_id/{userid}/{clubid}")
    public ResponseResult getByuser_club(@PathVariable("userid") Integer userid,@PathVariable("clubid") Integer clubid) {
        List<ClubMember> files = clubMemberService.getByclubId_userid(userid, clubid);
        return ResponseResultUtil.renderSuccess(files);
    }
}
