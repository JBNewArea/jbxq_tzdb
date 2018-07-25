package jbxq_tzdb.modules.email.service.impl;

import jbxq_tzdb.core.common.service.impl.CommonServiceImpl;
import jbxq_tzdb.modules.email.entity.EmailSendLog;
import jbxq_tzdb.modules.email.mapper.EmailSendLogMapper;
import jbxq_tzdb.modules.email.service.IEmailSendLogService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**   
 * @Title: 邮件发送日志
 * @Description: 邮件发送日志
 * @author jeeweb
 * @date 2017-06-10 07:46:06
 * @version V1.0   
 *
 */
@Transactional
@Service("emailSendLogService")
public class EmailSendLogServiceImpl  extends CommonServiceImpl<EmailSendLogMapper, EmailSendLog> implements  IEmailSendLogService {

	 
	 
}
