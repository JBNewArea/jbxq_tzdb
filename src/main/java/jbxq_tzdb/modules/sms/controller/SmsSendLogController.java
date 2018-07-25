package jbxq_tzdb.modules.sms.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jbxq_tzdb.core.common.controller.BaseCRUDController;
import jbxq_tzdb.core.security.shiro.authz.annotation.RequiresPathPermission;
import jbxq_tzdb.modules.sms.entity.SmsSendLog;

/**   
 * @Title: 短信发送日志
 * @Description: 短信发送日志
 * @author jeeweb
 * @date 2017-06-08 12:56:37
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("${admin.url.prefix}/sms/smssendlog")
@RequiresPathPermission("sms:smssendlog")
public class SmsSendLogController extends BaseCRUDController<SmsSendLog, String> {

}
