package jbxq_tzdb.modules.sys.mapper;


import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import jbxq_tzdb.modules.sys.entity.Role;

public interface RoleMapper extends BaseMapper<Role> {
	/**
	 * 
	 * @title: findRoleByUserId   
	 * @description: 通过用户查找角色
	 * @param userId
	 * @return      
	 * @return: List<Role>
	 */
	List<Role> findRoleByUserId(String userId);
}
