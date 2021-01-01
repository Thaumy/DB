package Pinn

import kotlinx.coroutines.runBlocking
import net.mamoe.mirai.BotFactory
import net.mamoe.mirai.alsoLogin
import net.mamoe.mirai.Bot
import net.mamoe.mirai.message.data.*
import net.mamoe.mirai.utils.BotConfiguration.MiraiProtocol.ANDROID_PHONE

class BotSender(val Bot: Bot, val melon_socie_id: Long, val melon_univer_id: Long) {
    val Socie = Bot.getGroup(melon_socie_id)
    val Univer = Bot.getGroup(melon_univer_id)
    var can_to_socie = false
    var can_to_univer = false

    val instruList = listOf("/*", "*/", "8=(", "8===> *(")

    fun instruCheck(msg: String): Boolean {
        for (el in instruList) {
            if (msg.contains(el)) {
                return false
            }
        }
        return true
    }

    suspend fun toSocie(msg: String) {
        if (can_to_socie && instruCheck(msg))
            Socie?.sendMessage(msg)
    }

    suspend fun toSocie(msg: Message) {
        if (can_to_socie && instruCheck(msg.content))
            Socie?.sendMessage(msg)
    }

    suspend fun toUniver(msg: String) {
        if (can_to_univer && instruCheck(msg))
            Univer?.sendMessage(msg)
    }

    suspend fun toUniver(msg: Message) {
        if (can_to_univer && instruCheck(msg.content))
            Univer?.sendMessage(msg)
    }
}

fun main(args: Array<String>): Unit = runBlocking {
    val qqId =
    val password = ""

    val Bot = BotFactory.newBot(qqId, password) {
        fileBasedDeviceInfo()
        protocol = ANDROID_PHONE
    }.alsoLogin()

    val sender = BotSender(Bot, , )

    ForwardSwitchTrigger(sender).open()
    ForwardTrigger(sender).open()
    FuckTrigger(sender).open()
    MiyabiTrigger(sender).open()
    SleepTrigger(sender).open()

    Bot.join()
}

