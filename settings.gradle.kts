pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        // 国内镜像源 - 华为云Maven仓库
        maven {
            url = uri("https://repo.huaweicloud.com/repository/maven/")
        }
        // 国内镜像源 - 阿里云Maven仓库
        maven {
            url = uri("https://maven.aliyun.com/repository/google/")
        }
        // 国内镜像源 - 腾讯云Maven仓库
        maven {
            url = uri("https://mirrors.cloud.tencent.com/nexus/repository/maven-public/")
        }
        // 国内镜像源 - 华为云代理
        maven {
            url = uri("https://repo1.maven.org/maven2/")
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        // 国内镜像源 - 华为云Maven仓库
        maven {
            url = uri("https://repo.huaweicloud.com/repository/maven/")
        }
        // 国内镜像源 - 阿里云Maven仓库
        maven {
            url = uri("https://maven.aliyun.com/repository/google/")
        }
        // 国内镜像源 - 腾讯云Maven仓库
        maven {
            url = uri("https://mirrors.cloud.tencent.com/nexus/repository/maven-public/")
        }
        // 国内镜像源 - 华为云代理
        maven {
            url = uri("https://repo1.maven.org/maven2/")
        }
        google()
        mavenCentral()
    }
}

rootProject.name = "My Application"
include(":app")
