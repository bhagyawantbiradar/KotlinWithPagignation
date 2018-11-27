package com.example.bhagyantbiradar.kotlincodechallenge.pojos

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SearchResult(
    @SerializedName("Search")
    @Expose
    val search: ArrayList<Search>,
    @SerializedName("totalResults")
    @Expose
    val totalResults: String,
    @SerializedName("Response")
    @Expose
    val response: String
)

@Entity(tableName = "Movie")
data class Search(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("Title")
    @Expose
    val title: String,
    @SerializedName("Year")
    @Expose
    val year: String,
    @SerializedName("imdbID")
    @Expose
    val imdbID: String,
    @SerializedName("Type")
    @Expose
    val type: String,
    @SerializedName("Poster")
    @Expose
    val poster: String
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(year)
        parcel.writeString(imdbID)
        parcel.writeString(type)
        parcel.writeString(poster)
        parcel.writeInt(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Search> {
        override fun createFromParcel(parcel: Parcel): Search {
            return Search(parcel)
        }

        override fun newArray(size: Int): Array<Search?> {
            return arrayOfNulls(size)
        }
    }
}