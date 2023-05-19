package CNN

import org.jetbrains.kotlinx.dl.api.core.Sequential
import org.jetbrains.kotlinx.dl.api.core.activation.Activations
import org.jetbrains.kotlinx.dl.api.core.initializer.Constant
import org.jetbrains.kotlinx.dl.api.core.initializer.HeNormal
import org.jetbrains.kotlinx.dl.api.core.layer.convolutional.Conv2D
import org.jetbrains.kotlinx.dl.api.core.layer.convolutional.ConvPadding
import org.jetbrains.kotlinx.dl.api.core.layer.core.Dense
import org.jetbrains.kotlinx.dl.api.core.layer.core.Input
import org.jetbrains.kotlinx.dl.api.core.layer.pooling.MaxPool2D
import org.jetbrains.kotlinx.dl.api.core.layer.reshaping.Flatten
import org.jetbrains.kotlinx.dl.api.core.loss.Losses
import org.jetbrains.kotlinx.dl.api.core.metric.Metrics
import org.jetbrains.kotlinx.dl.api.core.optimizer.Adam
import org.jetbrains.kotlinx.dl.dataset.embedded.NUMBER_OF_CLASSES
import org.jetbrains.kotlinx.dl.dataset.embedded.mnist

private const val EPOCHS = 2
private const val TRAINING_BATCH_SIZE = 100
private const val TEST_BATCH_SIZE = 100
private const val NUM_CHANNELS = 1L
private const val IMAGE_SIZE = 28L
private const val SEED = 12L

private val modernLeNet = Sequential.of(
    Input(IMAGE_SIZE, IMAGE_SIZE, NUM_CHANNELS),
    Conv2D(filters = 32,kernelSize = 5, strides = 1, activation = Activations.Relu, kernelInitializer = HeNormal(SEED),
        biasInitializer = HeNormal(SEED), padding = ConvPadding.SAME),

    MaxPool2D(poolSize = 2, strides = 2,),

    Conv2D(filters = 64, kernelSize = 5, strides = 1,  activation = Activations.Relu, kernelInitializer = HeNormal(SEED),
        biasInitializer = HeNormal(SEED),  padding = ConvPadding.SAME),

    MaxPool2D(poolSize = 2,strides = 2,),

    Flatten(), // 3136
    Dense(outputSize = 512, activation = Activations.Relu,  kernelInitializer = HeNormal(SEED), biasInitializer = Constant(0.1f)),
    Dense(outputSize=NUMBER_OF_CLASSES, activation=Activations.Linear, kernelInitializer=HeNormal(SEED),
        biasInitializer=Constant(0.1f))
)

fun modernLenet() {
    val (train, test) = mnist()

    modernLeNet.use {
        it.compile(optimizer = Adam(learningRate = 0.001f),   loss = Losses.SOFT_MAX_CROSS_ENTROPY_WITH_LOGITS,  metric = Metrics.ACCURACY)
        println("Graph after compilation.")

        it.init()
        var accuracy = it.evaluate(dataset = test, batchSize = TEST_BATCH_SIZE).metrics[Metrics.ACCURACY]
        println("Accuracy before: $accuracy")

        it.fit(dataset = train, epochs = EPOCHS, batchSize = TRAINING_BATCH_SIZE)

        accuracy = it.evaluate(dataset = test, batchSize = TEST_BATCH_SIZE).metrics[Metrics.ACCURACY]
        println("Graph after training and evaluation.")
        println("Accuracy after: $accuracy")

        // Reset the model
        it.reset()
        accuracy = it.evaluate(dataset = test, batchSize = TEST_BATCH_SIZE).metrics[Metrics.ACCURACY]
        println("Accuracy after reset: $accuracy")

        it.fit(dataset = train, epochs = EPOCHS, batchSize = TRAINING_BATCH_SIZE)
        accuracy = it.evaluate(dataset = test, batchSize = TEST_BATCH_SIZE).metrics[Metrics.ACCURACY]
        println("Accuracy after reset and fit: $accuracy")
    }
}

/** */
fun main(): Unit = modernLenet() 

