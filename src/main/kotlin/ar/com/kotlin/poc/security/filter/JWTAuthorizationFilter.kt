package ar.com.kotlin.poc.security.filter

import ar.com.kotlin.poc.controller.logging.CallContext
import ar.com.kotlin.poc.controller.logging.LogItem
import ar.com.kotlin.poc.controller.logging.ThreadLocalWrapper
import ar.com.kotlin.poc.service.TokenService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.util.StringUtils
import org.springframework.security.core.authority.AuthorityUtils

class JWTAuthorizationFilter : OncePerRequestFilter() {

    @Autowired
    lateinit var tokenService: TokenService

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        val jwtToken: String? = request.getHeader("tokenkey")
        ThreadLocalWrapper.putValue(CallContext(LogItem()))
        if(!StringUtils.isEmpty(jwtToken)){
            try{
                var claims = tokenService.validateToken(jwtToken)
                val grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN")
                var authentication = UsernamePasswordAuthenticationToken(claims!!.getClaimValue("userName"),null, grantedAuthorities)
                SecurityContextHolder.getContext().authentication= authentication
                ThreadLocalWrapper.getValue().logItem.userName = authentication.principal.toString()
            } catch (e: Exception ){
                response.status = HttpServletResponse.SC_FORBIDDEN
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "Ocurrio un error")
            }
        }
        filterChain.doFilter(request, response)
    }

}