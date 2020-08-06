package com.sentientmonkey.yo

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller


@Controller
class MessagingController {
    @MessageMapping("/message")
    @SendTo("/topic/mural")
    @Throws(Exception::class)
    fun send(message: String): String {
        return message
    }
}