package com.heffdev.fit.repository;

import org.springframework.data.repository.CrudRepository;

import com.heffdev.fit.domain.History;

public interface HistoryRepository extends CrudRepository<History, Long> {
	public void deleteByDataIdAndTableName(Long dataId, String tableName);
}
