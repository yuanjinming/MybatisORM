package common.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author YJM
 *
 * @param <T> 实体类
 * @param <IdType> 实体类主键类型
 */
public interface IMapper<T,IdType> {
	/**
	 * 删除
	 * @param id ID(集合)
	 * @return 
	 */
	int delete(List<IdType> id);
	/**
	 * 增加
	 * @param entity 实体(集合)
	 * @return
	 */
	int add(List<T> entity);
	/**
	 * 更新
	 * @param entity 实体(集合)
	 * @return
	 */
	int update(List<T> entity);
	/**
	 * 获取实体
	 * @param id ID
	 * @return 
	 */
	T get(IdType id);
	/**
	 * 获取列表
	 * @param where where子句
	 * @return
	 */
	List<T> getList(@Param("sqlClause")String where);
	/**
	 * 总数
	 * @param where where子句
	 * @return
	 */
	long count(@Param("sqlClause")String where);
	/**
	 * 执行sql
	 * @param sql 要执行的sql
	 * @return
	 */
	 List<? extends Object> runSql(@Param("sql")String sql);
	/**
	 * 删除
	 * @param where where子句
	 * @return
	 */
	int deleteBy(@Param("sqlClause")String where);
	/**
	 * 更新
	 * @param where where子句
	 * @param entity 实体(集合)
	 * @return
	 */
	int updateBy(@Param("entity")T entity,@Param("sqlClause") String where);
}
	
