openModal = (path, width, height) => {
    fetch(path)
        .then(res => {
            if (!res.ok) throw new Error('Affiliate master details search failed')
            return res.text()
        })
        .then(html => {
            const overlay = document.createElement('div')
            overlay.id = 'global-modal-overlay'
            overlay.style.position = 'fixed'
            overlay.style.top = '0'
            overlay.style.left = '0'
            overlay.style.width = '100vw'
            overlay.style.height = '100vh'
            overlay.style.backgroundColor = 'rgba(0, 0, 0, 0.5)'
            overlay.style.display = 'flex'
            overlay.style.alignItems = 'center'
            overlay.style.justifyContent = 'center'
            overlay.style.zIndex = '9999'

            const modal = document.createElement('div')
            modal.style.backgroundColor = 'white'
            modal.style.width = width
            modal.style.height = height
            modal.style.overflowY = 'auto'
            modal.style.borderRadius = '8px'
            modal.style.padding = '20px'
            modal.innerHTML = html

            overlay.appendChild(modal)
            document.body.appendChild(overlay)
            initFlatpickr()
        })
        .catch(err => {
            console.error('affiliate > master > details search error: ', err)
        })
}

closeModal = function () {
    const overlay = document.getElementById('global-modal-overlay')
    if (overlay) {
        overlay.remove()
    }
}