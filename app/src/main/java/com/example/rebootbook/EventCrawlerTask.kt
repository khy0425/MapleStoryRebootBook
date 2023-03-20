package com.example.rebootbook

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import java.io.IOException

data class EventItem(val title: String, val imageUrl: String, val url: String)

class EventCrawlerTask(private val context: Context) {
    private val scope = CoroutineScope(Dispatchers.IO)

    fun execute(onComplete: (List<EventItem>) -> Unit) {
        scope.launch {
            val eventItems = mutableListOf<EventItem>()

            try {
                val document = Jsoup.connect("https://maplestory.nexon.com/News/Event").get()
                val eventList = document.select("div.event_board div.event_box")

                for (eventElement: Element in eventList) {
                    val title = eventElement.select("span.title").text()
                    val imageUrl = eventElement.select("img").attr("src")
                    val url = "https://maplestory.nexon.com${eventElement.select("a").attr("href")}"

                    eventItems.add(EventItem(title, imageUrl, url))
                }

            } catch (e: IOException) {
                e.printStackTrace()
            }

            withContext(Dispatchers.Main) {
                onComplete(eventItems)
            }
        }
    }

    fun cancel() {
        scope.cancel()
    }
}
