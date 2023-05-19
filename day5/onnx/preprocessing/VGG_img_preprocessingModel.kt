package preprocessing

import org.jetbrains.kotlinx.dl.api.core.Sequential
import org.jetbrains.kotlinx.dl.api.core.WritingMode
import org.jetbrains.kotlinx.dl.api.core.activation.Activations
import org.jetbrains.kotlinx.dl.api.core.initializer.HeNormal
import org.jetbrains.kotlinx.dl.api.core.initializer.HeUniform
import org.jetbrains.kotlinx.dl.api.core.layer.convolutional.Conv2D
import org.jetbrains.kotlinx.dl.api.core.layer.convolutional.ConvPadding
import org.jetbrains.kotlinx.dl.api.core.layer.core.Dense
import org.jetbrains.kotlinx.dl.api.core.layer.core.Input
import org.jetbrains.kotlinx.dl.api.core.layer.pooling.MaxPool2D
import org.jetbrains.kotlinx.dl.api.core.layer.reshaping.Flatten
import org.jetbrains.kotlinx.dl.api.core.loss.Losses
import org.jetbrains.kotlinx.dl.api.core.metric.Metrics
import org.jetbrains.kotlinx.dl.api.core.optimizer.Adam
import org.jetbrains.kotlinx.dl.api.preprocessing.pipeline
import org.jetbrains.kotlinx.dl.dataset.OnFlyImageDataset
import org.jetbrains.kotlinx.dl.dataset.embedded.dogsCatsDatasetPath
import org.jetbrains.kotlinx.dl.dataset.generator.FromFolders
import org.jetbrains.kotlinx.dl.impl.preprocessing.image.*
import org.jetbrains.kotlinx.dl.impl.preprocessing.rescale
import java.awt.image.BufferedImage
import java.io.File

private const val PATH_TO_MODEL = "savedmodels/vgg11"
private const val EPOCHS = 3
private const val TRAINING_BATCH_SIZE = 32
private const val TEST_BATCH_SIZE = 256
private const val NUM_LABELS = 2
private const val NUM_CHANNELS = 3L
private const val IMAGE_SIZE = 64L
private const val TRAIN_TEST_SPLIT_RATIO = 0.8

private val vgg11 = Sequential.of(
    Input(IMAGE_SIZE, IMAGE_SIZE, NUM_CHANNELS),
    Conv2D(filters = 32, kernelSize = intArrayOf(3, 3), strides = intArrayOf(1, 1, 1, 1), activation = Activations.Relu,
        kernelInitializer = HeNormal(), biasInitializer = HeNormal(), padding = ConvPadding.SAME),
    MaxPool2D(poolSize = intArrayOf(1, 2, 2, 1), strides = intArrayOf(1, 2, 2, 1)),

    Conv2D(filters = 64, kernelSize = intArrayOf(3, 3),strides = intArrayOf(1, 1, 1, 1), activation = Activations.Relu,
        kernelInitializer = HeNormal(),biasInitializer = HeNormal(), padding = ConvPadding.SAME),
    MaxPool2D(poolSize = intArrayOf(1, 2, 2, 1), strides = intArrayOf(1, 2, 2, 1)),

    Conv2D(filters = 128, kernelSize = intArrayOf(3, 3),strides = intArrayOf(1, 1, 1, 1), activation = Activations.Relu,
        kernelInitializer = HeNormal(), biasInitializer = HeNormal(), padding = ConvPadding.SAME),
    Conv2D(filters = 128, kernelSize = intArrayOf(3, 3), strides = intArrayOf(1, 1, 1, 1),activation = Activations.Relu,
        kernelInitializer = HeNormal(), biasInitializer = HeNormal(),padding = ConvPadding.SAME),
    MaxPool2D(poolSize = intArrayOf(1, 2, 2, 1),  strides = intArrayOf(1, 2, 2, 1)),

    Conv2D(filters = 256, kernelSize = intArrayOf(3, 3), strides = intArrayOf(1, 1, 1, 1), activation = Activations.Relu,
        kernelInitializer = HeNormal(), biasInitializer = HeNormal(),  padding = ConvPadding.SAME),
    Conv2D(filters = 256,kernelSize = intArrayOf(3, 3), strides = intArrayOf(1, 1, 1, 1),  activation = Activations.Relu,
        kernelInitializer = HeNormal(), biasInitializer = HeNormal(), padding = ConvPadding.SAME),
    MaxPool2D(poolSize = intArrayOf(1, 2, 2, 1),strides = intArrayOf(1, 2, 2, 1)),

    Conv2D(filters = 256, kernelSize = intArrayOf(3, 3), strides = intArrayOf(1, 1, 1, 1),  activation = Activations.Relu,
        kernelInitializer = HeNormal(), biasInitializer = HeNormal(), padding = ConvPadding.SAME),
    Conv2D(filters = 256, kernelSize = intArrayOf(3, 3),strides = intArrayOf(1, 1, 1, 1), activation = Activations.Relu,
        kernelInitializer = HeNormal(),  biasInitializer = HeNormal(),    padding = ConvPadding.SAME ),
    MaxPool2D( poolSize = intArrayOf(1, 2, 2, 1),     strides = intArrayOf(1, 2, 2, 1) ),
    Flatten(),

    Dense(
        outputSize = 1024,
        activation = Activations.Relu,
        kernelInitializer = HeNormal(),
        biasInitializer = HeUniform()
    ),
    Dense(
        outputSize = 512,
        activation = Activations.Relu,
        kernelInitializer = HeNormal(),
        biasInitializer = HeUniform()
    ),
    Dense(
        outputSize = NUM_LABELS,
        activation = Activations.Linear,
        kernelInitializer = HeNormal(),
        biasInitializer = HeUniform()
    )
)


fun main() {
    val preprocessing = pipeline<BufferedImage>()
        .resize {
            outputHeight = IMAGE_SIZE.toInt()
            outputWidth = IMAGE_SIZE.toInt()
            interpolation = InterpolationType.NEAREST
        }
        .convert { colorMode = ColorMode.BGR }
        .toFloatArray { }
        .rescale {
            scalingCoefficient = 255f
        }

    val dogsCatsImages = dogsCatsDatasetPath()
    val dataset = OnFlyImageDataset.create(
        File(dogsCatsImages),
        FromFolders(mapping = mapOf("cat" to 0, "dog" to 1)),
        preprocessing
    ).shuffle()
    val (train, test) = dataset.split(TRAIN_TEST_SPLIT_RATIO)

    vgg11.use {
        it.compile(
            optimizer = Adam(),
            loss = Losses.SOFT_MAX_CROSS_ENTROPY_WITH_LOGITS,
            metric = Metrics.ACCURACY
        )

        val start = System.currentTimeMillis()
        it.fit(dataset = train, epochs = EPOCHS, batchSize = TRAINING_BATCH_SIZE)
        println("Training time: ${(System.currentTimeMillis() - start) / 1000f}")

        it.save(File(PATH_TO_MODEL), writingMode = WritingMode.OVERRIDE)

        val accuracy = it.evaluate(dataset = test, batchSize = TEST_BATCH_SIZE).metrics[Metrics.ACCURACY]

        println("Accuracy: $accuracy")
    }
}
 

