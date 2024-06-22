package step05_designPatterns.chain_of_responsibility;

import javax.servlet.*;
import java.io.IOException;

public class ChainOfResponsibilityInJava {
    public static void main(String[] args) {
        Filter filter = new Filter() {
            @Override
            public void init(FilterConfig filterConfig) throws ServletException {

            }

            @Override//채이닝 중
            public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
                // TODO 전 처리
                filterChain.doFilter(servletRequest, servletResponse);
                // TODO 후 처리
            }

            @Override
            public void destroy() {

            }
        };
    }
}
