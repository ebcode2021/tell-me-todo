package site.tellmetodo.todoapp.global.auth.filter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import java.io.IOException;

@Slf4j
public class LoginFailHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        String errorMessage = "loginFailHandler::";

        if (e instanceof BadCredentialsException || e instanceof InternalAuthenticationServiceException) {
            errorMessage += "아이디 또는 비밀번호가 일치하지 않습니다.";
        } else if (e instanceof UsernameNotFoundException) {
            errorMessage +="존재하지 않는 아이디 입니다.";
        } else {
            errorMessage += "이 메시지가 보이면 공부를 꽤 잘못한 것입니다.";
        }

        logger.info(errorMessage);

        response.sendRedirect("/login?error");

    }
}
