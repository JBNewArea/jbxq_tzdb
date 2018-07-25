package jbxq_tzdb.modules.sys.service.impl;

import jbxq_tzdb.core.common.service.impl.CommonServiceImpl;
import jbxq_tzdb.modules.sys.entity.Dict;
import jbxq_tzdb.modules.sys.mapper.DictMapper;
import jbxq_tzdb.modules.sys.service.IDictService;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("dictService")
public class DictServiceImpl extends CommonServiceImpl<DictMapper, Dict> implements IDictService {

	@Override
	public List<Dict> selectDictList() {
		return baseMapper.selectDictList();
	}

}
