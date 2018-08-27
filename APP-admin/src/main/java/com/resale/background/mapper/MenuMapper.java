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


	/**
	 * 根据商户角色id 查询权限
	 */
	List<Menu> permissionListRoleId(Integer id);

	/**
	 * 查询所有pid为0的菜单
	 * @return
	 */
	List<Map<String, Object>> getParentMenuList();

	/*
	 * 校验菜单名称是否重复
	 */
	Menu checkMenuNameIsRepeat(Map<String, Object> map);

	/**
	 * 删除菜单
	 * @param map
	 */
	void deleteMenuByMenuId(Map<String, Object> map);

	/**
	 * 根据父id查询子菜单
	 * @param object
	 * @return
	 */
	List<Menu> queryChildMenuByPid(String pid);


}