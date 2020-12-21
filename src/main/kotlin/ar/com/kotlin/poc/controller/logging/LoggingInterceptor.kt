package ar.com.kotlin.poc.controller.logging

import com.google.gson.Gson
import org.apache.commons.io.IOUtils
import org.slf4j.LoggerFactory
import org.springframework.util.StringUtils
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpServletRequest
import org.springframework.web.servlet.ModelAndView
import java.lang.Exception
import java.util.*
import org.springframework.web.util.ContentCachingRequestWrapper
import org.springframework.web.util.ContentCachingResponseWrapper


class LoggingInterceptor : HandlerInterceptorAdapter(){

    private val logger = LoggerFactory.getLogger(LoggingInterceptor::class.java)

    override fun afterCompletion(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?,  exception: Exception?) {
        logger.info(Gson().toJson(ThreadLocalWrapper.getValue().logItem))
    }

    override fun postHandle(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?, modelAndView: ModelAndView?) {
        ThreadLocalWrapper.getValue().logItem.httpCode = response!!.status
    }

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse?, handler: Any?): Boolean {
        ThreadLocalWrapper.getValue().logItem.date = Date()
        ThreadLocalWrapper.getValue().logItem.httpMethod = request.method
        ThreadLocalWrapper.getValue().logItem.address = request.requestURL.toString()
        return true
    }
}