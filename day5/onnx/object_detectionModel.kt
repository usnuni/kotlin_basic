package onnx

import org.jetbrains.kotlinx.dl.api.preprocessing.pipeline
import org.jetbrains.kotlinx.dl.api.summary.printSummary
import org.jetbrains.kotlinx.dl.impl.preprocessing.image.ImageConverter
import org.jetbrains.kotlinx.dl.impl.preprocessing.image.resize
import org.jetbrains.kotlinx.dl.onnx.inference.ONNXModelHub
import org.jetbrains.kotlinx.dl.onnx.inference.ONNXModels
import org.jetbrains.kotlinx.dl.visualization.swing.createDetectedObjectsPanel
import org.jetbrains.kotlinx.dl.visualization.swing.showFrame
import java.awt.image.BufferedImage
import java.io.File

// 상위 20개의 obj만 가져온다, 도 확률도 함께 뽑아서 전달

fun main() {
    val modelHub =
        ONNXModelHub(File("cache/pretrainedModels"))
    val model = ONNXModels.ObjectDetection.SSD.pretrainedModel(modelHub)

    model.use { detectionModel ->

        val file = getFileFromResource("datasets/detection/image2.jpg")
        val image = ImageConverter.toBufferedImage(file)
        val detectedObject = detectionModel.detectObjects(image, 20)

        detectedObject.forEach {
            println("Found ${it.label} with probability ${it.probability}")
        }

        val displayedImage = pipeline<BufferedImage>()
            .resize { outputWidth = 1200; outputHeight = ((1200f / image.width) * image.height).toInt() }
            .apply(image)

        showFrame("Detection result for ${file.name}", createDetectedObjectsPanel(displayedImage, detectedObject ))
    }

} 

