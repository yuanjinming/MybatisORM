/**   
* @Title: HandleDataSource.java
* @Description: 
* @author seven   
* @date 2014-10-14 上午9:28:43
* @version V1.0   
*/


package common.separate;

/**
 * @ClassName: HandleDataSource
 * @Description: 
 * @author yjm
 * @date 2014-10-14 上午9:28:43
 * 
 */

public class HandleDataSource {
    public static final ThreadLocal<String> holder = new ThreadLocal<String>();  
    public static void putDataSource(String datasource) {  
        holder.set(datasource);  
    }  
      
    public static String getDataSource() {  
        return holder.get();  
    } 
    
    public static void removeDataSource(){
    	holder.remove();
    }
}
