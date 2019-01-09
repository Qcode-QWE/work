/**  
* <p>Title: CarServiceImpl.java</p>  
* <p>Description: </p>   
* @author QEcode  
* @date 2019年1月8日  
* @version 1.0  
*/  
package com.orangelala.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orangelala.mapper.CarMapper;
import com.orangelala.pojo.Car;
import com.orangelala.pojo.CarExample;
import com.orangelala.pojo.CarExample.Criteria;
import com.orangelala.pojo.User;
import com.orangelala.service.CarService;

/**  
 * <p>Title: CarServiceImpl.java</p>  
 * <p>Description: </p>   
 * @author QEcode  
 * @date 2019年1月8日  
 * @version 1.0  
 */
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;
    
    /**
     * @Description:根据userId查询购物车
     * @param uid
     * @return
     * @throws Exception
     */
    @Override
    public Car getCarByUserId(Long uid) throws Exception {
	CarExample example = new CarExample();
	Criteria criteria = example.createCriteria();
	//根据user的id查询
	criteria.andUserIdEqualTo(uid);
	List<Car> cars = carMapper.selectByExample(example);
	Car car = null;
	if (cars!=null&&cars.size()>0) {
	    car = cars.get(0);
	}
	return car;
    }

}
