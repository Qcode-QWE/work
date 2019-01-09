/**  
* <p>Title: CarItemService.java</p>  
* <p>Description: </p>   
* @author QEcode  
* @date 2019年1月8日  
* @version 1.0  
*/  
package com.orangelala.service;

import java.util.List;

import com.orangelala.pojo.CarItem;

/**  
 * <p>Title: CarItemService.java</p>  
 * <p>Description: </p>   
 * @author QEcode  
 * @date 2019年1月8日  
 * @version 1.0  
 */
public interface CarItemService {
    public void saveCarItem(CarItem carItem) throws Exception;
    public CarItem getByItemidAndCid(Long Itemid,Long cid) throws Exception;
    public List<CarItem> getCarItemsByIds(List<Long> ids) throws Exception;
    public void updateCarItem(CarItem carItem) throws Exception;
}
