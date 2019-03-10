package com.gwtjs.icustom.security.entity;

import com.gwtjs.icustom.entity.BaseResource;

public class SysRoleResourceVO extends BaseResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4203811499633005155L;

	private int id;

	private long roleId; // 角色ID
	private String roleName; // 角色ID
	private long resourceId;// 资源ID
	private String resourceName;// 资源ID

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public long getResourceId() {
		return resourceId;
	}

	public void setResourceId(long resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	@Override
	public String toString() {
		return "{'id':'" + id + "', 'roleId':'" + roleId
				+ "', 'roleName':'" + roleName + "', 'resourceId':'" + resourceId
				+ "', 'resourceName':'" + resourceName + "'}";
	}

}
