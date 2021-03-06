plugins {
  kotlin("multiplatform") version "1.7.0"
  id("maven-publish")
}

group = "io.github.ppaanngggg"

version = "0.1.5-SNAPSHOT"

repositories {
  mavenCentral()
  maven("https://maven.pkg.jetbrains.space/public/p/compose/dev/")
}

val osName: String = System.getProperty("os.name")
val targetOs =
    when {
      osName == "Mac OS X" -> "macos"
      osName.startsWith("Win") -> "windows"
      osName.startsWith("Linux") -> "linux"
      else -> error("Unsupported OS: $osName")
    }

var targetArch =
    when (val osArch: String = System.getProperty("os.arch")) {
      "x86_64",
      "amd64" -> "x64"
      "aarch64" -> "arm64"
      else -> error("Unsupported arch: $osArch")
    }

val target = "${targetOs}-${targetArch}"
val skikoVersion = "0.7.22"

kotlin {
  jvm {
    compilations.all { kotlinOptions.jvmTarget = "17" }
    withJava()
  }
  sourceSets {
    val commonMain by getting { dependencies { api("org.jetbrains.skiko:skiko:$skikoVersion") } }
    val commonTest by getting {
      dependencies {
        implementation(kotlin("test-common"))
        implementation(kotlin("test-annotations-common"))
      }
    }
    val jvmMain by getting {
      dependencies { implementation("org.jetbrains.skiko:skiko-awt-runtime-$target:$skikoVersion") }
    }
    val jvmTest by getting {
      dependencies {
        implementation(kotlin("test"))
        implementation(kotlin("test-junit"))
      }
    }
  }
}
