route = (path) => {
    console.log('window > route: path: ', path)
    fetch(`/${path}`)
        .then(res => {
            console.log('window > route: fetch finished: ', res.ok)
            if (!res.ok) {
                throw new Error('Failed to load content')
            }
            return res.text()
        })
        .then(html => {
            document.getElementById('content-container').innerHTML = html
            initFlatpickr()
            initListeners(path)
        })
        .catch(error => {
            console.error('window > route: error:', error)
        })
}