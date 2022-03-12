package com.example.myapplication.dashboard.model

import android.os.Parcel
import android.os.Parcelable

class MoviesResponse {
    var dates: Dates? = null
    var page = 0f
    var results = ArrayList<Results>()
    var total_pages = 0f
    var total_results = 0f
}

open class Results(
    var id: String? = null,

    var overview: String? = null,

    var original_language: String? = null,

    var original_title: String? = null,

    var video: String? = null,

    var title: String? = null,

    var genre_ids: List<String>? = null,

    var poster_path: String? = null,

    var backdrop_path: String? = null,

    var media_type: String? = null,

    var release_date: String? = null,

    var popularity: String? = null,

    var vote_average: String? = null,

    var adult: String? = null,

    var vote_count: String? = null
): Parcelable {

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(id)
        dest?.writeString(overview)
        dest?.writeString(original_language)
        dest?.writeString(original_title)
        dest?.writeString(video)
        dest?.writeString(title)
        dest?.writeString(poster_path)
        dest?.writeString(backdrop_path)
        dest?.writeString(media_type)
        dest?.writeString(release_date)
        dest?.writeString(popularity)
        dest?.writeString(vote_average)
        dest?.writeString(adult)
        dest?.writeString(vote_count)
    }


    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        arrayListOf(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    companion object CREATOR : Parcelable.Creator<Results> {
        override fun createFromParcel(parcel: Parcel): Results {
            return Results(parcel)
        }

        override fun newArray(size: Int): Array<Results?> {
            return arrayOfNulls(size)
        }
    }

    override fun describeContents(): Int {
        return 0
    }
}

class Dates {
    // Setter Methods
    // Getter Methods
    var maximum: String? = null
    var minimum: String? = null

}