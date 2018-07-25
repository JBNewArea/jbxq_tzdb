package jbxq_tzdb.modules.sys.service.impl;

import jbxq_tzdb.core.common.service.impl.CommonServiceImpl;
import jbxq_tzdb.modules.sys.entity.RoleMenu;
import jbxq_tzdb.modules.sys.mapper.RoleMenuMapper;
import jbxq_tzdb.modules.sys.service.IRoleMenuService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("roleMenuService")
public class RoleMenuServiceImpl extends CommonServiceImpl<RoleMenuMapper,RoleMenu> implements IRoleMenuService {

}
