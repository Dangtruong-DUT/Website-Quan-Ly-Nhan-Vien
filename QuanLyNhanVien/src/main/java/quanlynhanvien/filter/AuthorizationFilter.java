package quanlynhanvien.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quanlynhanvien.bean.Account;
import quanlynhanvien.constant.SystemConstant;
import quanlynhanvien.utils.SessionUtil;
/*
 * 
 * gioi han quyen truy cap
 * 
 * */
public class AuthorizationFilter implements Filter {


    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.setContext(filterConfig.getServletContext());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI();
        if (url.startsWith(request.getContextPath()+"/admin")) {
            Account model = (Account) SessionUtil.getInstance().getValue(request, "USERMODEL");
            if (model != null) {
                if (model.getRole().getCode().equals(SystemConstant.ADMIN)) {
                    filterChain.doFilter(servletRequest, servletResponse);
                } else if (model.getRole().getCode().equals(SystemConstant.ADMIN)) {
                    response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login");
                }
            } else {
                response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login");
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }

	public ServletContext getContext() {
		return context;
	}

	public void setContext(ServletContext context) {
		this.context = context;
	}

}
