package com.geektech.testing.youtube.data.converters

import androidx.room.TypeConverter
import com.geektech.testing.youtube.data.model.Item
import com.geektech.testing.youtube.data.model.PageInfo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

object Converter {
    private val gson = Gson()


    @TypeConverter
    fun stringToItems(data: String?): List<Item?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type = object : TypeToken<List<Item?>?>() {}.type
        return gson.fromJson<List<Item?>>(data, listType)
    }

    @TypeConverter
    fun itemsToString(myObjects: List<Item?>?): String? {
        return gson.toJson(myObjects)
    }


    @TypeConverter
    fun pageInfoToString(pageInfo: PageInfo): String? {
        return gson.toJson(pageInfo)
    }

    @TypeConverter
    fun stringToPageInfo(data: String): PageInfo? {
        return gson.fromJson(data, PageInfo::class.java)
    }


}