plugins {
    `java-library`
    `maven-publish`
}

group = "dev.nandi0813"
version = "2.5.0"
description = "ZonePracticePro Api"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/groups/public/")
}

dependencies {
    compileOnly("org.bukkit:bukkit:1.13.1-R0.1-SNAPSHOT")
    compileOnly("net.kyori:adventure-api:4.26.1")

    compileOnly("org.projectlombok:lombok:1.18.46")
    annotationProcessor("org.projectlombok:lombok:1.18.46")
}

java {
    withSourcesJar()
    withJavadocJar()
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
    options.release = 8
}

tasks.javadoc {
    (options as StandardJavadocDocletOptions).apply {
        encoding = "UTF-8"
        memberLevel = JavadocMemberLevel.PUBLIC
        windowTitle = "ZonePracticePro API $version"
        docTitle = "ZonePracticePro API $version"
        isAuthor = true
        isVersion = true
        isLinkSource = true
        noTimestamp(true)
        bottom("ZonePracticePro API $version · <a href=\"https://github.com/ZoneDevelopement/ZonePracticePro-Api\">GitHub</a>")
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            pom {
                name = "ZonePracticePro API"
                description = "API for ZonePractice Pro addons."
                url = "https://github.com/ZoneDevelopement/ZonePracticePro-Api"
            }
        }
    }
}
