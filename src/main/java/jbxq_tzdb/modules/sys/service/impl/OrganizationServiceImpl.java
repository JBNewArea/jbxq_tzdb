package jbxq_tzdb.modules.sys.service.impl;

import jbxq_tzdb.core.common.service.impl.TreeCommonServiceImpl;
import jbxq_tzdb.modules.sys.entity.Organization;
import jbxq_tzdb.modules.sys.mapper.OrganizationMapper;
import jbxq_tzdb.modules.sys.service.IOrganizationService;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("organizationService")
public class OrganizationServiceImpl extends TreeCommonServiceImpl<OrganizationMapper, Organization, String>
		implements IOrganizationService {

	@Override
	public List<Organization> findListByUserId(String userid) {
		return baseMapper.findListByUserId(userid);
	}

}
