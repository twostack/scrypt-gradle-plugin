package org.twostack.gradle

import org.gradle.api.file.DirectoryProperty

interface ScryptPluginExtension {
    val compilerHome: DirectoryProperty
    val contractFolder: DirectoryProperty
    val destinationFolder: DirectoryProperty
}
