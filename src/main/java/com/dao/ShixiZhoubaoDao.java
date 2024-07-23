package com.dao;

import com.entity.ShixiZhoubaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShixiZhoubaoView;

/**
 * 实习周报 Dao 接口
 *
 * @author 
 */
public interface ShixiZhoubaoDao extends BaseMapper<ShixiZhoubaoEntity> {

   List<ShixiZhoubaoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
