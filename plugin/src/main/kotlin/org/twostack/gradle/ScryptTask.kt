package org.twostack.gradle

import org.gradle.api.Action
import org.gradle.api.DefaultTask
import org.gradle.api.Task
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.*
import org.gradle.internal.os.OperatingSystem
import java.io.File

abstract class ScryptTask : DefaultTask() {

    @get:InputDirectory
    @get:Optional
    abstract val contractFolder : DirectoryProperty

    @get:OutputDirectory
    @get:Optional
    abstract val destinationFolder: DirectoryProperty

    @get:InputDirectory
    abstract val compilerHome : DirectoryProperty

    @TaskAction
    fun compileScripts(){
        val compilerPath = File("${compilerHome.get().asFile.absolutePath}/compiler/scryptc/${detectOsName()}/scryptc");

        println("Compiler Location: $compilerPath")
        contractFolder.get().asFile.listFiles().forEach() { file ->
            project.exec { exeSpec ->
                exeSpec.commandLine(compilerPath)
                exeSpec.args(listOf("compile", file.absolutePath, "--asm", "-O", "-o", destinationFolder.get().asFile.absolutePath))
            }
        }
    }

    fun detectOsName() : String {

        val currentOS = OperatingSystem.current()
        if (currentOS.isLinux()){
            return "linux"
        }else if (currentOS.isMacOsX()){
            return "mac"
        }else if (currentOS.isWindows){
            return "win32"
        }

        return "";
    }

}