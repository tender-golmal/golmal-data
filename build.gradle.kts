import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	`maven-publish`
	id("org.springframework.boot") version "2.4.1"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	kotlin("jvm") version "1.4.21"
	kotlin("plugin.spring") version "1.4.21"
}

var versionMajor= project.property("version.major")?.toString()?:"0"
var versionBuild=project.property("version.build")?.toString()?:"0"
var patchNo=System.getenv("GITHUB_RUN_NUMBER")?.toString()?:"0"
group = "com.golmal"
version = "${versionMajor}.${versionBuild}.${patchNo}"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
	mavenLocal()
}



dependencies {
	implementation("org.springframework.data:spring-data-mongodb")
	implementation("javax.validation:validation-api:2.0.1.Final+")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}
configure<PublishingExtension>{
	repositories {
		maven {
			name = "GitHubPackages"
			url = uri("https://maven.pkg.github.com/tender-golmal/golmal-data")
			credentials {
				username = project.findProperty("gpr.user")?.toString()  ?: System.getenv("USERNAME")
				password = project.findProperty("gpr.key")?.toString() ?: System.getenv("TOKEN")
			}
		}
	}
	publications {
		create<MavenPublication>("gpr") {
			from(components["java"])
		}
	}
}
tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.getByName<Jar>("jar") {
	enabled = true
}
tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {

}