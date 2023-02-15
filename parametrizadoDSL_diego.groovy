job('ejemplo-job-DSL_diego') {
  description('Job DSL de ejemplo para el curso de Jenkins')
    scm {
    	git('https://github.com/diegocabweb/curso_jenkins.git', 'main') { node ->
      		node / gitConfigName('diegocabweb')
      		node / gitConfigEmail('diegocabweb@gmail.com')
    	}
  	}
	parameters {
    	stringParam('nombre', defaultValue = 'Julian', description = 'Parametro de cadena para el Job Booleano')
    	choiceParam('planeta', ['Mercurio', 'Venus', 'Tierrra', 'Marte', 'Jupiter', 'Saturno', 'Urano', 'Neptuno'])
    	booleanParam('agente', false)
  	}
    triggers {
    		cron('H/7 * * * *')
    }
  	steps {
    		shell("bash jobscript.sh")
    }
  	publishers {
      		mailer('diegocabweb@gmail.com', true, true)
    }
}
