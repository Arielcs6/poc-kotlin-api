package ar.com.kotlin.poc.controller.logging

import com.google.gson.Gson
import org.springframework.core.MethodParameter
import org.springframework.core.annotation.Order
import org.springframework.http.HttpInputMessage
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice
import java.lang.reflect.Type
import org.springframework.http.server.ServletServerHttpResponse

import org.springframework.http.server.ServletServerHttpRequest
import org.springframework.lang.Nullable

@Order(2)
@ControllerAdvice
class LoggingResponseAdvice: ResponseBodyAdvice<Object> {

    override fun supports(methodParameter: MethodParameter?, aClass: Class<out HttpMessageConverter<*>?>?): Boolean {
        return true
    }

    override fun beforeBodyWrite(
        body: Object?,
        returnType: MethodParameter,
        selectedContentType: MediaType,
        selectedConverterType: Class<out HttpMessageConverter<*>>,
        request: ServerHttpRequest,
        response: ServerHttpResponse
    ): Object? {
        ThreadLocalWrapper.getValue().logItem.response = Gson().toJson(body)
        return body
    }


}