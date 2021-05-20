package com.mcdar.coroutinesexample.datasource.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Employee(
    var userId: String?,
    var jobTitle: String?,
    var firstName: String?,
    var phoneNumber: String?,
    var emailAddress: String?,
    var lastName: String?,
    var region: String?,
    var employeeCode: String?,
    var imageUrl: String?
) : Parcelable

