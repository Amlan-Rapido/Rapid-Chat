package org.amlan.rapidchat.chat.viewmodel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.amlan.rapidchat.chat.model.ChatMessage
import org.amlan.rapidchat.chat.model.MessageType
import org.amlan.rapidchat.chat.model.Sender
import kotlin.random.Random

class ChatViewModel {
    private val _messages = MutableStateFlow<List<ChatMessage>>(emptyList())
    val messages: StateFlow<List<ChatMessage>> = _messages.asStateFlow()

    fun sendTextMessage(content: String) {
        val newMessage = ChatMessage(
            id = generateRandomId(), 
            content = content,
            type = MessageType.TEXT,
            timestamp = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()),
            sender = Sender.USER
        )
        _messages.value += newMessage
    }
    
    private fun generateRandomId(): String {
        return Random.nextInt(100000, 999999).toString()
    }
}
