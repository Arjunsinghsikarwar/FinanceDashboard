package com.example.FinanceDataProcessing.FinanceProject.JWT;

import com.example.FinanceDataProcessing.FinanceProject.Service.UserDetail.UserDetailService;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;


@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JWTService service;

   @Autowired
   private ApplicationContext context;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String header = request.getHeader("Authorization");
        String userName = null;
        String token = null;

        if(header!=null && header.startsWith("Bearer "))
        {
            token = header.substring(7);
            try{
             userName = service.extractNameToken(token);
            } catch(ExpiredJwtException ex)
            {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setContentType("application/json");
                response.getWriter().write("{\"message\":\"Token expired. Please login again.\"}");
                return;
            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setContentType("application/json");
                response.getWriter().write("{\"message\":\"Invalid token.\"}");
                return;
            }
        }

        if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null)
        {
           UserDetails userDetails = context.getBean(UserDetailService.class).loadUserByUsername(userName);

           if(service.validateToken(token,userDetails))
           {
               UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
               auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

               SecurityContextHolder.getContext().setAuthentication(auth);
           }
           else {
               response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
               response.setContentType("application/json");
               response.getWriter().write("{\"message\":\"Invalid or expired token.\"}");
               return;
           }
        }


    filterChain.doFilter(request,response);
    }
}
