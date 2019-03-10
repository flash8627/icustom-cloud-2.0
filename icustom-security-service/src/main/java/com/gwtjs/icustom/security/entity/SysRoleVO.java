package com.gwtjs.icustom.security.entity;

import com.gwtjs.icustom.entity.BaseResource;

/**
 * 系统角色表
 * @author aGuang
 *
 */
public class SysRoleVO extends BaseResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3048274432307622364L;

	private long id;

	private String rolename;// 角色名称

	private String roleCode;// 角色名称

	private String remark;// 角色描述

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((rolename == null) ? 0 : rolename.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SysRoleVO other = (SysRoleVO) obj;
		if (id != other.id)
			return false;
		if (rolename == null) {
			if (other.rolename != null)
				return false;
		} else if (!rolename.equals(other.rolename))
			return false;
		return true;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	@Override
	public String toString() {
		return "{'id':'" + id + "', 'rolename':'" + rolename+ "', 'roleCode':'" + roleCode + "', 'remark':'" + remark + "'}";
	}

}
