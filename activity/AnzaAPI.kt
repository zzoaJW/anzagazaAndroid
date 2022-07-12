package com.z0o0a.anzagaza

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AnzaAPI {

    @GET("/station/{route}")
    fun getRouteStations(
        @Path("route") route:String
    ): Call<RouteStationsResponse>

}