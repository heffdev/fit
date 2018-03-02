package com.heffdev.sns.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity(name = "UserRole")
@Table(name = "user_roles")
public class UserRole {

	public static final String tableName = "user_roles";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "username")
	private User username;

	@Column(name = "role")
	private String role;

	/**
	 *
	 */
	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param username
	 * @param role
	 */
	public UserRole(Long id, User username, String role) {
		super();
		this.id = id;
		this.username = username;
		this.role = role;
	}

	public Long getId() {
		return this.id;
	}

	public String getRole() {
		return this.role;
	}

	public User getUsername() {
		return this.username;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, true);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setUsername(User username) {
		this.username = username;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public String toStringJson() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}

}
