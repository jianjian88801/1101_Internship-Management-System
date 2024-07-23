package com.dao;

import com.entity.ShixiFenxiangLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShixiFenxiangLiuyanView;

/**
 * 实习分享留言 Dao 接口
 *
 * @author 
 */
public interface ShixiFenxiangLiuyanDao extends BaseMapper<ShixiFenxiangLiuyanEntity> {

   List<ShixiFenxiangLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
