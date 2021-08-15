package org.twostack.gradle

import org.gradle.api.provider.Property
import org.gradle.internal.os.OperatingSystem
import java.io.File

abstract class ScryptPluginExtension {
    abstract val compilerHome : Property<String>
    abstract val osName : Property<String>

    init {
        compilerHome.convention( "")
        detectOsName()
    }

    fun detectOsName(){

       val currentOS = OperatingSystem.current()
        if (currentOS.isLinux()){
            osName.convention("linux")
        }else if (currentOS.isMacOsX()){
            osName.convention("mac")
        }else if (currentOS.isWindows){
            osName.convention("win32")
        }

    }

    fun getCompilerPath() : File{
       return File("${compilerHome.get()}/compiler/scryptc/${osName.get()}/scryptc");
    }
}
