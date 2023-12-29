import org.gradle.kotlin.dsl.DependencyHandlerScope

fun DependencyHandlerScope.network() {
    add(
        configurationName = "implementation",
        dependencyNotation = Libraries.retrofit
    )
    add(
        configurationName = "implementation",
        dependencyNotation = Libraries.converterGson
    )
    add(
        configurationName = "implementation",
        dependencyNotation = Libraries.loggingInterceptor
    )
    add(
        configurationName = "implementation",
        dependencyNotation = Libraries.gson
    )
}