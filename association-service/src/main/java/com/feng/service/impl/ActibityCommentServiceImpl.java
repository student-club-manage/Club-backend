package com.feng.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.feng.dao.ActivityCommentMapper;
import com.feng.dao.ClubTypeMapper;
import com.feng.entity.ActivityComment;
import com.feng.entity.ClubType;
import com.feng.service.ActivityCommentService;
import com.feng.service.ClubTypeService;
import org.springframework.stereotype.Service;

@Service

public class ActibityCommentServiceImpl extends ServiceImpl<ActivityCommentMapper, ActivityComment> implements ActivityCommentService {
}
