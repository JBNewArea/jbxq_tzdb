package jbxq_tzdb.modules.codegen.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jbxq_tzdb.core.common.service.impl.CommonServiceImpl;
import jbxq_tzdb.core.query.wrapper.EntityWrapper;
import jbxq_tzdb.modules.codegen.entity.Column;
import jbxq_tzdb.modules.codegen.mapper.ColumnMapper;
import jbxq_tzdb.modules.codegen.service.IColumnService;

@Transactional
@Service("columnService")
public class ColumnServiceImpl extends CommonServiceImpl<ColumnMapper, Column> implements IColumnService {

	@Override
	public List<Column> selectListByTableId(String tableId) {
		EntityWrapper<Column> columnWrapper = new EntityWrapper<Column>(Column.class);
		columnWrapper.eq("table.id", tableId);
		columnWrapper.orderBy("sort");
		List<Column> oldColumnList = selectList(columnWrapper);
		return oldColumnList;
	}

}
