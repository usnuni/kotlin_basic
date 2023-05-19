package onnx

import org.jetbrains.kotlinx.dl.api.preprocessing.pipeline
import org.jetbrains.kotlinx.dl.api.summary.printSummary
import org.jetbrains.kotlinx.dl.impl.preprocessing.image.ImageConverter
import org.jetbrains.kotlinx.dl.impl.preprocessing.image.resize
import org.jetbrains.kotlinx.dl.onnx.inference.ONNXModelHub
import org.jetbrains.kotlinx.dl.onnx.inference.ONNXModels
import org.jetbrains.kotlinx.dl.onnx.inference.executionproviders.ExecutionProvider
import org.jetbrains.kotlinx.dl.onnx.inference.inferAndCloseUsing
import org.jetbrains.kotlinx.dl.visualization.swing.createDetectedObjectsPanel
import org.jetbrains.kotlinx.dl.visualization.swing.showFrame
import java.awt.image.BufferedImage
import java.io.File
import java.net.URL

fun getFileFromResource(fileName: String): File {
    val classLoader: ClassLoader = object {}.javaClass.classLoader
    val resource: URL? = classLoader.getResource(fileName)
    return if (resource == null) {
        throw IllegalArgumentException("file not found! $fileName")
    } else {
        File(resource.toURI())
    }
}

fun main() {
    // trained model을 가져올 수 있다.
    val modelHub = ONNXModelHub(File("cache/pretrainedModels"))
    val model = ONNXModels.FaceDetection.UltraFace320.pretrainedModel(modelHub)
    model.printSummary()

    model.inferAndCloseUsing(ExecutionProvider.CPU()){
        val file = getFileFromResource("datasets/multi/1.jpg")
        val image = ImageConverter.toBufferedImage(file)
        val faces = it.detectFaces(image)

        val width = 600
        val resize = pipeline<BufferedImage>().resize {
        }
        showFrame("Detected Faces", createDetectedObjectsPanel(resize.apply(image), faces))
    }

} 

