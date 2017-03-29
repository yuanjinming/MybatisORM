/**   
* @Title: DynamicDataSource.java
* @Description: 
* @author seven   
* @date 2014-10-14 上午9:32:33
* @version V1.0   
*/


package common.separate;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @ClassName: DynamicDataSource
 * @Description: 
 * @author yjm
 * @date 2014-10-14 上午9:32:33
 * 
 */

public class DynamicDataSource extends AbstractRoutingDataSource{
	
	@Override
	protected Object determineCurrentLookupKey() {
		 return HandleDataSource.getDataSource();  
	}

}

