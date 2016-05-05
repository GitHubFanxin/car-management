package pers.fanxin.carmanagement.security.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="t_role")
public class Role{
	@Id
	@Column(name="role_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long roleId;
	private String roleName;
	private String description;
	@ManyToMany(targetEntity=Permission.class)
	@JoinTable(name="role_permission",
			joinColumns=@JoinColumn(name="role_id",
					referencedColumnName="role_id"),
			inverseJoinColumns=@JoinColumn(name="permission_id",
					referencedColumnName="permission_id"))
	private Set<Permission> Permissions = new HashSet<Permission>();
	
	@ManyToMany(targetEntity=User.class)
	@JoinTable(name="user_role",
			joinColumns=@JoinColumn(name="role_id"
				,referencedColumnName="role_id"), 
			inverseJoinColumns=@JoinColumn(name="user_id"
				,referencedColumnName="user_id")
			)
	private Set<User> user=new HashSet<User>();
	
	public Set<User> getUser() {
		return user;
	}
	public void setUser(Set<User> user) {
		this.user = user;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Permission> getPermissions() {
		return Permissions;
	}
	public void setPermissions(Set<Permission> permissions) {
		Permissions = permissions;
	}

}
