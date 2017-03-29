package common.mybatis;

import java.util.Properties;

public class DataSourceMapping {
	private static Properties prop;
	static {
		load();
	}
	/**
	 * 获取配置值
	 * @param entity 实体类
	 * @return 所属链接
	 */
	public static String getDataSource(@SuppressWarnings("rawtypes") Class entity) {
		return getDataSource(entity.getSimpleName()); 
	}
	/**
	 * 获取配置值
	 * @param entityName 实体类名
	 * @return 所属链接
	 */
	public static String getDataSource(String entityName) {
		if(null == prop){
			load();
		}
		if(prop.containsKey(entityName)){
			return (String)prop.get(entityName);
		}else{
			throw new IllegalArgumentException("亲爱的程序猿，data-source.properties中没有找到实体“"+entityName+"”配置哦！");
		}
	}
	private static void load(){
		prop = new Properties();
		try{
			prop.load(DataSourceMapping.class.getClassLoader().getResourceAsStream("data-source.properties"));
		}catch(Throwable ex){
			throw new IllegalArgumentException("亲爱的程序猿，没有找到data-source.properties文件哦！", ex);
		}
	}
}
