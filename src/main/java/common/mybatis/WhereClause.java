package common.mybatis;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class WhereClause {

	List<SubWhere> subWheres;
	public WhereClause(){
		subWheres = new ArrayList<SubWhere>();
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(SubWhere subWhere : subWheres){
			sb.append(subWhere.toString() + " ");
		}
		return sb.toString();
	}
	/**
	 * 添加where子句。
	 * @param subWhere
	 */
	public void add(SubWhere subWhere){
		subWheres.add(subWhere);
	}
	
	/**
	 * 添加where子句
	 * 判定条件运算符   默认 equal。
	 * 是否加单引号       string 和data类型默认 true,其他默认false。
	 * 条件连接类型        默认 and。
	 * @param columnName 列名
	 * @param value 值
	 */
	public void add(String columnName, Object value){
		add(columnName, value, SubWhereOperator.EQUEAL);
	}
	
	/**
	 * 添加where子句。
	 * operator 判定条件运算符 。
	 * 是否加单引号    string 和data类型默认 true,其他默认false。
	 * 条件连接类型   默认 and。
	 * @param columnName 列名
	 * @param value 值
	 */
	public void add(String columnName, Object value, SubWhereOperator operator){
		add(columnName, value, operator, value != null && (value.getClass() == String.class || value.getClass() == Date.class));
	}
	
	/**
	 * 添加where子句。
	 * 条件连接类型  默认 and
	 * @param columnName 列名
	 * @param value 值
	 * @param operator 判定条件运算符 
	 * @param isQuotes 是否加单引号
	 */
	public void add(String columnName, Object value, SubWhereOperator operator, Boolean isQuotes){
		add(columnName, value, operator, isQuotes, SubWhereType.AND);
	}
	
	/**
	 * 添加where子句
	 * @param columnName 列名
	 * @param value 值
	 * @param operator 判定条件运算符
	 * @param isQuotes 是否加单引号
	 * @param subWhereType 条件连接类型
	 */
	public void add(String columnName, Object value, SubWhereOperator operator, Boolean isQuotes, SubWhereType subWhereType){
		if(value.getClass() == Date.class){
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			value = sdf.format(value);
			isQuotes = true;
		}
		SubWhere subWhere = new SubWhere(subWhereType, columnName, operator, value, isQuotes);
		subWheres.add(subWhere);
	}
	
	
	
	/**
	 * 添加between子句。
	 * value1，value2默认不加引号
	 * @param columnName 列名
	 * @param value1 值1
	 * @param value2 值2
	 */
	public void addBetween(String columnName, Object value1, Object value2){
		addBetween(columnName, value1, value2, false);
	}
	/**
	 * 添加between子句。
	 * 条件连接类型 默认为and
	 * @param columnName 列名
	 * @param value1 值1
	 * @param value2 值2
	 * @param isQuotes 是否加单引号 
	 */
	public void addBetween(String columnName, Object value1, Object value2, Boolean isQuotes){
		addBetween(columnName, value1, value2, isQuotes, SubWhereType.AND);
	}
	/**
	 * 添加between子句
	 * @param columnName 列名
	 * @param value1 值1
	 * @param value2 值2
	 * @param isQuotes 是否加单引号
	 * @param subWhereType 子句类型
	 */
	public void addBetween(String columnName, Object value1, Object value2, Boolean isQuotes, SubWhereType subWhereType){
		String value = "";
		if(isQuotes){
			value = "'"+value1+"' and '" + value2 + "'";
		}else{
			value = value1+" and " + value2;
		}
		add(columnName, value, SubWhereOperator.BETWEEN, false, subWhereType);
	}
	
	/**
	 * 添加时间范围子句。
	 * 条件连接类型 默认为and
	 * @param columnName 列名
	 * @param fromDate 开始时间
	 * @param toDate 结束时间
	 */
	public void add(String columnName, Date fromDate, Date toDate){
		add(columnName, fromDate, toDate, SubWhereType.AND);
	}
	/**
	 * 添加时间范围子句
	 * @param columnName 列名
	 * @param fromDate 开始时间
	 * @param toDate 结束时间
	 * @param subWhereType 条件连接类型
	 */
	public void add(String columnName, Date fromDate, Date toDate, SubWhereType subWhereType){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(toDate);
		calendar.add(Calendar.DATE, 1);
		addBetween(columnName, format.format(fromDate), format.format(calendar.getTime()), true, subWhereType);
	}
	
	/**
	 * 判断where条件是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return subWheres.size() <= 0;
	}
	/**
	 * 判断where条件是否为空
	 * @param whereClause 
	 * @return
	 */
	public static boolean isEmpty(WhereClause whereClause){
		return whereClause == null || whereClause.isEmpty();
	}
}
