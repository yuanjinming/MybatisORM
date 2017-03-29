package common.mybatis;
/**
 * 条件连接类型
 * 该条件和前面一个条件的中间连接是and 或者or
 * @author YJM
 *
 */
public enum SubWhereType {
	/**
	 * and语句
	 */
	AND,
	/**
	 * or语句
	 */
	OR
}
