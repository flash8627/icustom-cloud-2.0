package com.gwtjs.icustom.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.gwtjs.icustom.entity.PageVO;

/**
 * <b>function:</b> 
 * BaseSqlMapper继承SqlMapper，对Mapper进行接口封装，提供常用的增删改查组件；
 * @version 1.0
 */
public interface BaseSqlMapper<T> extends SqlMapper {

    public void add(T entity) throws DataAccessException;

    public void edit(T entity) throws DataAccessException;

    public void remvoe(T entity) throws DataAccessException;

    public T get(T entity) throws DataAccessException;

    public List<T> getList(T entity) throws DataAccessException;
    
    List<T> selectList(T record,PageVO page);

	int selectListCount(T record);

	int batchRemovePks(List<T> records);

	int batchUpdate(List<T> records);

	int batchInsert(List<T> records);
}