package com.dao;

import com.entity.ShixiFenxiangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShixiFenxiangView;

/**
 * 实习分享 Dao 接口
 *
 * @author 
 */
public interface ShixiFenxiangDao extends BaseMapper<ShixiFenxiangEntity> {

   List<ShixiFenxiangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
