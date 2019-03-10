package com.gwtjs.icustom.security.entity;

import com.gwtjs.icustom.entity.TreeModel;

/**
 * 系统资源-主要是系统菜单路径
 * @author aGuang
 *
 */
public class SysResourceVO extends TreeModel<SysResourceVO> {

	/***/
	private static final long serialVersionUID = -8724114844194419901L;

	private String resourceUrl;// url

	private long resourceId;// 资源ID

	private String remark;// 备注

	private String resourceName;// 资源名称

	private String methodName;// 资源所对应的方法名

	private String methodPath;// 资源所对应的包路径

	// 上级
	private long parentId;
	
	

	public String getResourceUrl() {
		return resourceUrl;
	}

	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

	public long getResourceId() {
		return resourceId;
	}

	public void setResourceId(long resourceId) {
		this.resourceId = resourceId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getMethodPath() {
		return methodPath;
	}

	public void setMethodPath(String methodPath) {
		this.methodPath = methodPath;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return "{'resourceUrl':'" + resourceUrl + "', 'resourceId':'"
				+ resourceId + "', 'remark':'" + remark + "', 'resourceName':'"
				+ resourceName + "', 'methodName':'" + methodName + "', 'methodPath':'"
				+ methodPath + "', 'parentId':'" + parentId + "'}";
	}

}
