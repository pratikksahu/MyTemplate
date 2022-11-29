package com.pratik.mytemplate.core.data.network.networkHandler

import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class ResultCallAdapterFactory private constructor() : CallAdapter.Factory() {

    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        if (getRawType(returnType) != Call::class.java) {
            return null
        }

        val callType = getParameterUpperBound(0, returnType as ParameterizedType)
        if (getRawType(callType) != ApiResult::class.java) {
            return null
        }

        val resultType = getParameterUpperBound(0, callType as ParameterizedType)
        return ResultCallAdapter(resultType)
    }

    companion object {
        fun create(): ResultCallAdapterFactory = ResultCallAdapterFactory()
    }
}

//class ResultCallAdapterFactory : CallAdapter.Factory() {
//
//    override fun get(
//        returnType: Type,
//        annotations: Array<out Annotation>,
//        retrofit: Retrofit
//    ): CallAdapter<*, *>? {
//        if (getRawType(returnType) != Call::class.java || returnType !is ParameterizedType) {
//            return null
//        }
//        val upperBound = getParameterUpperBound(0, returnType)
//
//        return if (upperBound is ParameterizedType && upperBound.rawType == Result::class.java) {
//            object : CallAdapter<Any, Call<Result<*>>> {
//                override fun responseType(): Type = getParameterUpperBound(0, upperBound)
//
//                override fun adapt(call: Call<Any>): Call<Result<*>> =
//                    ResultCall(call) as Call<Result<*>>
//            }
//        } else {
//            null
//        }
//    }
//}