package co.com.touresbalon.foundation.oms.security;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;

/**
 * AuthenticationFilter - 
 * @author javeriana
 */

public class AuthenticationFilter implements Filter {
    
    private static final boolean debug = false;
    private FilterConfig filterConfig = null;
    
    @Inject
    private LoginModel model;
    
    public AuthenticationFilter() {
    }    
    
    private void doBeforeProcessing(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("AuthenticationFilter:DoBeforeProcessing");
        }
    }    
    
    private void doAfterProcessing(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("AuthenticationFilter:DoAfterProcessing");
        }
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        if (debug) {
            log("AuthenticationFilter:doFilter()");
        }
        
        HttpServletRequest req   = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        doBeforeProcessing(req, resp);
        
        try {
            
            if( StringUtils.contains(req.getRequestURI(), "/javax.faces.resource") ||
                StringUtils.equals( req.getRequestURI(), "/OMS-Studio") ||
                StringUtils.equals( req.getRequestURI(), "/OMS-Studio/") ||
                StringUtils.equals( req.getRequestURI(), "/OMS-Studio/login.xhtml") ){
                chain.doFilter(req, resp);
                return;
            }
                
            if( session == null || model == null || !model.isAuthenticated() ){
                resp.sendRedirect("/OMS-Studio/login.xhtml");
                return;
            }
                
            chain.doFilter(req, resp);
            
        } catch (IOException | ServletException t) {
            System.out.println( "Filter Error: " + t.getMessage() );
        }
        
        doAfterProcessing(req, resp);
    }
    

    /**
     * Init method for this filter
     * @param filterConfig
     */
    
    @Override
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {                
                log("AuthenticationFilter: Initializing filter");
            }
        }
    }
    
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }

    @Override
    public void destroy() {
    }
 
}
