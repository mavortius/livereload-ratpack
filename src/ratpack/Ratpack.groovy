import ratpack.groovy.template.MarkupTemplate
import ratpack.groovy.template.MarkupTemplateModule
import ratpack.render.RenderableDecorator
import ratpack.server.ServerConfig

import static ratpack.groovy.Groovy.groovyMarkupTemplate
import static ratpack.groovy.Groovy.ratpack

ratpack {
    bindings {
        module MarkupTemplateModule

        // Add extra attribute development to the view model.
        // If we run in development mode the value is true otherwise
        // it is false.
        bindInstance RenderableDecorator.of(MarkupTemplate) { context, template ->
            // Get value for development property of server configuration.
            final boolean development = context.get(ServerConfig).development

            new MarkupTemplate(template.name, template.contentType, [development: development] + template.model)
        }
    }

    handlers {
        get {
            render groovyMarkupTemplate("index.gtpl", title: "Ratpack Application")
        }

        files { dir "public" }
    }
}
