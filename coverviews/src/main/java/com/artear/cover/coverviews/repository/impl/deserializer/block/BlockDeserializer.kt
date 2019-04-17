package com.artear.cover.coverviews.repository.impl.deserializer.block

import com.artear.cover.articleitem.BlockContentArticle
import com.artear.cover.banneritem.BlockContentDfp
import com.artear.cover.coveritem.repository.DeserializerUtil.Companion.getDataFromJson
import com.artear.cover.coveritem.repository.DeserializerUtil.Companion.getStyleFromJson
import com.artear.cover.coveritem.repository.DeserializerUtil.Companion.getTypeFromJson
import com.artear.cover.coveritem.repository.model.BlockContent
import com.artear.cover.coveritem.repository.model.block.Block
import com.artear.cover.coveritem.repository.model.block.BlockStyle
import com.artear.cover.coveritem.repository.model.block.BlockType
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type


class BlockDeserializer : JsonDeserializer<Block> {

    override fun deserialize(json: JsonElement, typeOfT: Type?,
                             context: JsonDeserializationContext): Block {

        val style = getStyleFromJson<BlockStyle>(context, json)
        val type = getTypeFromJson<BlockType>(context, json)

        val data = when (type) {
            BlockType.ARTICLE -> getDataFromJson<BlockContentArticle>(context, json)
            BlockType.DFP -> getDataFromJson<BlockContentDfp>(context, json)
//            BlockType.CATEGORY -> getDataFromJson<BlockContentCategory>(context, json)
//            BlockType.MEDIA -> getDataFromJson<BlockContentMedia>(context, json)
            else -> BlockContent()
        }
        return Block(type, style, data)
    }

}

