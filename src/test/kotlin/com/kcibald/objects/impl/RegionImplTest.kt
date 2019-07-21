package com.kcibald.objects.impl

import com.kcibald.objects.Comment
import com.kcibald.objects.Post
import com.kcibald.objects.Region
import com.kcibald.objects.User
import com.kcibald.utils.toURLKey
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

internal class RegionImplTest {

    val comment = listOf<Comment>(
        CommentImpl(
            User.createDefault(
                "Id",
                "name",
                "name",
                "url",
                "signature"
            ),
            "content",
            now,
            now,
            listOf(
                "attachment1",
                "attachment2"
            ),
            listOf(
                Comment.createDefault(
                    User.createDefault(
                        "Id",
                        "name",
                        "name",
                        "url",
                        "signature"
                    ), "reply1", now, now
                ),
                Comment.createDefault(
                    User.createDefault(
                        "Id",
                        "name",
                        "name",
                        "url",
                        "signature"
                    ), "reply1", now, now
                )
            )
        )
    )

    val posts = listOf(
        Post.createDefault(
            "title",
            User.createDefault(
                "Id",
                "name",
                "name",
                "url",
                "signature"
            ),
            "content",
            "name",
            now,
            now,
            emptyList(),
            comment,
            "title".toURLKey()
        )
    )


    val name = "name"
    val urlKey = name.toURLKey()
    val parent = null
    val description = "description"
    val avatar = "avatars.kcibald.com/kadjfkajd"
    val childRegion = emptyList<Region>()

    val region = RegionImpl(
        name,
        urlKey,
        parent,
        description,
        avatar,
        posts,
        childRegion
    )

    @Test
    fun getTopPosts_hasNoNextPage() {
        val topPosts = region.topPosts
        assertFalse(topPosts.hasNextPage)
    }

    @Test
    fun getTopPosts_currentContent() {
        val topPosts = region.topPosts
        assertEquals(posts, topPosts.currentContent)
    }

    @Test
    fun getName() {
        assertEquals(name, region.name)
    }

    @Test
    fun getUrlKey() {
        assertEquals(urlKey, region.urlKey)
    }

    @Test
    fun getParent() {
        assertEquals(parent, region.parent)
    }

    @Test
    fun getDescription() {
        assertEquals(description, region.description)
    }

    @Test
    fun getAvatar() {
        assertEquals(avatar, region.avatar)
    }

    @Test
    fun getChildRegion() {
        assertEquals(childRegion, region.childRegion)
    }

}