package jbxq_tzdb.modules.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jbxq_tzdb.core.common.controller.BaseCRUDController;
import jbxq_tzdb.core.security.shiro.authz.annotation.RequiresPathPermission;
import jbxq_tzdb.modules.sys.entity.UserLastOnline;

/**   
 * @Title: 最后在线情况
 * @Description: 最后在线情况
 * @author jeeweb
 * @date 2017-05-15 08:18:21
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("${admin.url.prefix}/sys/lastOnline")
@RequiresPathPermission("sys:userlastonline")
public class UserLastOnlineController extends BaseCRUDController<UserLastOnline, Long> {

}
