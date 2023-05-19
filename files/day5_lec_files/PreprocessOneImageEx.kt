package preprocessing

import org.jetbrains.kotlinx.dl.api.preprocessing.Operation
import org.jetbrains.kotlinx.dl.api.preprocessing.pipeline
import org.jetbrains.kotlinx.dl.dataset.preprocessing.fileLoader
import org.jetbrains.kotlinx.dl.impl.preprocessing.image.*
import org.jetbrains.kotlinx.dl.impl.preprocessing.onResult
import org.jetbrains.kotlinx.dl.impl.preprocessing.rescale
import org.jetbrains.kotlinx.dl.visualization.swing.ImagePanel
import org.jetbrains.kotlinx.dl.visualization.swing.showFrame
import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO


fun main() {
    val preprocessing = pipeline<BufferedImage>()
        .crop {
            left = 100
            right = 0
            top = 100
            bottom = 0
        }
        .rotate {
            degrees = 0f
        }
        .resize {
            outputWidth = 400
            outputHeight = 400
            interpolation = InterpolationType.NEAREST
        }
        .pad {
            top = 10
            bottom = 40
            left = 10
            right = 10
            mode = PaddingMode.Fill(Color.WHITE)
        }
        .convert { colorMode = ColorMode.BGR }
        .toFloatArray { }
        .rescale {
            scalingCoefficient = 255f
        }

    val imageResource = Operation::class.java.getResource("/datasets/img_data/image2.jpg")
    val image = File(imageResource!!.toURI())
    val (rawImage, shape) = preprocessing.fileLoader().load(image) //420 450 3

    val bufferedImage = ImageConverter.floatArrayToBufferedImage(rawImage, shape, ColorMode.BGR, isNormalized = true)

    showFrame("Filters", ImagePanel(bufferedImage))
} 

