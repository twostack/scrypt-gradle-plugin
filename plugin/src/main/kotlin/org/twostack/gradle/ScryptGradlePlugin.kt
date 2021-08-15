/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package org.twostack.gradle

import org.gradle.api.Project
import org.gradle.api.Plugin
import org.gradle.api.tasks.Exec
import java.util.*

/**
 * A simple 'hello world' plugin.
 */
class ScryptGradlePlugin: Plugin<Project> {
    override fun apply(project: Project) {
        val extension = project.extensions.create( "scrypt", ScryptPluginExtension::class.java )
        // Register a task
        project.tasks.register("compile") { task ->
            task.doLast {

                project.exec {
                    it.commandLine (extension.getCompilerPath().absolutePath)
                    it.args(listOf("version"))
                }
            }
        }
    }
}
