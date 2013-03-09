package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

/**
 * Created with IntelliJ IDEA.
 * User: cknox
 * Date: 3/8/13
 */
@WebFilter("/*")
public class SecurityFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        Principal userPrincipal = request.getUserPrincipal();
        // redirect if not logged in, but not if attempting to SpoofLogin
        if(userPrincipal == null && !"/login".equals(request.getServletPath())) {
            String fullPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
            ((HttpServletResponse) response).sendRedirect("http://my.neumont.edu/nuid/service.aspx?ReturnUrl=" + fullPath + "/login");
        }
        else {
            chain.doFilter(req, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
