package common.mybatis;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.util.StringUtils;

import common.separate.HandleDataSource;


public  class BaseDao<T extends BaseEntity,IdType> extends SqlSessionDaoSupport  implements IBaseDao<T, IdType>{

	//mapper类型
	protected IMapper<T, IdType> mapper;
	//T的类型
	protected Class type;
	//mapper类型
	protected Class mapperType;
	//切换数据源
	protected String source;
	//表明
	private String tableName;
	

	public BaseDao(){
		Class clazz = (Class)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		type=clazz;
		source = DataSourceMapping.getDataSource(type);
		
		this.mapperType = (Class)((ParameterizedType)clazz.getGenericSuperclass()).getActualTypeArguments()[1];
		
		try {
			Object obj = clazz.newInstance();
			@SuppressWarnings("unchecked")
			Method method = clazz.getMethod("tableName");
			tableName = source+"."+(String)method.invoke(obj);
			tableName = (String)method.invoke(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 获取当前实体所对应的Mapper
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private IMapper<T, IdType> getMapper() {
		HandleDataSource.putDataSource(source);
		return (IMapper<T, IdType>)getSqlSession().getMapper(mapperType);
	}
	
	@SuppressWarnings({ "unchecked" })
	private IMapper getMapper(String entityName) {
		HandleDataSource.putDataSource(DataSourceMapping.getDataSource(entityName));
		try {
			Class clazz = Class.forName(mapperType.getName().replace(type.getSimpleName(), entityName));
			return (IMapper)getSqlSession().getMapper(clazz);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(e);
		}
	}
	/**
	 * 增加
	 * @param entity 实体(集合)
	 * @return
	 */
	@Override
	public int add(T... entity) {
		if(entity == null || entity.length<=0){
    		return 0;
    	}
		List<T> entities = new ArrayList<T>();
		for (T en : entity) {
    		en.setDefaultValues();
    		entities.add(en);
		}
		int result = getMapper().add(entities);
		return result;
	}

	/**
   	 * 增加
   	 * @param entities 实体(集合)
   	 * @return
   	 */
	@Override
	public int add(List<T> entities) {
		if(entities == null || entities.size()<=0){
    		return 0;
    	}
		for (T en : entities) {
    		en.setDefaultValues();
		}
		int result = getMapper().add(entities);
		return result;
	}

	/**
	 * 删除
	 * @param id ID(集合)
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public int delete(IdType... id){
    	if(id == null || id.length<=0){
    		return 0;
    	}
		List<IdType> ids = new ArrayList<IdType>();
		for (IdType idType : id) {
			ids.add(idType);
		}
		return delete(ids);
	}
	
	/**
	 * 删除
	 * @param id ID(集合)
	 * @return 
	 */
	public int delete(List<IdType> ids){
    	if(ids == null || ids.size()<=0){
    		return 0;
    	}
    	int result = getMapper().delete(ids);
		return result;
	}
	
	/**
	 * 删除
	 * @param whereClause where条件
	 * @return
	 */
	@Override
	public int deleteBy(WhereClause whereClause) {
		if(StringUtils.isEmpty(whereClause.toString())){
    		throw new IllegalArgumentException("whereClause 参数不能为空！");
    	}
		String sqlwhere=whereClause.toString();
    	int result = getMapper().deleteBy(sqlwhere);
		return 0;
	}

	 /**
	 * 更新
	 * @param entity 实体(集合)
	 * @return
	 */
	@Override
	public int update(T entity) {
		if(entity == null){
    		return 0;
    	}
		List<T> entities = new ArrayList<T>();
    	entities.add(entity);
    	int result = getMapper().update(entities);
		return result;
	}
	/**
	 * 更新
	 * @param entity 实体(集合)
	 * @param whereClause where子句
	 * @return
	 */
    public int updateBy(T entity, WhereClause whereClause){
    	if(StringUtils.isEmpty(whereClause.toString())){
    		throw new IllegalArgumentException("whereClause 参数不能为空！");
    	}
    	int result = getMapper().updateBy(entity, whereClause.toString());
		return result;
    }
    
    /**
	 * 根据主键获取实体
	 * @param id ID
	 * @return 
	 */
    public T get(IdType id){
    	return getMapper().get(id);
    }
    /**
     * 根据唯一索引获取实体
     * @param columnName 列名
     * @param value 值
     * @return
     */
    public T get(String columnName, Object value) {
    	WhereClause whereClause = new WhereClause();
    	whereClause.add(columnName, value);
    	String where = whereClause.toString();
		List<T> data = getMapper().getList(where + " limit 1");
		if(null!=data && data.size() > 0){
    		return data.get(0);
    	}
    	return null;
    }
    /**
	 * 获取列表
	 * @param where where子句
	 * @return
	 */
    public List<T> getList(WhereClause whereClause){
    	return getMapper().getList(whereClause.toString());
    }
    
    /**
	 * 获取列表
	 * @param where where子句
	 * @param orderBy 排序，一个字段传 columnName desc/asc,多字段用“,”分隔
	 * @return
	 */
    public List<T> getList(WhereClause whereClause, String orderBy){
    	return getMapper().getList(whereClause.toString() + " order by "+ orderBy);
    }
    
    /**
	 * 获取所有数据
	 * @return
	 */
    public List<T> getAll(){
    	return getMapper().getList(null);
    }
    
    /**
	 * 获取所有数据,并排序
	 * @return
	 */
    public List<T> getAll(String orderBy){
    	return getMapper().getList(" order by " + orderBy);
    }
    
	/**
	 * 总数
	 * @return
	 */
    public long count(){
    	return getMapper().count(null);
    }
	/**
	 * 总数
	 * @param whereClause where子句
	 * @return
	 */
    public long count(WhereClause whereClause){
    	return getMapper().count(whereClause.toString());
    }
    /**
	 * 执行sql
	 * @param sql 完整的sql
	 * @return
	 */
    public List<? extends Object> runSql(String sql){
    	return getMapper().runSql(sql);
    }
    /**
	 * 获取分页数据
	 * @param whereClause where子句
	 * @param pageIndex 获取页码
	 * @param pageSize 分页大小
	 * @return
	 */
	public Pager<T> getPage(WhereClause whereClause, Integer pageIndex, Integer pageSize){
		return getPage(whereClause, null, pageIndex, pageSize);
	}

	/**
	 * 获取分页数据
	 * @param whereClause where子句
	 * @param orderBy 排序，一个字段传 columnName desc/asc,多字段用“,”分隔
	 * @param pageIndex 获取页码
	 * @param pageSize 分页大小
	 * @return
	 */
	public Pager<T> getPage(WhereClause whereClause, String orderBy, Integer pageIndex, Integer pageSize){
		String where = whereClause.toString();
		Long count = getMapper().count(where);
		
		if(null != orderBy && !"".equals(orderBy)){
			where += " order by " + orderBy;
		}
		
		List<T> data = getMapper().getList(where + " limit " + ((pageIndex - 1)*pageSize) + "," + pageSize);
		Pager<T> page = new Pager<T>(count, pageIndex, pageSize, data);
		return page;
	}
}


