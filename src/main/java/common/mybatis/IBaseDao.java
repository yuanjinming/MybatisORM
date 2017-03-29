package common.mybatis;

import java.util.List;

public interface IBaseDao<T,IdType> {

	/**
	 * 增加
	 * @param entity 实体(集合)
	 * @return
	 */
    int add(T... entity);
    
    /**
   	 * 增加
   	 * @param entities 实体(集合)
   	 * @return
   	 */
     int add(List<T> entities);
     
     /**
 	 * 删除
 	 * @param id ID(集合)
 	 * @return 
 	 */
 	int delete(@SuppressWarnings("unchecked") IdType... id);
 	
 	/**
	 * 删除
	 * @param ids ID(集合)
	 * @return 
	 */
	int delete(List<IdType> ids);
	
	/**
	 * 删除
	 * @param whereClause where子句
	 * @return
	 */
    int deleteBy(WhereClause whereClause);
    
    /**
	 * 更新
	 * @param entity 实体(集合)
	 * @return
	 */
    int update(T entity);
    
    /**
	 * 更新
	 * @param entity 实体(集合)
	 * @param whereClause where子句
	 * @return
	 */
    int updateBy(T entity, WhereClause whereClause);
    
    /**
	 * 根据主键获取实体
	 * @param id ID
	 * @return 
	 */
    T get(IdType id);
    
    /**
     * 根据唯一索引获取实体
     * @param columnName 列名
     * @param value 值
     * @return
     */
    T get(String columnName, Object value);
    
    /**
	 * 获取列表
	 * @param where where子句
	 * @return
	 */
    List<T> getList(WhereClause whereClause);
    
    /**
	 * 获取列表
	 * @param where where子句
	 * @param orderBy 排序，一个字段传 columnName desc/asc,多字段用“,”分隔
	 * @return
	 */
    List<T> getList(WhereClause whereClause, String orderBy);
    
    /**
	 * 获取所有数据
	 * @return
	 */
    List<T> getAll();
    
    /**
	 * 获取所有数据,并排序
	 * @return
	 */
    List<T> getAll(String orderBy);
    /**
	 * 总数
	 * @return
	 */
    long count();
	/**
	 * 总数
	 * @param whereClause where子句
	 * @return
	 */
    long count(WhereClause whereClause);
    /**
	 * 执行sql
	 * @param sql 完整的sql
	 * @return
	 */
	List<? extends Object> runSql(String sql);
	
	/**
	 * 获取分页数据
	 * @param whereClause where子句
	 * @param pageIndex 获取页码
	 * @param pageSize 分页大小
	 * @return
	 */
	Pager<T> getPage(WhereClause whereClause, Integer pageIndex, Integer pageSize);

	/**
	 * 获取分页数据
	 * @param whereClause where子句
	 * @param orderBy 排序，一个字段传 columnName desc/asc,多字段用“,”分隔
	 * @param pageIndex 获取页码
	 * @param pageSize 分页大小
	 * @return
	 */
	Pager<T> getPage(WhereClause whereClause, String orderBy, Integer pageIndex, Integer pageSize);

}
