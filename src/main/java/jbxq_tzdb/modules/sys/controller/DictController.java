package jbxq_tzdb.modules.sys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import jbxq_tzdb.core.common.controller.BaseCRUDController;
import jbxq_tzdb.core.query.data.Queryable;
import jbxq_tzdb.core.query.wrapper.EntityWrapper;
import jbxq_tzdb.core.security.shiro.authz.annotation.RequiresPathPermission;
import jbxq_tzdb.modules.sys.entity.Dict;
import jbxq_tzdb.modules.sys.entity.DictGroup;
import jbxq_tzdb.modules.sys.service.IDictGroupService;

@Controller
@RequestMapping("${admin.url.prefix}/sys/dict")
@RequiresPathPermission("sys:user")
public class DictController extends BaseCRUDController<Dict, String> {
	@Autowired
	private IDictGroupService dictGroupService;

	@Override
	public void preList(Model model, HttpServletRequest request, HttpServletResponse response) {
		String gid = request.getParameter("gid");
		DictGroup group = dictGroupService.selectById(gid);
		model.addAttribute("group", group);
	}

	@Override
	public void preAjaxList(Queryable queryable, EntityWrapper<Dict> entityWrapper, HttpServletRequest request,
			HttpServletResponse response) {
		String gid = request.getParameter("gid");
		queryable.addCondition("gid", gid);
	}

	@Override
	public void preEdit(Dict entity, Model model, HttpServletRequest request, HttpServletResponse response) {
		String gid = request.getParameter("gid");
		model.addAttribute("gid", gid);
	}
}
