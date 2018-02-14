yieldUnescaped '<!--DOCTYPE html-->'
html {
    head {
        meta(charset: 'utf-8')
        title(title)

        link(href: '/images/favicon.ico', rel: 'shortcut icon')
        link(href: '/styles/app.css', rel: 'stylesheet')
    }
    body {

        bodyContents()

        // Include livereload Javascript snippet,
        // if we run in development mode.
        if (model.development) {
            yieldUnescaped """
      <script>
        document.write('<script src="http://' +
           (location.host || 'localhost').split(':')[0] +
           ':35729/livereload.js?snipver=1"></' +
           'script>');
      </script>
      """
        }
    }
}