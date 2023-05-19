package transfer

import io.jhdf.HdfFile
import org.jetbrains.kotlinx.dl.api.core.Sequential
import org.jetbrains.kotlinx.dl.api.core.loss.Losses
import org.jetbrains.kotlinx.dl.api.core.metric.Metrics
import org.jetbrains.kotlinx.dl.api.core.optimizer.Adam
import org.jetbrains.kotlinx.dl.api.inference.keras.loadWeights
import org.jetbrains.kotlinx.dl.dataset.OnHeapDataset
import org.jetbrains.kotlinx.dl.dataset.embedded.fashionMnist
import java.io.File

fun loadModelWithWeightsAndEvaluate() {
    val (_, test) = fashionMnist()

    val jsonConfigFile = getJSONConfigFile()
    val model = Sequential.loadModelConfiguration(jsonConfigFile)

    model.use {
        it.compile(
            optimizer = Adam(),
            loss = Losses.SOFT_MAX_CROSS_ENTROPY_WITH_LOGITS,
            metric = Metrics.ACCURACY
        )

        val hdfFile = getWeightsFile()
        it.loadWeights(hdfFile)

        val accuracy = it.evaluate(dataset = test, batchSize = 100).metrics[Metrics.ACCURACY]

        println("Accuracy training $accuracy")
    }
}


fun main(): Unit = loadModelWithWeightsAndEvaluate()


fun getJSONConfigFile(): File {
    val pathToConfig = "datasets/lenet/modelConfig.json"
    val realPathToConfig = OnHeapDataset::class.java.classLoader.getResource(pathToConfig).path.toString()

    return File(realPathToConfig)
}

/** Returns .h5 file with model weights, saved from Keras 2.x. */
fun getWeightsFile(): HdfFile {
    val pathToWeights = "datasets/lenet/mnist_weights_only.h5"
    val realPathToWeights = OnHeapDataset::class.java.classLoader.getResource(pathToWeights).path.toString()
    val file = File(realPathToWeights)
    return HdfFile(file)
} 

