/**  
* <p>Title: CarItemServiceImpl.java</p>  
* <p>Description: </p>   
* @author QEcode  
* @date 2019年1月8日  
* @version 1.0  
*/  
package com.orangelala.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orangelala.mapper.CarItemMapper;
import com.orangelala.pojo.CarItem;
import com.orangelala.pojo.CarItemExample;
import com.orangelala.pojo.CarItemExample.Criteria;
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
    /**
     * @Description:根据购物车id和商品id查询
     * @param uid
     * @param cid
     * @return
     * @throws Exception
     */   
    @Override
    public CarItem getByItemidAndCid(Long itemId, Long cid) throws Exception {
	CarItemExample example = new CarItemExample();
	Criteria criteria  = example.createCriteria();
	criteria.andCarIdEqualTo(cid);
	criteria.andItemIdEqualTo(itemId);
	List<CarItem> carItems = carItemMapper.selectByExample(example);
	CarItem carItem = carItems.get(0);
	return carItem;
    }
    /**
     * @Description:
     * @param ids
     * @return
     * @throws Exception
     */
    @Override
    public List<CarItem> getCarItemsByIds(List<Long> ids) throws Exception {
	CarItemExample example = new CarItemExample();
	Criteria criteria = example.createCriteria();  
	criteria.andIdIn(ids);   
	List<CarItem> carItems = carItemMapper.selectByExample(example);
	return carItems;
    }
    /**
     * @Description:
     * @param carItem
     * @throws Exception
     */
    @Override
    public void updateCarItem(CarItem carItem) throws Exception {
	carItemMapper.updateByPrimaryKey(carItem);
    }
    
    
    /**
     * @author 澎仔
     * @Description:根据购物车id查询购物车内的商品
     */
	@Override
	public List<CarItem> getCarItems(Long carId) {
		CarItemExample carItemExample =new CarItemExample();
		Criteria criteria = carItemExample.createCriteria();
		criteria.andCarIdEqualTo(carId);  
		return carItemMapper.selectByExample(carItemExample);
	}
	@Override
	public void deleteCarItemById(Long id) {
		carItemMapper.deleteByPrimaryKey(id);
	}
    
   
    
}
