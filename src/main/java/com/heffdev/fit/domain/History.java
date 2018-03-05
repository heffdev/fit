package com.heffdev.fit.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
public class History {

	public static final String tabelName = "history";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "data_id")
	private Long dataId;

	@Column(name = "table_name")
	private String tableName;

	@Column(name = "data")
	private String data;

	public History() {
		super();
	}

	public History(Long id, Long dataId, String tableName, String data) {
		super();
		this.id = id;
		this.dataId = dataId;
		this.tableName = tableName;
		this.data = data;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, true, null, new String[] {});
	}

	public String getData() {
		return data;
	}

	public Long getDataId() {
		return dataId;
	}

	public Long getId() {
		return id;
	}

	public String getTableName() {
		return tableName;
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

	public void setData(String data) {
		this.data = data;
	}

	public void setDataId(Long dataId) {
		this.dataId = dataId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
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
