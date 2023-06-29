package com.feng.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.feng.dao.ClubMemberMapper;
import com.feng.dao.ClubMapper;
import com.feng.dao.ClubMemberMapper;
import com.feng.dao.ClubTypeMapper;
import com.feng.entity.Club;
import com.feng.entity.ClubMember;
import com.feng.entity.ClubMember;
import com.feng.entity.File;
import com.feng.service.ClubMemberService;
import com.feng.service.ClubMemberService;
import com.feng.service.ClubService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubMemberServiceImpl  extends ServiceImpl<ClubMemberMapper, ClubMember> implements ClubMemberService {
    @Autowired
    private ClubMemberMapper clubMemberMapper;
    @Override
    public List<ClubMember> getByuserId(Integer id) {
        EntityWrapper<ClubMember> clubMemberEntityWrapper = new EntityWrapper<>();
        clubMemberEntityWrapper.eq("user_id", id);
        return clubMemberMapper.selectList(clubMemberEntityWrapper);
    }
    @Override
    public List<ClubMember> getByclubId(Integer id) {
        EntityWrapper<ClubMember> clubMemberEntityWrapper = new EntityWrapper<>();
        clubMemberEntityWrapper.eq("club_id", id);
        return clubMemberMapper.selectList(clubMemberEntityWrapper);
    }

    @Override
    public List<ClubMember> getByclubId_userid(Integer id1, Integer id2) {
        EntityWrapper<ClubMember> clubMemberEntityWrapper = new EntityWrapper<>();
        clubMemberEntityWrapper.eq("user_id", id1);
        clubMemberEntityWrapper.eq("club_id", id2);
        return clubMemberMapper.selectList(clubMemberEntityWrapper);
    }
}
