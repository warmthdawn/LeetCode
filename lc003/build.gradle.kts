import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
    application
}

group = "com.github.warmthdawn"
version = "1.0-SNAPSHOT"



tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "11"
        apiVersion = "1.3"
        languageVersion = "1.3"
    }
}

application {
    mainClass.set("MainKt")
}