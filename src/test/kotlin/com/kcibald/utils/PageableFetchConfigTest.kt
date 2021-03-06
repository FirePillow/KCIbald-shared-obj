package com.kcibald.utils

import com.kcibald.objects.invoke
import com.kcibald.services.PageableFetchConfig
import com.kcibald.services.defaultPageableFetchConfig
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

internal class PageableFetchConfigTest {

    @Test
    fun testDefault() {
        val target = defaultPageableFetchConfig
        assertEquals(PageableFetchConfig(), target)
    }

    @Test
    fun testDefault_page_count() {
        val target = defaultPageableFetchConfig
        assertEquals(PageableFetchConfig.DEFAULT_POST_PER_PAGE, target.count)
    }

    @Test
    fun testDefault_skip() {
        val target = defaultPageableFetchConfig
        assertEquals(0, target.skip)
    }

    @Test
    fun testDefault_query_mark() {
        val target = defaultPageableFetchConfig
        assertNull(target.queryMark)
    }

    @Test
    fun json() {
        val target = defaultPageableFetchConfig
        PageableFetchConfig.vertxGenFromJson(PageableFetchConfig.vertxGenToJson(target))
    }

}