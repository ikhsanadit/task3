package com.qtnkm.ligalawak.network

import com.google.gson.annotations.SerializedName

data class ApiResponse(

	@field:SerializedName("sports")
	val sports: List<SportsItem>
)

data class SportsItem(

	@field:SerializedName("idSport")
	val idSport: String?,

	@field:SerializedName("strFormat")
	val strFormat: String?,

	@field:SerializedName("strSport")
	val strSport: String?,

	@field:SerializedName("strSportIconGreen")
	val strSportIconGreen: String?,

	@field:SerializedName("strSportThumb")
	val strSportThumb: String?,

	@field:SerializedName("strSportDescription")
	val strSportDescription: String?
)
