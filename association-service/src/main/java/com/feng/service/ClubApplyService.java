package com.feng.service;

import com.baomidou.mybatisplus.service.IService;
import com.feng.entity.ClubApply;

import java.util.List;

public interface ClubApplyService extends IService<ClubApply> {
    List<ClubApply> getByuserId(Integer id);
    List<ClubApply> getByclubId(Integer id);
    List<ClubApply> getByclubId_userid(Integer id1, Integer id2);

}
