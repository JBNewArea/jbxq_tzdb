package jbxq_tzdb.modules.codegen.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jbxq_tzdb.core.common.controller.BaseCRUDController;
import jbxq_tzdb.core.security.shiro.authz.annotation.RequiresPathPermission;
import jbxq_tzdb.modules.codegen.entity.Scheme;

/**   
 * @Title: 生成方案
 * @Description: 代码生成方案
 * @author jeeweb
 * @date 2017-05-29 21:17:42
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("${admin.url.prefix}/codegen/scheme")
@RequiresPathPermission("codegen:scheme")
public class SchemeController extends BaseCRUDController<Scheme, String> {

}
