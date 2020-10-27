import java.awt.Color
import java.awt.Rectangle
import java.awt.Robot
import java.awt.event.KeyEvent
import java.io.File
import java.lang.Thread.sleep
import java.security.Key
import java.util.*
import javax.imageio.ImageIO

class Bot {
    private val path: String = "D:\\repos\\CloneHeroBot\\screenshot\\screenshot.jpg"
    private val screenRectangle = Rectangle(589, 919, 741, 78)
    private val robot = Robot()
    private val keys = mutableListOf<() -> Unit>()

    fun play() {
        val image = robot.createScreenCapture(screenRectangle)
        //ImageIO.write(image, "jpg", File(path))
        if (isGreen(Color(image.getRGB(74,40)))) {
            robot.keyPress(KeyEvent.VK_A)
            keys.add { robot.keyRelease(KeyEvent.VK_A) }
        }
        if (isRed(Color(image.getRGB(218,40)))){
            robot.keyPress(KeyEvent.VK_S)
            keys.add { robot.keyRelease(KeyEvent.VK_S) }
        }
        if (isYellow(Color(image.getRGB(370,35)))){
            robot.keyPress(KeyEvent.VK_J)
            keys.add { robot.keyRelease(KeyEvent.VK_J) }
        }
        if (isBlue(Color(image.getRGB(517,40)))){
            robot.keyPress(KeyEvent.VK_K)
            keys.add { robot.keyRelease(KeyEvent.VK_K) }
        }
        if (isOrange(Color(image.getRGB(640,45)))){
            robot.keyPress(KeyEvent.VK_L)
            keys.add { robot.keyRelease(KeyEvent.VK_L) }
        }
        if (keys.isNotEmpty()){
            robot.keyPress(KeyEvent.VK_DOWN)
            robot.keyRelease(KeyEvent.VK_DOWN)
        }
        keys.forEach{it.invoke()}
        keys.clear()

   }
    fun isGreen(color: Color) = color.green > 107

    fun isRed(color: Color) = color.red > 107

    fun isYellow(color: Color) = color.red > 100

    fun isBlue(color: Color) = color.blue > 80

    fun isOrange(color: Color) = color.red > 100
}
