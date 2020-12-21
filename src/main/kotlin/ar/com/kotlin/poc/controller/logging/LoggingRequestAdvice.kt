package ar.com.kotlin.poc.controller.logging

import com.google.gson.Gson
import org.springframework.core.MethodParameter
import org.springframework.core.annotation.Order
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter
import org.springframework.http.converter.HttpMessageConverter

import org.springframework.http.HttpInputMessage
import java.lang.reflect.Type


@Order(1)
@ControllerAdvice
class LoggingRequestAdvice: RequestBodyAdviceAdapter() {

    override fun supports(
        methodParameter: MethodParameter,
        targetType: Type,
        converterType: Class<out HttpMessageConverter<*>>
    ): Boolean {
        return true
    }

    override fun afterBodyRead(
        body: Any?, inputMessage: HttpInputMessage?, parameter: MethodParameter?,
        targetType: Type?, converterType: Class<out HttpMessageConverter<*>?>?
    ): Any? {
        ThreadLocalWrapper.getValue().logItem.request = Gson().toJson(body)
        return body
    }

}