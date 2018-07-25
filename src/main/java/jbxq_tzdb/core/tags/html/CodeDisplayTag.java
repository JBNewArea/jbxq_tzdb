package jbxq_tzdb.core.tags.html;

import java.util.HashMap;
import java.util.Map;
import jbxq_tzdb.core.tags.html.manager.HtmlComponentManager;
import jbxq_tzdb.core.utils.SpringContextHolder;
import jbxq_tzdb.core.utils.StringUtils;
import jbxq_tzdb.modules.sys.tags.SysFunctions;

@SuppressWarnings("serial")
public class CodeDisplayTag extends DisplayTag {
	protected HtmlComponentManager htmlComponentManager = SpringContextHolder.getApplicationContext()
			.getBean(HtmlComponentManager.class);
	// 代码类型
	private String codeType = "java";

	@Override
	protected String getContent() {
		String bodyContent = super.getContent();
		Map<String, Object> rootMap = new HashMap<String, Object>();
		String ctx = pageContext.getServletContext().getContextPath() + SysFunctions.getAdminUrlPrefix();
		String adminPath = pageContext.getServletContext().getContextPath() + SysFunctions.getAdminUrlPrefix()+"/admin";
		String staticPath = pageContext.getServletContext().getContextPath() + "/static";
		rootMap.put("ctx", ctx);
		rootMap.put("adminPath", adminPath);
		rootMap.put("staticPath", staticPath);
		rootMap.put("codeType", codeType.toLowerCase());
		rootMap.put("bodyContent", bodyContent);
		String fragment = htmlComponentManager.getFragmentComponent("syntaxhighlighter-code", rootMap);
		if (!StringUtils.isEmpty(fragment) && !fragment.equals("null")) {
			// 获得编辑器
			return fragment;
		}
		return bodyContent;
	}

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

}