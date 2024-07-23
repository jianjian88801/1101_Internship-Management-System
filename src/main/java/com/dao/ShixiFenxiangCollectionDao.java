package com.dao;

import com.entity.ShixiFenxiangCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShixiFenxiangCollectionView;

/**
 * 实习分享收藏 Dao 接口
 *
 * @author 
 */
public interface ShixiFenxiangCollectionDao extends BaseMapper<ShixiFenxiangCollectionEntity> {

   List<ShixiFenxiangCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
