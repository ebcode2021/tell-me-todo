package site.tellmetodo.todoapp.global.auth.filter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @brief 호출 test용 Filter
 */
@Slf4j
public class TestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("TestFilter::호출 시점");

        chain.doFilter(request, response);
    }
}
