import java.util.*


fun main() {
    val bot = Bot()
    val timer = java.util.Timer()
    val task = object: TimerTask() {
        override fun run() = bot.play()
    }
    timer.schedule(task, 0, 10)
}