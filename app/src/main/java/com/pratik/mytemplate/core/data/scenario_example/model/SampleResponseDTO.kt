package com.pratik.mytemplate.core.data.scenario_example.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.pratik.mytemplate.core.domain.scenario_example.model.SampleResponse
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class SampleResponseDTO(
    val name:String,
    val description: String,
    val otherData:String
):Parcelable

fun SampleResponseDTO.convert(): SampleResponse =
    SampleResponse(name = name, description = description)