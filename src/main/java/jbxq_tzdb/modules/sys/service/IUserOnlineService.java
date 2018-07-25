package jbxq_tzdb.modules.sys.service;

import jbxq_tzdb.core.common.service.ICommonService;
import jbxq_tzdb.core.query.data.Page;
import jbxq_tzdb.modules.sys.entity.UserOnline;

import java.util.Date;
import java.util.List;

public interface IUserOnlineService extends ICommonService<UserOnline> {

	/**
	 * 上线
	 *
	 * @param userOnline
	 */
	public void online(UserOnline userOnline);

	/**
	 * 下线
	 *
	 * @param sid
	 */
	public void offline(String sid);

	/**
	 * 批量下线
	 *
	 * @param needOfflineIdList
	 */
	public void batchOffline(List<String> needOfflineIdList);

	/**
	 * 无效的UserOnline
	 *
	 * @return
	 */
	public Page<UserOnline> findExpiredUserOnlineList(Date expiredDate, int page, int rows);

}
