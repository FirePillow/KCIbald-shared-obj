package com.kcibald.objects

import com.kcibald.objects.impl.MinimizedPostImpl
import com.kcibald.objects.impl.now
import com.kcibald.utils.toURLKey

interface MinimizedPost : ContentBased {
    val title: String
    val urlKey: String
    val sourceRegionURLKey: String
    val commentCount: Int

    companion object {
        fun createDefault(
            title: String,
            urlKey: String,
            content: String,
            author: User,
            commentCount: Int,
            parentRegionUrlKey: String = title.toURLKey(),
            createTimeStamp: Timestamp = now,
            updateTimestamp: Timestamp? = null
        ): MinimizedPost = MinimizedPostImpl(
            title,
            urlKey,
            parentRegionUrlKey,
            commentCount,
            author,
            createTimeStamp,
            updateTimestamp,
            content
        )
    }

}