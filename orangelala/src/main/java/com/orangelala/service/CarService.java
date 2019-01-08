/**  
* <p>Title: CarService.java</p>  
* <p>Description: </p>   
* @author QEcode  
* @date 2019年1月8日  
* @version 1.0  
*/  
package com.orangelala.service;

import com.orangelala.pojo.Car;

/**  
 * <p>Title: CarService.java</p>  
 * <p>Description: </p>   
 * @author QEcode  
 * @date 2019年1月8日  
 * @version 1.0  
 */
public interface CarService {
    public Car getCarByUserId(Long uid) throws Exception;
}
