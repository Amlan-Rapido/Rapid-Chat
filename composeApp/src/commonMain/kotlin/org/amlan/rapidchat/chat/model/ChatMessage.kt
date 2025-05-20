package org.amlan.rapidchat.chat.model

import kotlinx.datetime.LocalDateTime

enum class MessageType {
    TEXT, VOICE
}

enum class Sender {
    USER, OTHER
}

data class ChatMessage(
    val id: String,
    val content: String,
    val timestamp: LocalDateTime,
    val type: MessageType,
    val sender: Sender
)