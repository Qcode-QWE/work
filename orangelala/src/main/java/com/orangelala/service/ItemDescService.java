/**  
* <p>Title: ItemDescService.java</p>  
* <p>Description: </p>   
* @author QEcode  
* @date 2019年1月8日  
* @version 1.0  
*/  
package com.orangelala.service;

import com.orangelala.pojo.ItemDesc;

/**  
 * <p>Title: ItemDescService.java</p>  
 * <p>Description: </p>   
 * @author QEcode  
 * @date 2019年1月8日  
 * @version 1.0  
 */
public interface ItemDescService {
    public ItemDesc getItemDesc(Long itemId) throws Exception;
    
}
