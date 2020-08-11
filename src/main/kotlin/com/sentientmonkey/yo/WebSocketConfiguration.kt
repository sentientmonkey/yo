package com.sentientmonkey.yo

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer

@Configuration
@EnableWebSocketMessageBroker
class WebSocketConfiguration(
        @Value("\${websocket.relay.enabled:true}") val relayEnabledString: String,
        @Value("\${websocket.relay.host:localhost}") val relayHost: String,
        @Value("\${websocket.relay.port:61613}") val relayPort: Int,
        @Value("\${websocket.client.login:guest}") val clientLogin: String,
        @Value("\${websocket.client.passcode:guest}") val clientPasscode: String
) : WebSocketMessageBrokerConfigurer {

    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        registry.addEndpoint("/websocket-app").withSockJS()
    }

    override fun configureMessageBroker(registry: MessageBrokerRegistry) {
        registry.setApplicationDestinationPrefixes("/app")

        val enableRelay = relayEnabledString.trim().toBoolean()

        if (enableRelay) {
            registry.enableStompBrokerRelay("/topic")
                    .setRelayHost(relayHost)
                    .setRelayPort(relayPort)
                    .setClientLogin(clientLogin)
                    .setClientPasscode(clientPasscode)
        }
    }
}
