package com.resale.background.mapper;

import com.resale.background.pojo.Menu;
import com.resale.background.pojo.Role;
import com.resale.background.pojo.RoleExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    int countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    /**
	 * 根据用户ID查询角色信息
	 */
	List<Role> findRoleByMerchantId(Integer id);

	List<Map<String, Object>> findAllRetMapByPage(Map<String, Object> paramsCondition);

	Long findAllByPageCount(Map<String, Object> paramsCondition);
	/**
	 * 根据角色编码校验是否有重复
	 * @param map
	 * @return
	 */
	Role checkRoleCodeIsRepeat(Map<String, Object> map);

	/**
	 * 删除角色
	 * @param map
	 */
	void deleteRoleById(Map<String, Object> map);

	/**
	 * 查询所有角色
	 * @return
	 */
	List<Role> getRoleList();
}