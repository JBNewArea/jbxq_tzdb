package jbxq_tzdb.modules.codegen.service;

import java.util.List;
import jbxq_tzdb.core.common.service.ICommonService;
import jbxq_tzdb.modules.codegen.entity.Column;

public interface IColumnService extends ICommonService<Column> {
	List<Column> selectListByTableId(String tableId);
}
