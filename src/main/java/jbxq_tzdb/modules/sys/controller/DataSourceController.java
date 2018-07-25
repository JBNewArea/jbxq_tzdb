package jbxq_tzdb.modules.sys.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jbxq_tzdb.core.common.controller.BaseCRUDController;
import jbxq_tzdb.core.model.AjaxJson;
import jbxq_tzdb.core.security.shiro.authz.annotation.RequiresPathPermission;
import jbxq_tzdb.modules.sys.data.SysDatabaseEnum;
import jbxq_tzdb.modules.sys.entity.DataSource;

/**
 * @Title: 数据源
 * @Description: 数据源
 * @author jeeweb
 * @date 2017-05-10 12:01:57
 * @version V1.0
 *
 */
@Controller
@RequestMapping("${admin.url.prefix}/sys/datasource")
@RequiresPathPermission("sys:datasource")
public class DataSourceController extends BaseCRUDController<DataSource, String> {

	@RequestMapping(value = "dataSourceParameter")
	@ResponseBody
	public AjaxJson dataSourceParameter(@RequestParam String dbType) {
		AjaxJson j = new AjaxJson();
		SysDatabaseEnum sysDatabaseEnum = SysDatabaseEnum.toEnum(dbType);

		if (sysDatabaseEnum != null) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("driverClass", sysDatabaseEnum.getDriverClass());
			map.put("url", sysDatabaseEnum.getUrl());
			map.put("dbtype", sysDatabaseEnum.getDbtype());
			j.setData(map);
		} else {
			j.setData(null);
		}
		return j;
	}
}
