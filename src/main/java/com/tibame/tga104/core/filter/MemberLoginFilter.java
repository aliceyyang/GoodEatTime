package com.tibame.tga104.core.filter;

import java.io.IOException;
import javax.servlet.Filter;
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

import org.hibernate.internal.build.AllowSysOut;

import com.tibame.tga104.member.vo.MemberVO;


//需與組員討論除登入頁面外,需要放的網址列為何
@WebFilter({
	"/cart/allDetail", 
	"/cart/insert", 
	"/cart/insertQty", 
	"/cart/update", 
	"/cart/delete", 
	"/order/**",
	"/member/info",
	"/reservation/member/inf",
	"/reservation/member"
})

public class MemberLoginFilter extends HttpFilter {
	private static final long serialVersionUID = 1L;
	
	public void init(FilterConfig fConfig) throws ServletException {
	}
	
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = request.getSession();
		MemberVO membervo = (MemberVO)session.getAttribute("memberVO");
		
		//判斷有無會員登入
		if(membervo != null) {
		//已登入
			chain.doFilter(request, response);
		}else {
		//未登入導向登入頁面
//			request.getRequestDispatcher("j_nono.html").forward(request, response);
//			request.getSession().setAttribute("orginal_URL", request.getRequestURI());
//			System.out.println(request.getRemoteAddr());
			response.sendRedirect("/Front_End/j_signin_member3.html");
		}
		
	}

	


}
