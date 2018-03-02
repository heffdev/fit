package com.heffdev.sns.repository;

import org.springframework.data.repository.CrudRepository;

import com.heffdev.sns.domain.History;

public interface HistoryRepository extends CrudRepository<History, Long> {
	public void deleteByDataIdAndTableName(Long dataId, String tableName);
}
