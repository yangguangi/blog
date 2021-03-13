package com.example.service;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.entity.Post;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.vo.PostVo;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 公众号：java思维导图
 * @since 2021-03-08
 */
public interface PostService extends IService<Post> {

    IPage paging(Page page, Long categoryId, Long userId, Integer
            level, Boolean recommend, String order);

    PostVo selectOnePost(QueryWrapper<Post> wrapper);

    /**
     * 本周热议初始化
     */
    @Override
    public void initWeekRank(){
        //获取七天内发表的文章
        List<Post> posts = this.list(new QueryWrapper<Post>()
              .ge("created", DateUtil.offsetDay(new Date(),-7))
              .select("id, title, user_id, comment_cont, view_count, created")
        );
        //初始化文章的总评论量
        for (Post  post :posts){
            String key = "day:rank:" + DateUtil.format(post.getCreated(), DatePattern.PURE_DATE_FORMAT);



        }
        //缓存文章的一些基本信息（id，标题，评论数量，作者）   不用去依赖数据库了，可以直接从缓存拿
        
        //做并集
        
        
    }
}
