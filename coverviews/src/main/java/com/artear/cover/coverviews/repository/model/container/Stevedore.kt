package com.artear.cover.coverviews.repository.model.container

import com.artear.cover.coverviews.repository.impl.StevedoreDeserializer
import com.google.gson.annotations.JsonAdapter


@JsonAdapter(StevedoreDeserializer::class)
data class Stevedore(val containers: List<Container>)