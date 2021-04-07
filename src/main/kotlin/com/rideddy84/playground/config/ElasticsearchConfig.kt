package com.rideddy84.playground.config

import org.elasticsearch.client.RestHighLevelClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.client.ClientConfiguration
import org.springframework.data.elasticsearch.client.RestClients

@Configuration
class RestClientConfig {
    @Override
    @Bean
    fun elasticsearchClient(): RestHighLevelClient {
        var clientConfiguration =
                ClientConfiguration.builder().connectedTo("localhost:9200").build()

        return RestClients.create(clientConfiguration).rest()
    }
}
