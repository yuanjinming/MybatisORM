package common.mybatis;

/**
 * 判定条件运算符
 * @author YJM
 *
 */
public enum SubWhereOperator {
	/**
	 * 等于
	 */
	EQUEAL("{0} = {1}"),
	/**
	 * 不等于
	 */
	NOT_EQUEAL("{0} <> {1}"),
	/**
	 * 小于
	 */
	LESS("{0} < {1}"),
	/**
	 * 不小于，大于或等于
	 */
	NOT_LESS("{0} >= {1}"),
	/**
	 * 大于
	 */
	GREATER("{0} > {1}"),
	/**
	 * 不大于，小于或等于
	 */
	NOT_GREATER("{0} <= {1}"),
	/**
	 * 包含
	 */
	LIKE("{0} like '%{1}%'"),
	/**
	 * 不包含
	 */
	NOT_LIKE("{0} not like '%{1}%'"),
	/**
	 * 以...开始
	 */
	STARTWITH("{0} like '{1}%'"),
	/**
	 * 以...结束
	 */
	ENDWITH("{0} like '%{1}'"),
	/**
	 * 不以...开始
	 */
	NOT_STARTWITH("{0} not like '{1}%'"),
	/**
	 * 不以...结束
	 */
	NOT_ENDWITH("{0} not like '%{1}'"),
	/**
	 * 在...之间
	 */
	BETWEEN("{0} between {1}"),
	/**
	 * 子句
	 */
	SUB_SQL("({1})"),
	/**
	 * 在  IN和NOT IN 还没有实现
	 *//*
	IN("{0} in ({1})"),
	*//**
	 * 不在
	 *//*
	NOT_IN("{0} not in ({1})")*/;
	
	private String operator;
	private SubWhereOperator(String operator){
		this.operator = operator;
	}
	public String toString(){
		return operator;
	}
}
