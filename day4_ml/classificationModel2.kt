package ml

import org.jetbrains.kotlinx.dl.api.core.Sequential
import org.jetbrains.kotlinx.dl.api.core.activation.Activations
import org.jetbrains.kotlinx.dl.api.core.initializer.HeNormal
import org.jetbrains.kotlinx.dl.api.core.initializer.Zeros
import org.jetbrains.kotlinx.dl.api.core.layer.core.Dense
import org.jetbrains.kotlinx.dl.api.core.layer.core.Input
import org.jetbrains.kotlinx.dl.api.core.layer.reshaping.Reshape
import org.jetbrains.kotlinx.dl.api.core.loss.Losses
import org.jetbrains.kotlinx.dl.api.core.metric.Metrics
import org.jetbrains.kotlinx.dl.api.core.optimizer.Adam
import org.jetbrains.kotlinx.dl.dataset.embedded.mnist


private const val SEED = 12L
private const val TEST_BATCH_SIZE = 1000
private const val EPOCHS = 3
private const val TRAINING_BATCH_SIZE = 500

private val model = Sequential.of(
    Input(28, 28, 1),
    Reshape(listOf(784)),
    Dense(256, Activations.Relu, HeNormal(SEED), Zeros()),
    Dense(128, Activations.Relu, HeNormal(SEED), Zeros()),

    /*
     softmax 아니고 linear 써야 한다. 마지막레이어 (클래스 10개니까 사이즈는 10)
     이 다름 밑에서 softmax + cross entropy 적용
     */
    Dense(10, Activations.Linear, HeNormal(SEED), Zeros())
    )

fun denseOnly(){
    val (train, test) = mnist()

    model.use {
        it.compile(Adam(), Losses.SOFT_MAX_CROSS_ENTROPY_WITH_LOGITS, Metrics.ACCURACY)
        it.fit(train, EPOCHS, TRAINING_BATCH_SIZE)

        val accuracy = it.evaluate(test, TEST_BATCH_SIZE).metrics[Metrics.ACCURACY]

        println("accuracy: $accuracy")
    }
}

fun main():Unit = denseOnly()

