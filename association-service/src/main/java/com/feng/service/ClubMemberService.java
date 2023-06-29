package com.feng.service;

import com.baomidou.mybatisplus.service.IService;
import com.feng.entity.ClubApply;
import com.feng.entity.ClubMember;

import java.util.List;

public interface ClubMemberService extends IService<ClubMember> {
    List<ClubMember> getByuserId(Integer id);
    List<ClubMember> getByclubId(Integer id);
    List<ClubMember> getByclubId_userid(Integer id1, Integer id2);
}
