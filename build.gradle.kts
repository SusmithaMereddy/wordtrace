plugins {
    id("java")
}

group = "com.susmitha.wordtrace"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.jar {
    from(sourceSets.main.get().output)
    manifest {
        attributes["Main-Class"] = "com.susmitha.wordtrace.WordTraceApp"
    }
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    dependsOn(configurations.runtimeClasspath)

    from({
        configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) }
    })
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("mysql:mysql-connector-java:8.0.33")
    implementation("org.projectlombok:lombok:1.18.36")
    annotationProcessor("org.projectlombok:lombok:1.18.36")
}

tasks.test {
    useJUnitPlatform()
}