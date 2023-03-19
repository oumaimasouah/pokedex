package com.github.skydoves.benchmark

import androidx.benchmark.macro.BaselineProfileMode
import androidx.benchmark.macro.CompilationMode
import androidx.benchmark.macro.StartupMode
import androidx.benchmark.macro.StartupTimingMetric
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
@RunWith(AndroidJUnit4ClassRunner::class)
class ColdStartupBenchmark : AbstractStartupBenchmark(StartupMode.COLD)

@RunWith(AndroidJUnit4ClassRunner::class)
class WarmStartupBenchmark : AbstractStartupBenchmark(StartupMode.WARM)

@RunWith(AndroidJUnit4ClassRunner::class)
class HotStartupBenchmark : AbstractStartupBenchmark(StartupMode.HOT)


abstract class AbstractStartupBenchmark(private val startupMode: StartupMode) {
  @get:Rule
  val benchmarkRule = MacrobenchmarkRule()

  @Test
  fun startupNoCompilation() = startup(CompilationMode.None())

  @Test
  fun startupBaselineProfileDisabled() = startup(
    CompilationMode.Partial(baselineProfileMode = BaselineProfileMode.Disable, warmupIterations = 1)
  )

  @Test
  fun startupBaselineProfile() =
    startup(CompilationMode.Partial(baselineProfileMode = BaselineProfileMode.Require))

  @Test
  fun startupFullCompilation() = startup(CompilationMode.Full())

  private fun startup(compilationMode: CompilationMode) = benchmarkRule.measureRepeated(
    packageName = "com.skydoves.pokedex",
    metrics = listOf(StartupTimingMetric()),
    compilationMode = compilationMode,
    iterations = 5,
    startupMode = startupMode,
    setupBlock = {
      pressHome()
    }
  ) {
    startActivityAndWait()
  }
}
