package common.mybatis;

import org.springframework.util.StringUtils;

/**
 * sql结构如下：select * form table where 1=1 + 条件集合
 *  条件结构：（and/or） columnName operator value
 * @author YJM
 */

public class SubWhere {
	
	//该条件连接类型（and/or）
	private SubWhereType subWhereType;
	//该条件的字段
	private String columnName;
	//该条件的查询类型
	private SubWhereOperator operator;
	//该条件的值
	private Object value;
	
	//isQuotes  值是否包含引号
	public SubWhere(SubWhereType subWhereType, String columnName, SubWhereOperator operator, Object value, Boolean isQuotes) {
		this.subWhereType = subWhereType;
		this.columnName = columnName;
		this.operator = operator;
		switch (operator) {
		case LIKE:
		case NOT_LIKE:
		case STARTWITH:
		case ENDWITH:
		case NOT_STARTWITH:
		case NOT_ENDWITH:
		case BETWEEN:
		case SUB_SQL:
/*		case IN:
		case NOT_IN:*/
			this.value = value;
			break;
			
		default:
			if(isQuotes){
				this.value = "'"+value+"'";
			}else{
				this.value = value;
			}
			break;
		}
	}
	
	public String toString(){
		String result = " ";
		result += subWhereType == SubWhereType.AND ? "and" : "or";
		String valueStr = value.toString();
		/*if(operator == SubWhereOperator.IN && StringUtils.isEmpty(valueStr)){
			valueStr = "'-99999999'";
		}*/
		result += " " + operator.toString().replaceAll("\\{0\\}", columnName).replaceAll("\\{1\\}", valueStr + "") + " ";
		
		return result;
	}
}
