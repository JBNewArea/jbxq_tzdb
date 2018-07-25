package jbxq_tzdb.modules.email.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jbxq_tzdb.core.common.controller.BaseCRUDController;
import jbxq_tzdb.core.security.shiro.authz.annotation.RequiresPathPermission;
import jbxq_tzdb.modules.email.entity.EmailSendLog;

/**   
 * @Title: 邮件发送日志
 * @Description: 邮件发送日志
 * @author jeeweb
 * @date 2017-06-10 07:46:06
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("${admin.url.prefix}/email/emailsendlog")
@RequiresPathPermission("email:emailsendlog")
public class EmailSendLogController extends BaseCRUDController<EmailSendLog, String> {

}
