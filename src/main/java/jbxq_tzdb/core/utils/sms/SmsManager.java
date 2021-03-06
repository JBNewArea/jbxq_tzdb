package jbxq_tzdb.core.utils.sms;

import jbxq_tzdb.core.utils.sms.data.SmsResult;
import jbxq_tzdb.core.utils.sms.data.SmsTemplate;
import jbxq_tzdb.core.utils.sms.exception.NullException;
import jbxq_tzdb.core.utils.sms.sender.HuyiSmsSender;
import jbxq_tzdb.core.utils.sms.sender.SmsSender;

public class SmsManager {
	public static final SmsSender DEFAULT_SMS_SENDER = new HuyiSmsSender();
	protected SmsSender smsSender = DEFAULT_SMS_SENDER;
	public static SmsManager smsManager;

	public static SmsManager getSmsManager() {
		if (smsManager == null) {
			smsManager = new SmsManager();
		}
		return smsManager;
	}

	public SmsManager() {
		init();
	}

	public SmsManager(SmsSender smsSender) {
		setSmsSender(smsSender);
		init();
	}

	public void init() {
		if (smsSender == null) {
			smsSender = DEFAULT_SMS_SENDER;
		}
	}

	public void setSmsSender(SmsSender smsSender) {
		this.smsSender = smsSender;
	}

	public SmsSender getSmsSender() {
		return smsSender;
	}

	/**
	 * 
	 * 
	 * @param phone
	 *            手机号码
	 * @param templateId
	 *            模版ID
	 * @param datas
	 *            数据
	 * @return
	 * @throws SendException
	 * @throws NullException
	 */
	public SmsResult send(String phone, SmsTemplate smsTemplate, String... datas) throws NullException {
		if (smsSender == null) {
			throw new NullException("短信发送器不存在");
		}
		return smsSender.send(phone, smsTemplate, datas);
	}
}
