package com.resale.background.mapper;

import com.resale.background.pojo.EmployeeRoleRelation;
import com.resale.background.pojo.EmployeeRoleRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeRoleRelationMapper {
    int countByExample(EmployeeRoleRelationExample example);

    int deleteByExample(EmployeeRoleRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeRoleRelation record);

    int insertSelective(EmployeeRoleRelation record);

    List<EmployeeRoleRelation> selectByExample(EmployeeRoleRelationExample example);

    EmployeeRoleRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EmployeeRoleRelation record, @Param("example") EmployeeRoleRelationExample example);

    int updateByExample(@Param("record") EmployeeRoleRelation record, @Param("example") EmployeeRoleRelationExample example);

    int updateByPrimaryKeySelective(EmployeeRoleRelation record);

    int updateByPrimaryKey(EmployeeRoleRelation record);

    /**
     * 通过员工编号查询拥有的角色
     * @param employeeId
     * @return
     */
	List<Integer> getRoleByEmployeeId(int employeeId);

	/**
	 * 根据商户id删除原有的角色id
	 * @param employeeId
	 */
	void deleteRoleIdByEmployeeId(int employeeId);

	/**
	 * 添加角色
	 * @param list
	 */
	void insertRoleIds(List<EmployeeRoleRelation> list);
}