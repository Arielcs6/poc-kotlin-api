package ar.com.kotlin.poc.controller.logging

object ThreadLocalWrapper {

    private val threadLocal:ThreadLocal<CallContext> = ThreadLocal<CallContext>()

    fun getValue(): CallContext = threadLocal.get()
    fun putValue(callContext: CallContext) = threadLocal.set(callContext)
    fun removeValue() = threadLocal.remove()

}