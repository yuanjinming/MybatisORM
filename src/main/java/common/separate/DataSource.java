package common.separate;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * DataSource 切换数据源
 * @author YJM
 *
 */
@Retention(RetentionPolicy.RUNTIME)  
//@Target(ElementType.METHOD) 
public @interface DataSource {
	String value(); 
}
