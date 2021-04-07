package com.rideddy84.playground

import com.rideddy84.playground.interfaces.Log
import java.util.Collections.*
import org.elasticsearch.action.index.IndexRequest
import org.elasticsearch.action.index.IndexResponse
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.RestHighLevelClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.elasticsearch.core.*
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {
    companion object : Log

    @Autowired private lateinit var highLevelClient: RestHighLevelClient

    @RequestMapping("/")
    fun index(): String {
        var request: IndexRequest =
                IndexRequest("spring-data", "elasticsearch", "abc")
                        .source(singletonMap("feature", "high-level-rest-client"))

        var response: IndexResponse = highLevelClient.index(request, RequestOptions.DEFAULT)
        logger.info(response.toString())

        return "Welcome home."
    }
}
