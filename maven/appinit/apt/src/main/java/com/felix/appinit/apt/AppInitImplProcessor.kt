package com.felix.appinit.apt

import com.felix.appinit.annotation.AppInitImpl
import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import java.lang.reflect.ParameterizedType
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.ProcessingEnvironment
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement
import javax.tools.StandardLocation

class AppInitImplProcessor : AbstractProcessor() {
    override fun init(processingEnv: ProcessingEnvironment?) {
        super.init(processingEnv)
    }

    override fun process(set: Set<TypeElement>, roundEnvironment: RoundEnvironment): Boolean {
        println(
            "=============hmf.process===============${
                roundEnvironment?.getElementsAnnotatedWith(
                    AppInitImpl::class.java
                )
            }"
        )
        return roundEnvironment?.getElementsAnnotatedWith(AppInitImpl::class.java)?.takeIf {
            it.isNotEmpty()
        }?.filter {
            it is TypeElement
        }?.map {
            it as TypeElement
        }?.let { elementList ->
            println("===========hmf elementList=${elementList}==================")
            val className = ClassName("kotlin", "String")
            val arrayList = ClassName("kotlin.collections", "ArrayList")
            arrayList.parameterizedBy(className)
            val sb = StringBuilder(" arrayListOf(")
            sb.append(")")

            val packageName = "com.felix.appinit.apt"
            val fileName = "AptLoader_${hash()}"
            TypeSpec.objectBuilder(fileName).run {
                addFunction(
                    FunSpec.builder("load").also { funSpec ->
                        elementList.forEach {
                            funSpec.addCode(
                                "com.felix.appinit.core.Loader.put(${it.asClassName()}())\r\n"
                            )
                        }
                    }.build()
                )
                build()
            }.let {
                FileSpec.builder(packageName, fileName)
                    .addType(it)
                    .build()
            }
        }.runCatching {
            this?.writeTo(processingEnv.filer)
        }.also {
            it.exceptionOrNull()?.let {
                println(it)
            }
        }.getOrNull()?.let {
            true
        } ?: kotlin.run { false }
    }

    override fun getSupportedSourceVersion(): SourceVersion {
        return SourceVersion.latestSupported()
    }

    override fun getSupportedAnnotationTypes(): Set<String> {
        return hashSetOf(AppInitImpl::class.java.canonicalName)
    }

    fun hash(): String {
        return hash(UUID.randomUUID().toString())
    }

    fun hash(str: String): String {
        return try {
            val md: MessageDigest = MessageDigest.getInstance("MD5")
            md.update(str.toByteArray())
            BigInteger(1, md.digest()).toString(16)
        } catch (e: NoSuchAlgorithmException) {
            Integer.toHexString(str.hashCode())
        }
    }

}