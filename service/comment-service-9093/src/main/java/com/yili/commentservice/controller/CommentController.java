package com.yili.commentservice.controller;

import com.yili.commentservice.service.CommentService;
import com.yili.common.result.Result;
import com.yili.model.entity.Comments;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    CommentService commentService;

    /**
     * 查看所有评论接口
     * @return 返回包含评论列表的 Result 对象
     */
    @GetMapping("/list")
    public Result<List<Comments>> getCommentList() {
        List<Comments> commentList = commentService.list();
        return Result.ok(commentList);
    }


    /**
     * 更新评论
     * @param comment 更新后的评论对象
     * @return 返回操作结果的 Result 对象
     */
    @PutMapping("/update")
    public Result<?> updateComment(@RequestBody Comments comment) {
        if (commentService.updateById(comment)) {
            return Result.ok("更新成功");
        }
        return Result.fail("更新失败");
    }
    /**
     * 根据评论ID删除评论接口
     * @param id 评论ID
     * @return 返回操作结果的 Result 对象
     */
    @DeleteMapping("/{id}")
    public Result<String> deleteCommentById(@PathVariable Integer id) {
        if (commentService.removeById(id)) {
            return Result.ok("删除成功");
        }
        return Result.fail("删除失败");
    }

    /**
     * 查看评论详情接口
     * @param id 评论ID
     * @return 返回包含评论详情的 Result 对象
     */
    @GetMapping("/{id}")
    public Result<Comments> getCommentById(@PathVariable Integer id) {
        Comments comment = commentService.getById(id);
        return Result.ok(comment);
    }
}
