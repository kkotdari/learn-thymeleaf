window.route = function(path) {
    console.log('Routing start')
    fetch(`/routes/${path}`)
        .then(response => {
            console.log('Fetch finished: ', response.ok)
            if (!response.ok) throw new Error('Failed to load content')
            return response.text()
        })
        .then(html => {
            console.log('html: ', html)
            const container = document.getElementById('content-container')
            console.log('container: ', container)
            if (container) {
                container.innerHTML = html
            } else {
                console.error('#content-container not found')
            }
        })
        .catch(error => {
            console.error('Routing error:', error)
        })
}