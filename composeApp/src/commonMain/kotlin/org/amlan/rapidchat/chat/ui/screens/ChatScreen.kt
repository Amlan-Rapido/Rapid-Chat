package org.amlan.rapidchat.chat.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.amlan.rapidchat.chat.ui.components.ChatInputBar
import org.amlan.rapidchat.chat.ui.components.ChatList
import org.amlan.rapidchat.chat.viewmodel.ChatViewModel

@Composable
fun ChatScreen(viewModel: ChatViewModel) {
    val messages by viewModel.messages.collectAsStateWithLifecycle(emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 8.dp)
    ) {
        ChatList(messages = messages, modifier = Modifier.weight(1f))
        ChatInputBar(
            onSend = { viewModel.sendTextMessage(it) },
            modifier = Modifier.fillMaxWidth()
        )
    }
}