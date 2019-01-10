/**  
* <p>Title: ItemParamItemServiceImpl.java</p>  
* <p>Description: </p>   
* @author QEcode  
* @date 2019年1月8日  
* @version 1.0  
*/  
package com.orangelala.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orangelala.mapper.ItemParamItemMapper;
import com.orangelala.pojo.ItemParamItem;
import com.orangelala.pojo.ItemParamItemExample;
import com.orangelala.pojo.ItemParamItemExample.Criteria;
import com.orangelala.service.ItemParamItemService;
import com.orangelala.utils.JsonUtils;

/**  
 * <p>Title: ItemParamItemServiceImpl.java</p>  
 * <p>Description: 商品规格</p>   
 * @author QEcode  
 * @date 2019年1月8日  
 * @version 1.0  
 */
@Service
public class ItemParamItemServiceImpl implements ItemParamItemService {

    @Autowired
    private ItemParamItemMapper itemParamItemMapper;
    /**
     * @Description:根据商品id查询商品规格
     * @param itemId
     * @return
     * @throws Exception
     */
    @Override
    public String getItemParamItem(Long itemId) throws Exception {
	ItemParamItemExample example  = new ItemParamItemExample();
	Criteria criteria = example.createCriteria();
	criteria.andItemIdEqualTo(itemId);
	List<ItemParamItem> itemParamItems = itemParamItemMapper.selectByExampleWithBLOBs(example);
	ItemParamItem itemParamItem = null;
	if (itemParamItems!=null&&itemParamItems.size()>0) {
		    itemParamItem = itemParamItems.get(0);
		    //把规格参数json数据转换成java对象
		    String paramData = itemParamItem.getParamData();
		    List<Map> jsonList = JsonUtils.jsonToList(paramData, Map.class);
			StringBuffer sb = new StringBuffer();
			sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"0\" class=\"Ptable\">\n");
			sb.append("    <tbody>\n");
			for(Map m1:jsonList) {
				sb.append("        <tr>\n");
				sb.append("            <th class=\"tdTitle\" colspan=\"2\">"+m1.get("group")+"</th>\n");
				sb.append("        </tr>\n");
				List<Map> list2 = (List<Map>) m1.get("params");
				for(Map m2:list2) {
					sb.append("        <tr>\n");
					sb.append("            <td class=\"tdTitle\">"+m2.get("k")+"</td>\n");
					sb.append("            <td>"+m2.get("v")+"</td>\n");
					sb.append("        </tr>\n");
				}
			}
			sb.append("    </tbody>\n");
			sb.append("</table>");
			//返回html片段
			return sb.toString();
		}
	return null;
    }

}
