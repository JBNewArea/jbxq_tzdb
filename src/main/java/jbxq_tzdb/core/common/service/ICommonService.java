package jbxq_tzdb.core.common.service;

import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;

import jbxq_tzdb.core.common.data.DuplicateValid;
import jbxq_tzdb.core.query.data.Page;
import jbxq_tzdb.core.query.data.Queryable;

public interface ICommonService<T> extends IService<T> {

	public Page<T> list(Queryable queryable);
	
	public Page<T> list(Queryable queryable, Wrapper<T> wrapper);

	public List<T> listWithNoPage(Queryable queryable);

	public List<T> listWithNoPage(Queryable queryable, Wrapper<T> wrapper);

	Boolean doValid(DuplicateValid duplicateValid, Wrapper<T> wrapper);
}