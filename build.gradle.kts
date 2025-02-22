plugins {
    id("fabric-loom") version "1.10-SNAPSHOT"
}

version = project.property("mod_version") as String
group = project.property("maven_group") as String

base {
    archivesName.set(project.property("archives_base_name") as String)
}

repositories {
}

loom {
    splitEnvironmentSourceSets()

    mods {
        register("pycro") {
            sourceSet("main")
            sourceSet("client")
        }
    }

}

dependencies {
    // To change the versions see the gradle.properties file
    minecraft("com.mojang:minecraft:${project.property("minecraft_version")}")
    mappings("net.fabricmc:yarn:${project.property("yarn_mappings")}:v2")
    modImplementation("net.fabricmc:fabric-loader:${project.property("loader_version")}")

    // Fabric API. This is technically optional, but you probably want it anyway.
    modImplementation("net.fabricmc.fabric-api:fabric-api:${project.property("fabric_version")}")
}

tasks.processResources {
    inputs.property("version", project.version)
    inputs.property("loader_version", project.property("loader_version"))
    inputs.property("minecraft_version", project.property("minecraft_version"))

    filesMatching("fabric.mod.json") {
        expand(
            "version" to inputs.properties["version"],
            "loader_version" to inputs.properties["loader_version"],
            "minecraft_version" to inputs.properties["minecraft_version"]
        )
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}

java {
    // Loom will automatically attach sourcesJar to a RemapSourcesJar task and to the "build" task
    // if it is present.
    // If you remove this line, sources will not be generated.
    withSourcesJar()
}

tasks.jar {
    from("LICENSE") {
        rename { "${it}_${project.base.archivesName}" }
    }
}
