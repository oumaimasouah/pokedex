@file:Suppress("UnstableApiUsage")
pluginManagement {
  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
    maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
  }
}
dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
    maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
  }
}
rootProject.name = "Pokedex"
include(":app")
include(":benchmark")
include(":core-model")
include(":core-network")
include(":core-database")
include(":core-data")
include(":core-test")