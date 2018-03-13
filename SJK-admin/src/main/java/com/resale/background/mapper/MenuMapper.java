package com.resale.background.mapper;

import com.resale.background.pojo.Menu;
import com.resale.background.pojo.MenuExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MenuMapper {
    int countByExample(MenuExample example);

    int deleteByExample(MenuExample example);

    int deleteByPrimaryKey(Integer menuId);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuExample example);

    Menu selectByPrimaryKey(Integer menuId);

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    /**
     *根据用户id查找菜单
     * @param requestMap
     * @return
     */
	List<Menu> getMenuByMerchantId(Map<String, Object> requestMap);

	/**
	 * 查询所有菜单
	 * @param paramsCondition
	 * @return
	 */
	List<Map<String, Object>> findAllRetMapByPage(Map<String, Object> paramsCondition);
	/**
	 * 查询总条数
	 * @param paramsCondition
	 * @return
	 */
	Long findAllByPageCount(Map<String, Object> paramsCondition);

}