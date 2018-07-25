package jbxq_tzdb.modules.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jbxq_tzdb.core.common.controller.BaseTreeController;
import jbxq_tzdb.core.security.shiro.authz.annotation.RequiresPathPermission;
import jbxq_tzdb.modules.sys.entity.Organization;

@Controller
@RequestMapping("${admin.url.prefix}/sys/organization")
@RequiresPathPermission("sys:organization")
public class OrganizationController extends BaseTreeController<Organization, String> {
	
}
