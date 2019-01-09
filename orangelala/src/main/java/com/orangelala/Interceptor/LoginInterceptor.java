/**  
* <p>Title: LoginInterceptor.java</p>  
* <p>Description: </p>   
* @author QEcode  
* @date 2019年1月9日  
* @version 1.0  
*/  
package com.orangelala.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.orangelala.pojo.User;

/**  
 * <p>Title: LoginInterceptor.java</p>  
 * <p>Description: </p>   
 * @author QEcode  
 * @date 2019年1月9日  
 * @version 1.0  
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    
    /** 
     * 在业务处理器处理请求之前被调用 
     * 如果返回false 
     *     从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
     *     
     * 如果返回true 
     *    执行下一个拦截器,直到所有的拦截器都执行完毕 
     *    再执行被拦截的Controller 
     *    然后进入拦截器链, 
     *    从最后一个拦截器往回执行所有的postHandle() 
     *    接着再从最后一个拦截器往回执行所有的afterCompletion() 
     */  
    @Override  
    public boolean preHandle(HttpServletRequest request,  
            HttpServletResponse response, Object handler) throws Exception {
	//
	HttpSession session = request.getSession();
	User user = (User) session.getAttribute("user");
	if(user==null){
	    response.sendRedirect(request.getContextPath()+"/loginUI.html");
	    return false;
	}
	return true;
    }
    
}
