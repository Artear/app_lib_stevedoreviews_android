package com.artear.cover.coverviews.repository.model


import com.artear.cover.coverviews.repository.impl.deserializer.ContainerDeserializer
import com.artear.cover.coveritem.repository.model.block.Block
import com.google.gson.annotations.JsonAdapter

@JsonAdapter(ContainerDeserializer::class)
data class Container(
        val header: ContainerHeader?,
        val style: ContainerStyle?,
        val items: List<Block>
)