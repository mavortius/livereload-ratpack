layout 'layout.gtpl', true,
    bodyContents: contents {
        header {
            h1 'Welcome to Ratpack Application'
        }

        section {
            p "Running in development mode: ${model.development}"
        }
    }
