plugins {
    id("application")
    id("java")
    id("com.github.ben-manes.versions") version "0.51.0"
    id("org.sonarqube") version "7.2.2.6593"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("hexlet.code.App")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}
tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

sonar {
  properties {
    property("sonar.projectKey", "Trylave_java-project-61")
    property("sonar.organization", "trylave")
  }
}
