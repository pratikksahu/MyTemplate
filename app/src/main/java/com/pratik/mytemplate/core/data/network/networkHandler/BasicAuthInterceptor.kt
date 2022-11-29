package com.pratik.mytemplate.core.data.network.networkHandler

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class BasicAuthInterceptor(user: String, password: String) :
    Interceptor {
    private val credentials: String

    init {
        credentials = Credentials.basic(user, password)
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val authenticatedRequest: Request = request.newBuilder()
            .header("Content-Type","application/x-www-form-urlencoded")
            .header("Authorization", credentials).build()
        return chain.proceed(authenticatedRequest)
    }
}