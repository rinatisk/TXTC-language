package com.github.rinatisk.txtclanguage.services

import com.github.rinatisk.txtclanguage.Bundle
import com.intellij.openapi.project.Project

class ProjectService(project: Project) {

    init {
        println(Bundle.message("projectService", project.name))
    }
}
