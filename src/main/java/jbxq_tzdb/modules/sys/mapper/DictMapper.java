package jbxq_tzdb.modules.sys.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import jbxq_tzdb.modules.sys.entity.Dict;

public interface DictMapper extends BaseMapper<Dict> {
	List<Dict> selectDictList();
}