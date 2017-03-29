package common.mybatis;

public abstract class BaseEntity<IdType,MapperType> {
	/**
	 * 获取主键值
	 * @return
	 */
	public abstract IdType getPrimaryKey();
	
	public abstract String tableName();
	
	@Deprecated
	public abstract void setDefaultValues();
}
