package com.sentientmonkey.yo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class YoApplication

fun main(args: Array<String>) {
	runApplication<YoApplication>(*args)
}
