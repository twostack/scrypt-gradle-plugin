/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package org.twostack.gradle

import org.gradle.testfixtures.ProjectBuilder
import kotlin.test.Test
import kotlin.test.assertNotNull

/**
 * A simple unit test for the 'org.twostack.gradle.scrypt.greeting' plugin.
 */
class ScryptGradlePluginTest {
    @Test fun `plugin registers task`() {
        // Create a test project and apply the plugin
        val project = ProjectBuilder.builder().build()
        project.plugins.apply("org.twostack.gradle.scrypt")

        // Verify the result
        assertNotNull(project.tasks.findByName("compile"))
    }
}
