package com.example.myapplication.network

import com.example.myapplication.pref.TokenPref
import okhttp3.Interceptor
import okhttp3.Response

class AuthenticatorInterceptor(val tokenPref: TokenPref) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val builder = original.newBuilder()

        // Adding API_KEY
        val apiKey = tokenPref.getAPIKey()
        apiKey?.let {
            val originalHttpUrl = chain.request().url
            val url = originalHttpUrl.newBuilder().addQueryParameter("api_key", it).build()
            builder.url(url)
        }

        //Adding access token if any
        val accessToken = tokenPref.getAccessToken()
        accessToken?.let {
            builder.addHeader("Authorization", "Bearer $it").build()
        }
        builder.method(original.method, original.body)
        val modifiedRequest = builder.build()
        return chain.proceed(modifiedRequest)
    }
}