package step05_designPatterns.chain_of_responsibility;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/yourgame")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("게임에 참여하신 여러분을 환영합니다");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("게임을 종료합니다");
    }

    @Override
    public void destroy() {

    }
}
