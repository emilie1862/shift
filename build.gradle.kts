// build.gradle.kts

import org.jetbrains.kotlin.gradle.dsl.Coroutines
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "Example"
version = "1.0-SNAPSHOT"

val ktor_version = "1.2.2"

plugins {
    application
    kotlin("jvm") version "1.3.40"
}

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<KotlinCompile>().all {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClassName = "TestAppKt"
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile("io.ktor:ktor-server-netty:$ktor_version")
    implementation("io.ktor:ktor-gson:$ktor_version")
    compile("ch.qos.logback:logback-classic:1.2.3")
    compile("com.fasterxml.jackson.core:jackson-databind:2.9.8")
    compile("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.7")
    testCompile(group = "junit", name = "junit", version = "4.12")
}
