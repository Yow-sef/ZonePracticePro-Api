plugins {
    `java-library`
    `maven-publish`
}

group = "dev.nandi0813"
version = "2.3.0"
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
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
    options.release = 8
}

tasks.javadoc {
    setDestinationDir(layout.buildDirectory.dir("javadoc-latest").get().asFile)
    (options as StandardJavadocDocletOptions).apply {
        encoding = "UTF-8"
        memberLevel = JavadocMemberLevel.PUBLIC
        windowTitle = "ZPP"
        isAuthor = true
        isVersion = true
        isLinkSource = true
        noTimestamp(true)
        bottom("<b>Nandi0813, 2024</b>")
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}
