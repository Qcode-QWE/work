/**  
* <p>Title: CarItemServiceImpl.java</p>  
* <p>Description: </p>   
* @author QEcode  
* @date 2019年1月8日  
* @version 1.0  
*/  
package com.orangelala.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orangelala.mapper.CarItemMapper;
import com.orangelala.pojo.CarItem;
import com.orangelala.service.CarItemService;

/**  
 * <p>Title: CarItemServiceImpl.java</p>  
 * <p>Description: </p>   
 * @author QEcode  
 * @date 2019年1月8日  
 * @version 1.0  
 */
@Service
public class CarItemServiceImpl implements CarItemService {

    @Autowired
    private CarItemMapper carItemMapper;
    /**
     * @Description:保存
     * @param carItem
     * @throws Exception
     */
    @Override
    public void saveCarItem(CarItem carItem) throws Exception {
	carItemMapper.insert(carItem);
    }
    
}
