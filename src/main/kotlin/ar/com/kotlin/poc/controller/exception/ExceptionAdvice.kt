package ar.com.kotlin.poc.controller.exception

import ar.com.kotlin.poc.controller.logging.ThreadLocalWrapper
import org.springframework.core.annotation.Order
import org.springframework.http.HttpHeaders
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import org.springframework.http.HttpStatus
import org.springframework.web.context.request.WebRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ControllerAdvice


@Order(3)
@ControllerAdvice
class ExceptionAdvice: ResponseEntityExceptionHandler() {

    @ExceptionHandler(Exception::class)
    protected fun handleConflict(
        ex: Exception?, request: WebRequest?
    ): ResponseEntity<Any?>? {
        ThreadLocalWrapper.getValue().logItem.stack = ex!!.message.toString()
        ThreadLocalWrapper.getValue().logItem.httpCode = HttpStatus.INTERNAL_SERVER_ERROR.value()
        //TODO Modelar
        val bodyOfResponse = "{\"CODE\":1,\"MESSAGE\":\"OCURRIO UN ERROR\"\"}"
        return handleExceptionInternal(
            ex, bodyOfResponse,
            HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request)
    }
}