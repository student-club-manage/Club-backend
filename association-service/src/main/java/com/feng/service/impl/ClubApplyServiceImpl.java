package com.feng.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.feng.dao.ClubApplyMapper;
import com.feng.dao.ClubMapper;
import com.feng.dao.ClubTypeMapper;
import com.feng.entity.Club;
import com.feng.entity.ClubApply;
import com.feng.entity.File;
import com.feng.service.ClubApplyService;
import com.feng.service.ClubService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubApplyServiceImpl  extends ServiceImpl<ClubApplyMapper, ClubApply> implements ClubApplyService {
    @Autowired
    private ClubApplyMapper clubApplyMapper;
    @Override
    public List<ClubApply> getByuserId(Integer id) {
        EntityWrapper<ClubApply> clubApplyEntityWrapper = new EntityWrapper<>();
        clubApplyEntityWrapper.eq("user_id", id);
        return clubApplyMapper.selectList(clubApplyEntityWrapper);
    }
    @Override
    public List<ClubApply> getByclubId(Integer id) {
        EntityWrapper<ClubApply> clubApplyEntityWrapper = new EntityWrapper<>();
        clubApplyEntityWrapper.eq("club_id", id);
        return clubApplyMapper.selectList(clubApplyEntityWrapper);
    }

    @Override
    public List<ClubApply> getByclubId_userid(Integer id1, Integer id2) {
        EntityWrapper<ClubApply> clubApplyEntityWrapper = new EntityWrapper<>();
        clubApplyEntityWrapper.eq("user_id", id1);
        clubApplyEntityWrapper.eq("club_id", id2);
        return clubApplyMapper.selectList(clubApplyEntityWrapper);
    }
}
