import org.jetbrains.kotlinx.dl.api.core.Sequential
import org.jetbrains.kotlinx.dl.api.core.activation.Activations
import org.jetbrains.kotlinx.dl.api.core.initializer.HeNormal
import org.jetbrains.kotlinx.dl.api.core.initializer.HeUniform
import org.jetbrains.kotlinx.dl.api.core.layer.core.Dense
import org.jetbrains.kotlinx.dl.api.core.layer.core.Input
import org.jetbrains.kotlinx.dl.api.core.layer.weights
import org.jetbrains.kotlinx.dl.api.core.loss.Losses
import org.jetbrains.kotlinx.dl.api.core.metric.Metrics
import org.jetbrains.kotlinx.dl.api.core.optimizer.Adam
import org.jetbrains.kotlinx.dl.dataset.Dataset
import org.jetbrains.kotlinx.dl.dataset.OnHeapDataset


private const val SEED = 12L
private const val TEST_BATCH_SIZE = 1
private const val EPOCHS = 1000
private const val TRAINING_BATCH_SIZE = 1

private val model = Sequential.of(
    Input(2, name = "input_1"),
    Dense(
        20,
        Activations.Relu,
        kernelInitializer = HeNormal(SEED),
        biasInitializer = HeUniform(SEED),
        name = "dense_1"
    ),
    Dense(
        20,
        Activations.Relu,
        kernelInitializer = HeNormal(SEED),
        biasInitializer = HeUniform(SEED),
        name = "dense_2"
    ),
    Dense(1, Activations.Sigmoid, name = "dense_3")
)

fun RogisticRegression() {
    val (train, test) = prepareDataset2().split(0.8)

    model.use {
        it.compile(
            optimizer = Adam(),
            loss = Losses.BINARY_CROSSENTROPY,
            metric = Metrics.ACCURACY
        )

        it.fit(
            dataset = train,
            epochs = EPOCHS,
            batchSize = TRAINING_BATCH_SIZE
        )

        val evaluationResult = it.evaluate(dataset = test, batchSize = TEST_BATCH_SIZE)

        println("evaluationResult: $evaluationResult")
        println("Weights: " + it.getLayer("dense_3").weights["dense_3_dense_kernel"].contentDeepToString())
        println("Bias: " + it.getLayer("dense_3").weights["dense_3_dense_bias"].contentDeepToString())

        repeat(4) { id ->
            val xReal = train.getX(id)
            val yReal = train.getY(id)

            val yPred = it.predictSoftly(xReal)

            println("xReal: ${arrayOf(xReal).contentDeepToString()}, yReal: $yReal, yPred: ${yPred[0]}")
        }
    }
}

fun prepareDataset2(): Dataset {

    val sampleCount = 6
    val x = Array(sampleCount) { FloatArray(2) }
    val y = FloatArray(sampleCount)

    val a_x = arrayOf(floatArrayOf(1.0f,2.0f), floatArrayOf(2.0f, 3.0f), floatArrayOf(3.0f, 1.0f),
                      floatArrayOf(4.0f, 3.0f), floatArrayOf(5.0f, 3.0f), floatArrayOf(6.0f, 2.0f) )
    val a_y = floatArrayOf(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f)


    repeat(sampleCount) {
        x[it][0] = a_x[it][0]
        x[it][1] = a_x[it][1]
        y[it] = a_y[it]
    }

    return OnHeapDataset.create(x, y)
}

fun main(): Unit = RogisticRegression() 

