plugins {
    java
    id("com.gradleup.shadow") version "8.3.6"
    id("io.github.intisy.github-gradle") version "1.8.2.1"
}

group = "io.github.thebusybiscuit"
version = "UNOFFICIAL"
description = "A Slimefun addon that adds a variety of plants, fruits, and foods to your server."

github {
    accessToken = System.getenv("GITHUB_TOKEN") ?: ""
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/") // Paper
    maven("https://repo.codemc.org/repository/maven-public/") // bStats
    maven("https://jitpack.io")                               // dough
}

dependencies {
    githubCompileOnly("Slimefun5:Slimefun5:v.5.1.2")

    compileOnly("io.papermc.paper:paper-api:1.21-R0.1-SNAPSHOT")
    compileOnly("io.papermc:paperlib:1.0.8")
    compileOnly("com.google.code.findbugs:jsr305:3.0.2")
    compileOnly("com.github.Slimefun.dough:dough-api:cb22e71335")

    implementation("org.bstats:bstats-bukkit:2.2.1")
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
    }

    processResources {
        filesMatching("plugin.yml") {
            expand("version" to project.version)
        }
    }

    jar {
        enabled = false
    }

    shadowJar {
        archiveFileName.set("ExoticGarden-Continued v${project.version}.jar")

        relocate("org.bstats", "io.github.thebusybiscuit.exoticgarden.bstats")

        exclude("META-INF/**")

        from(rootProject.projectDir) {
            include("LICENSE")
        }
    }

    build {
        dependsOn(shadowJar)
    }
}