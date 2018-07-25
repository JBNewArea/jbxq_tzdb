package jbxq_tzdb.modules.sys.controller;

import jbxq_tzdb.core.common.controller.BaseCRUDController;
import jbxq_tzdb.core.model.AjaxJson;
import jbxq_tzdb.core.query.wrapper.EntityWrapper;
import jbxq_tzdb.core.security.shiro.authz.annotation.RequiresPathPermission;
import jbxq_tzdb.modules.sys.entity.Menu;
import jbxq_tzdb.modules.sys.entity.Role;
import jbxq_tzdb.modules.sys.entity.RoleMenu;
import jbxq_tzdb.modules.sys.service.IMenuService;
import jbxq_tzdb.modules.sys.service.IRoleMenuService;
import jbxq_tzdb.modules.sys.utils.UserUtils;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONArray;

@Controller
@RequestMapping("${admin.url.prefix}/sys/role")
@RequiresPathPermission("sys:role")
public class RoleController extends BaseCRUDController<Role, String> {
	
	@Autowired
	private IMenuService menuService;
	@Autowired
	private IRoleMenuService roleMenuService;

	@RequestMapping(value = "authMenu", method = RequestMethod.GET)
	public String authMenu(Role role, Model model, HttpServletRequest request, HttpServletResponse response) {
		EntityWrapper<Menu> entityWrapper = new EntityWrapper<Menu>(Menu.class);
		entityWrapper.orderBy("sort", false);
		List<Menu> menus = menuService.selectTreeList(entityWrapper);
		List<Menu> selectMenus = menuService.findMenuByRoleId(role.getId());
		model.addAttribute("menus", JSONArray.toJSON(menus));
		model.addAttribute("selectMenus", JSONArray.toJSON(selectMenus));
		model.addAttribute("data", role);
		return display("authMenu");
	}

	@RequestMapping(value = "/doAuthMenu", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson doAuthMenu(Role role, HttpServletRequest request, HttpServletResponse response) {
		AjaxJson ajaxJson = new AjaxJson();
		ajaxJson.success("权限设置成功");
		try {
			String roleId = role.getId();
			// 删除菜单关联
			roleMenuService.delete(new EntityWrapper<RoleMenu>(RoleMenu.class).eq("roleId", roleId));
			String selectMenu = request.getParameter("selectMenus");
			String[] selectMenus = selectMenu.split(",");
			List<RoleMenu> roleMenuList = new ArrayList<RoleMenu>();
			for (String menuId : selectMenus) {
				RoleMenu roleMenu = new RoleMenu();
				roleMenu.setRoleId(roleId);
				roleMenu.setMenuId(menuId);
				roleMenuList.add(roleMenu);
			}
			roleMenuService.insertOrUpdateBatch(roleMenuList);
			UserUtils.clearCache();
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJson.fail("权限设置失败");
		}
		return ajaxJson;
	}

}
