#!/usr/bin/env groovy
import com.cloudbees.groovy.cps.NonCPS
import groovy.transform.Field

import groovy.json.JsonOutput;
import groovy.json.JsonSlurper;
import java.util.regex.Pattern
import static groovy.io.FileType.FILES

// This will work only with multibranch pipelines.

@Field def buildTimestampSlack, commitId, appVersion, projectName = 'product-services-autotests', simpleBranchName

def branchName = env.BRANCH_NAME

properties([
        buildDiscarder([
                $class               : 'EnhancedOldBuildDiscarder',
                artifactDaysToKeepStr: '7',
                artifactNumToKeepStr : '10',
                daysToKeepStr        : '7',
                discardOnlyOnSuccess : false,
                numToKeepStr         : '20',
        ]),
        disableConcurrentBuilds(),
        [$class: 'RebuildSettings', autoRebuild: false, rebuildDisabled: false],
        parameters([
                choice(
                        // choices: ['dev_mashery', 'dev', 'stg_mashery', 'stg', 'prod_mashery', 'prod_eu', 'prod_us'],
                        choices: ['dev', 'stg'],
                        description: '''
            Description
      ''',
                        name: 'environment'),
                choice(
                        //choices: ['regression', 'no_input_data', 'pim_processor', 'kafka_streaming', 'yeezy', 'pim_data'],
                        choices: ['smoke','regression'],
                        description: '''
        Tags description
      ''',
                        name: 'groups'),
        ])
])

node {
    currentBuild.displayName = "#" + (currentBuild.number + "-${params.environment}" + "-${params.groups}")

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/// ----- Stage: Build && Run tests
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    stage('Build && Run tests') {
        try {
            cleanWs()
            checkout scm
            bat "mvn test -Denv=${params.environment} -Dgroups=${params.groups}"
        }
        catch (err) {
            throw err
        }
    }

}