import org.asciidoctor.gradle.jvm.AsciidoctorTask

plugins {
    id("org.asciidoctor.jvm.convert") version "3.3.2"
}

repositories {
    mavenCentral()
}

version = state
group = "com.github.dmike16.docs"

tasks {
  "asciidoctor"(AsciidoctorTask::class) {
  	asciidoctorj {
  		getModules().getPdf().use()
	}
	baseDirFollowsSourceFile()
    sources(delegateClosureOf<PatternSet> {
      include("curriculum-vitae-doc.adoc")
      include("curriculum-vitae-doc-ita.adoc")
    })
    outputOptions({
    	setBackends(listOf("pdf"))
    })
    attributes(
      mapOf(
        "pdf-themesdir" to "theme",
        "pdf-theme"     to "cvdm",
        "pdf-fontsdir"  to "fonts"
      )
    )
  }
}
