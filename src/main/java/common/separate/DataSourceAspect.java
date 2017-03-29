/**   
 * @Title: DataSourceAspect.java
 * @Description: 
 * @author seven   
 * @date 2014-10-14 上午9:24:23
 * @version V1.0   
 */

package common.separate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * @ClassName: DataSourceAspect
 * @Description:
 * @author YJM
 * 
 */
// @Aspect
// @Component
public class DataSourceAspect {
	public void pointCut() {
	};

	// @Before(value = "pointCut()")
	public void before(JoinPoint point) {
		Object target = point.getTarget();
		String method = point.getSignature().getName();
		Class<?> classz = target.getClass();
		Class<?>[] parameterTypes = ((MethodSignature) point.getSignature())
				.getMethod().getParameterTypes();
		try {
			Method m = classz.getMethod(method, parameterTypes);
			Annotation[] as = m.getAnnotations();
			for(Annotation a :as){
				System.out.println(a.getClass().getName());
			}
			if (classz.isAnnotationPresent(DataSource.class)  ) {
				if(m != null && m.isAnnotationPresent(DataSource.class)){
					DataSource data = m.getAnnotation(DataSource.class);
					HandleDataSource.putDataSource(data.value());
				}else{
					DataSource data = classz.getAnnotation(DataSource.class);
					HandleDataSource.putDataSource(data.value());
				}
			}else{
				if(m != null && m.isAnnotationPresent(DataSource.class)){
					DataSource data = m.getAnnotation(DataSource.class);
					HandleDataSource.putDataSource(data.value());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
