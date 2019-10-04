package com.sksamuel.avro4k.encoder

import com.sksamuel.avro4k.serializer.BigDecimalEncoder
import kotlinx.serialization.ElementValueEncoder
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.modules.SerialModule
import org.apache.avro.Schema
import org.apache.avro.generic.GenericData

class ListEncoder(private val schema: Schema,
                  override val context: SerialModule,
                  private val callback: (GenericData.Array<Any?>) -> Unit) : ElementValueEncoder(),
   BigDecimalEncoder {

   private val list = mutableListOf<Any?>()

   override fun endStructure(desc: SerialDescriptor) {
      val generic = GenericData.Array(schema, list.toList())
      callback(generic)
   }

   override fun fieldSchema(): Schema = schema

   override fun addValue(value: Any) {
      list.add(value)
   }

   override fun encodeString(value: String) {
      list.add(StringToValue.toValue(schema, value))
   }

   override fun encodeLong(value: Long) {
      list.add(value)
   }

   override fun encodeDouble(value: Double) {
      list.add(value)
   }

   override fun encodeBoolean(value: Boolean) {
      list.add(value)
   }

   override fun encodeShort(value: Short) {
      list.add(value)
   }

   override fun encodeByte(value: Byte) {
      list.add(value)
   }

   override fun encodeFloat(value: Float) {
      list.add(value)
   }

   override fun encodeInt(value: Int) {
      list.add(value)
   }
}