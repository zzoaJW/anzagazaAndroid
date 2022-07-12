package com.z0o0a.anzagaza

import android.graphics.drawable.Drawable
import com.google.gson.annotations.SerializedName


data class SearchStationBottomDialogHosunData(
    var hosun_img: Int,
    var hosun_txt: String
)

data class SearchStationResultsData(
    var hosun_img: Int,
    var hosun_txt: String
)

data class RouteStationsResponse(
    @SerializedName("stationInfo")var routeStations : List<RouteStations>?
)

data class RouteStations(
    // additionalProp1
    @SerializedName("전철역명")var stationName:String?,
    @SerializedName("호선")var route:String?
)