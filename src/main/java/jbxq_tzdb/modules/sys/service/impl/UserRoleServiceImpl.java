package jbxq_tzdb.modules.sys.service.impl;

import jbxq_tzdb.core.common.service.impl.CommonServiceImpl;
import jbxq_tzdb.modules.sys.entity.UserRole;
import jbxq_tzdb.modules.sys.mapper.UserRoleMapper;
import jbxq_tzdb.modules.sys.service.IUserRoleService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("userRoleService")
public class UserRoleServiceImpl extends CommonServiceImpl<UserRoleMapper,UserRole> implements IUserRoleService {

}
