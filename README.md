# A Gradle Plugin for sCrypt
This plugin allows the developer to insert sCrypt compilation directly into their build pipeline.  

# Deploy to Maven Local
Clone this project to a local folder and run the `publishToMavenLocal` task:

```shell
$./gradlew publishToMavenLocal
```

# Configuration
When using the plugin inside your own project, specify the plugin ID and configuration sections
in your `build.gradle ` as follows:

```gradle
plugins {
    id 'org.twostack.gradle.scrypt' version '1.0.0-SNAPSHOT'
}

scrypt {
    compilerHome = file("${System.properties.get("user.home")}/.vscode/extensions/bsv-scrypt.scrypt-1.1.0/")
    contractFolder = file(projectDir.path + "/src/main/scrypt/")
    destinationFolder = file("build/resources")
}
```
*NOTE*: The `contractFolder` and `destinationFolder` settings are optional, and will default to the settings 
in the example above. 


# Invoking the task
To run the gradle task : 
```shell
$./gradlew compileScrypt
```
All of the sCrypt contracts in the `contractFolder` will be compiled and written out to the `destinationFolder`.  
The sCrypt compiler will be invoked with the following equivalent commandline parameters:

```shell
$scryptc compile [source_file] -O --asm -o [output_file]
```



