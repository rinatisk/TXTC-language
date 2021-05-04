package com.github.rinatisk.txtclanguage.listeners

import com.github.rinatisk.txtclanguage.services.ProjectService
import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManagerListener

internal class ProjectManagerListener : ProjectManagerListener {

    override fun projectOpened(project: Project) {
        project.service<ProjectService>()
    }
}
