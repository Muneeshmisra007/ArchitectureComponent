package com.mcdar.coroutinesexample.datasource

import com.mcdar.coroutinesexample.datasource.models.Employee
import com.mcdar.coroutinesexample.utils.Const
import com.mcdar.coroutinesexample.utils.Const.BASE_URL
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

object RetrofitServiceProvider {
    val apiService: APIService by lazy {
        return@lazy getRetrofitBuilder().create(APIService::class.java)
    }

    private fun getRetrofitBuilder(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}

interface APIService {

    @GET
    suspend fun getEmployees(@Url url: String): Response<List<Employee>>
}

object RemoteDataSource {

    suspend fun getEmployees(): List<Employee> {
        return RetrofitServiceProvider.apiService.getEmployees(Const.API_URL).let {
            it.body() ?: emptyList()
        }
    }
}


