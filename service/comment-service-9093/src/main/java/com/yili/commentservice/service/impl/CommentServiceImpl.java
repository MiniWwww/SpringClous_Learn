package com.yili.commentservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yili.commentservice.mapper.CommentMapper;
import com.yili.commentservice.service.CommentService;
import com.yili.model.entity.Comments;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comments> implements CommentService {

}
