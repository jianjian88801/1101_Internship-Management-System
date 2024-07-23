package com.dao;

import com.entity.ShixiChengjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShixiChengjiView;

/**
 * 实习成绩 Dao 接口
 *
 * @author 
 */
public interface ShixiChengjiDao extends BaseMapper<ShixiChengjiEntity> {

   List<ShixiChengjiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
