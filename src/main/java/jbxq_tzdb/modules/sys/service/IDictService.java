package jbxq_tzdb.modules.sys.service;


import java.util.List;

import jbxq_tzdb.core.common.service.ICommonService;
import jbxq_tzdb.modules.sys.entity.Dict;

/**
 * @Title:
 * @Description:
 * @author jwcg
 * @date 2017-02-09 09:05:29
 * @version V1.0
 *
 */
public interface IDictService extends ICommonService<Dict> {
    public List<Dict> selectDictList();
}
