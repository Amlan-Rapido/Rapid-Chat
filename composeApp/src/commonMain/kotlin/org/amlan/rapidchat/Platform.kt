package org.amlan.rapidchat

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform