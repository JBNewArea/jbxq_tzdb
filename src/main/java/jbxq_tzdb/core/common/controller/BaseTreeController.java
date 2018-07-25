package jbxq_tzdb.core.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;

import jbxq_tzdb.core.common.entity.AbstractEntity;
import jbxq_tzdb.core.common.entity.tree.BootstrapTreeHelper;
import jbxq_tzdb.core.common.entity.tree.BootstrapTreeNode;
import jbxq_tzdb.core.common.entity.tree.TreeNode;
import jbxq_tzdb.core.common.entity.tree.TreeSortUtil;
import jbxq_tzdb.core.common.service.ICommonService;
import jbxq_tzdb.core.common.service.ITreeCommonService;
import jbxq_tzdb.core.model.PageJson;
import jbxq_tzdb.core.query.data.PropertyPreFilterable;
import jbxq_tzdb.core.query.data.QueryPropertyPreFilter;
import jbxq_tzdb.core.query.data.Queryable;
import jbxq_tzdb.core.query.wrapper.EntityWrapper;
import jbxq_tzdb.core.utils.ObjectUtils;
import jbxq_tzdb.core.utils.StringUtils;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseTreeController<Entity extends AbstractEntity<ID> & TreeNode<ID>, ID extends Serializable>
		extends BaseCRUDController<Entity, ID> {

	ITreeCommonService<Entity, ID> treeCommonService;

	@Autowired
	public void treeCommonService(ITreeCommonService<Entity, ID> treeCommonService) {
		this.treeCommonService = treeCommonService;
		setCommonService((ICommonService<Entity>) treeCommonService);
	}

	/**
	 * 根据页码和每页记录数，以及查询条件动态加载数据
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "treeData")
	public void treeData(Queryable queryable,
			@RequestParam(value = "nodeid", required = false, defaultValue = "") ID nodeid,
			@RequestParam(value = "async", required = false, defaultValue = "false") boolean async,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		EntityWrapper<Entity> entityWrapper = new EntityWrapper<Entity>(entityClass);
		entityWrapper.setTableAlias("t.");
		List<Entity> treeNodeList = null;
		if (!async) { // 非异步 查自己和子子孙孙
			treeNodeList = treeCommonService.selectTreeList(queryable, entityWrapper);
			TreeSortUtil.create().sort(treeNodeList).async(treeNodeList);
		} else { // 异步模式只查自己
			// queryable.addCondition("parentId", nodeid);
			if (ObjectUtils.isNullOrEmpty(nodeid)) {
				// 判断的应该是多个OR条件
				entityWrapper.isNull("parentId");
			} else {
				entityWrapper.eq("parentId", nodeid);
			}
			treeNodeList = treeCommonService.selectTreeList(queryable, entityWrapper);
			TreeSortUtil.create().sync(treeNodeList);
		}
		PropertyPreFilterable propertyPreFilterable = new QueryPropertyPreFilter();
		propertyPreFilterable.addQueryProperty("id", "name", "expanded", "hasChildren", "leaf", "loaded", "level",
				"parentId");
		SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
		PageJson<Entity> pagejson = new PageJson<Entity>(treeNodeList);
		String content = JSON.toJSONString(pagejson, filter);
		StringUtils.printJson(response, content);
	}

	/**
	 * 根据页码和每页记录数，以及查询条件动态加载数据
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "ajaxTreeList", method ={ RequestMethod.GET, RequestMethod.POST })
	private void ajaxTreeList(Queryable queryable,
			@RequestParam(value = "nodeid", required = false, defaultValue = "") ID nodeid,
			@RequestParam(value = "async", required = false, defaultValue = "false") boolean async,
			HttpServletRequest request, HttpServletResponse response, PropertyPreFilterable propertyPreFilterable)
			throws IOException {
		EntityWrapper<Entity> entityWrapper = new EntityWrapper<Entity>(entityClass);
		entityWrapper.setTableAlias("t.");
		preAjaxList(queryable, entityWrapper, request, response);

		List<Entity> treeNodeList = null;
		if (!async) { // 非异步 查自己和子子孙孙
			treeNodeList = treeCommonService.selectTreeList(queryable, entityWrapper);
			TreeSortUtil.create().sort(treeNodeList).async(treeNodeList);
		} else { // 异步模式只查自己
			// queryable.addCondition("parentId", nodeid);
			if (ObjectUtils.isNullOrEmpty(nodeid)) {
				// 判断的应该是多个OR条件
				entityWrapper.isNull("parentId");
			} else {
				entityWrapper.eq("parentId", nodeid);
			}
			treeNodeList = treeCommonService.selectTreeList(queryable, entityWrapper);
			TreeSortUtil.create().sync(treeNodeList);
		}
		propertyPreFilterable.addQueryProperty("id", "expanded", "hasChildren", "leaf", "loaded", "level", "parentId");
		SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
		PageJson<Entity> pagejson = new PageJson<Entity>(treeNodeList);
		String content = JSON.toJSONString(pagejson, filter);
		StringUtils.printJson(response, content);
	}

	/**
	 * 根据页码和每页记录数，以及查询条件动态加载数据
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "bootstrapTreeData")
	private void bootstrapTreeData(Queryable queryable,
			@RequestParam(value = "nodeid", required = false, defaultValue = "") ID nodeid, HttpServletRequest request,
			HttpServletResponse response, PropertyPreFilterable propertyPreFilterable) throws IOException {
		EntityWrapper<Entity> entityWrapper = new EntityWrapper<Entity>(entityClass);
		entityWrapper.setTableAlias("t.");
		List<Entity> treeNodeList = treeCommonService.selectTreeList(queryable, entityWrapper);
		List<BootstrapTreeNode> bootstrapTreeNodes = BootstrapTreeHelper.create().sort(treeNodeList);
		propertyPreFilterable.addQueryProperty("text", "href", "tags", "nodes");
		SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
		String content = JSON.toJSONString(bootstrapTreeNodes, filter);
		StringUtils.printJson(response, content);
	}

}
