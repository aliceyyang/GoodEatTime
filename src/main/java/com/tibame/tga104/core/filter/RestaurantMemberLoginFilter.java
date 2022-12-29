package com.tibame.tga104.core.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.tibame.tga104.member.vo.RestaurantMemberVO;


//需與組員討論除登入頁面外,需要放的網址列為何
@WebFilter({
	"/reservation/restaurant", 
	"/reservation/restaurant/statusChange",
	"/reservation/restaurant/inf",
	"/reservation/restaurant/reserveStatus",
	"/reservation/restaurant/reserveInf",
	"/reservation/restaurant/statusUpdate"
})

public class RestaurantMemberLoginFilter extends HttpFilter {
	private static final long serialVersionUID = 1L;
	
	public void init(FilterConfig fConfig) throws ServletException {
	}
	
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = request.getSession();
		RestaurantMemberVO restaurantMemberVO = (RestaurantMemberVO)session.getAttribute("restaurantMemberVO");
		
		//判斷有無會員登入
		if(restaurantMemberVO != null) {
		//已登入
			chain.doFilter(request, response);
		}else {
		//未登入導向登入頁面
			response.sendRedirect("/Front_End/j_login_restaurant4.html");
		}
		
	}

	


}
