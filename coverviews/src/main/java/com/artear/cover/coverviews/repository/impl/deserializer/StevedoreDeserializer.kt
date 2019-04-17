package com.artear.cover.coverviews.repository.impl.deserializer

import com.artear.cover.coveritem.repository.getModelList
import com.artear.cover.coverviews.repository.model.Container
import com.artear.cover.coverviews.repository.model.Stevedore
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import timber.log.Timber
import java.lang.reflect.Type

class StevedoreDeserializer : JsonDeserializer<Stevedore> {

    companion object {
        const val CONTAINERS = "containers"
    }

    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Stevedore {
        Timber.d("Start Stevedore Deserialize")
        val containers = json.getModelList(CONTAINERS, context, Container::class)
        return Stevedore(containers)
    }

}

