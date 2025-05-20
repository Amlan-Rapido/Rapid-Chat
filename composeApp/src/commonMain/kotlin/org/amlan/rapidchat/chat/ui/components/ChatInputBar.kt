package org.amlan.rapidchat.chat.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ChatInputBar(
    onSend: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var input by remember { mutableStateOf("") }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        TextField(
            value = input,
            onValueChange = { input = it },
            modifier = Modifier.weight(1f),
            placeholder = { Text("Type a message") }
        )
        Spacer(Modifier.width(8.dp))
        Button(
            onClick = {
                if (input.isNotBlank()) {
                    onSend(input)
                    input = ""
                }
            }
        ) {
            Text("Send")
        }
    }
}
