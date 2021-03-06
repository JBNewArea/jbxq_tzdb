package jbxq_tzdb.modules.monitor.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jbxq_tzdb.core.common.controller.BaseController;
import jbxq_tzdb.core.security.shiro.authz.annotation.RequiresMethodPermissions;
import jbxq_tzdb.core.security.shiro.authz.annotation.RequiresPathPermission;

@Controller
@RequestMapping("${admin.url.prefix}/monitor/druid")
@RequiresPathPermission("monitor:druid")
public class DruidController extends BaseController {

	@RequiresMethodPermissions("index")
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model, HttpServletRequest request, HttpServletResponse response) {
		return display("index");
	}
}
