package jbxq_tzdb.modules.sys.service.impl;

import jbxq_tzdb.core.common.service.impl.CommonServiceImpl;
import jbxq_tzdb.modules.sys.entity.DictGroup;
import jbxq_tzdb.modules.sys.mapper.DictGroupMapper;
import jbxq_tzdb.modules.sys.service.IDictGroupService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("dictGroupService")
public class DictGroupServiceImpl extends CommonServiceImpl<DictGroupMapper,DictGroup> implements IDictGroupService {
}
